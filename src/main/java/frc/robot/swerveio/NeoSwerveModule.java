package frc.robot.swerveio;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

public class NeoSwerveModule extends AbstractSwerveModule {
    private CANSparkMax driveMotor, pivotMotor;

    private CANPIDController pivotPid;

    private boolean setPivotIdleMode = false;

    public NeoSwerveModule (int driveCanId, int pivotCanId) {
        driveMotor = new CANSparkMax(driveCanId, MotorType.kBrushless);
        pivotMotor = new CANSparkMax(pivotCanId, MotorType.kBrushless);
        pivotMotor.setOpenLoopRampRate(0);
        pivotMotor.setIdleMode(IdleMode.kCoast);

        pivotPid = pivotMotor.getPIDController();
        pivotPid.setP(0.1);
        pivotPid.setI(1e-4);
        pivotPid.setD(1);
        pivotPid.setIZone(0);
        pivotPid.setFF(0);
        pivotPid.setOutputRange(-1, 1);
    }

    @Override
    public void setPivotMotorSpeed(double speed) {
        if (!setPivotIdleMode) {
            zeroPivotEncoder();
            pivotMotor.setIdleMode(IdleMode.kBrake);
            setPivotIdleMode = true;
        }
        pivotMotor.set(speed);
    }

    @Override
    public void setDriveMotorSpeed(double speed) {
        driveMotor.set(speed);
    }

    @Override
    public double getPivotMotorSpeed() {
        return pivotMotor.get();
    }

    @Override
    public double getDriveMotorSpeed() {
        return driveMotor.get();
    }

    @Override
    public double getPivotMotorEncoder() {
        return pivotMotor.getEncoder().getPosition();
    }

    @Override
    public double getDriveMotorEncoder() {
        return driveMotor.getEncoder().getPosition();
    }

    @Override
    public void zeroPivotEncoder() {
        pivotMotor.getEncoder().setPosition(0);
    }

    @Override
    public void zeroDriveEncoder() {
        driveMotor.getEncoder().setPosition(0);

    }

    @Override
    public void stopPivotMotor() {
        pivotMotor.stopMotor();
    }

    @Override
    public void stopDriveMotor() {
        driveMotor.stopMotor();
    }

    @Override
    public void setPivotReference(double ref) {
        pivotPid.setReference(ref, ControlType.kPosition);
    }

    @Override
    public void setDriveReference(double ref) {
        throw new UnsupportedOperationException("setDriveReference() is not implemented for NeoSwerveModule!");
    }
}