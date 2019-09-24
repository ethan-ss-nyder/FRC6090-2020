package frc.robot.swerveio;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;

public class NeoSwerveModule extends AbstractSwerveModule implements MultiEncoderModule {
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
        pivotMotor.stopMotor();
    }

    @Override
    public void stopDriveMotor() {
        driveMotor.stopMotor();
    }
}