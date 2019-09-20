package frc.robot.swerveio;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class NeoSwerveModule extends AbstractSwerveModule implements MultiEncoderModule {
    private CANSparkMax driveMotor;
    public NeoSwerveModule (int canId) {
        driveMotor = new CANSparkMax (canId, MotorType.kBrushless);
    }


    @Override
    public void switchEncoder() {
        // TODO Auto-generated method stub

    }

    @Override
    public Encoder getEncoder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPivotMotorSpeed(double speed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDriveMotorSpeed(double speed) {
        // TODO Auto-generated method stub

    }

    @Override
    public double getPivotMotorSpeed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getDriveMotorSpeed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getPivotMotorEncoder() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getDriveMotorEncoder() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void zeroPivotEncoder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void zeroDriveEncoder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void stopPivotMotor() {
        // TODO Auto-generated method stub

    }

    @Override
    public void stopDriveMotor() {
        // TODO Auto-generated method stub

    }
}