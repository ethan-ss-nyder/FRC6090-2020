package frc.robot.swerveio;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;

public class NeoSwerveModule extends MultiEncoderModule {
    private CANSparkMax driveMotor, pivotMotor;
    private Encoder analogEncoder;

    private EncoderSetting currentlySetEncoder;
    public NeoSwerveModule (int driveCanId, int pivotCanId, int analogEncoderChannelA, int analogEncoderChannelB) {
        driveMotor = new CANSparkMax(driveCanId, MotorType.kBrushless);
        pivotMotor = new CANSparkMax(pivotCanId, MotorType.kBrushless);
        analogEncoder = new Encoder(analogEncoderChannelA, analogEncoderChannelB);
        setEncoder(EncoderSetting.ANALOG);
    }


    @Override
    public void setEncoder(EncoderSetting encoder) {
        currentlySetEncoder = encoder;
    }

    @Override
    public EncoderSetting getEncoderSetting() {
        return currentlySetEncoder;
    }

    @Override
    public void setPivotMotorSpeed(double speed) {
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
        switch (currentlySetEncoder) {
            case ANALOG:
                return analogEncoder.get();
            case SPARK_MAX:
                return pivotMotor.getEncoder().getPosition();
            default:
                return 0;
        }
    }

    @Override
    public double getDriveMotorEncoder() {
        return driveMotor.getEncoder().getPosition();
    }

    @Override
    public void zeroPivotEncoder() {
        pivotMotor.getEncoder().setPosition(0);
        analogEncoder.reset();
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
}