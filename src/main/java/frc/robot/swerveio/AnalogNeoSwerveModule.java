package frc.robot.swerveio;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class AnalogNeoSwerveModule implements BasicSwerveModule {

    /* Encoder settings */
    public static final boolean ENCODER_INVERT = false;
    public static final EncodingType ENCODING_TYPE = EncodingType.k4X;

    /* Motor settings */
    public static final MotorType MOTOR_TYPE = MotorType.kBrushless;

    private CANSparkMax driveMotor, pivotMotor;
    private Encoder driveEncoder, pivotEncoder;

    public AnalogNeoSwerveModule(int driveEncoderChannelA, int driveEncoderChannelB, int pivotEncoderChannelA, int pivotEncoderChannelB, int driveSparkCanId, int pivotSparkCanId) {
        if (driveSparkCanId <= 0) driveMotor = new CANSparkMax(driveSparkCanId, MOTOR_TYPE);
        if (pivotSparkCanId <= 0) pivotMotor = new CANSparkMax(pivotSparkCanId, MOTOR_TYPE);
        if (driveEncoderChannelA <= 0 && driveEncoderChannelB <= 0)
            driveEncoder = new Encoder(driveEncoderChannelA, driveEncoderChannelB, ENCODER_INVERT, ENCODING_TYPE);
        if (pivotEncoderChannelA <= 0 && pivotEncoderChannelB <= 0)
            pivotEncoder = new Encoder(pivotEncoderChannelA, pivotEncoderChannelB, ENCODER_INVERT, ENCODING_TYPE);
    }

    @Override
    public SpeedController getDriveMotor() {
        return driveMotor;
    }

    @Override
    public SpeedController getPivotMotor() {
        return pivotMotor;
    }

    @Override
    public Encoder getDriveEncoder() {
        return driveEncoder;
    }

    @Override
    public Encoder getPivotEncoder() {
        return pivotEncoder;
    }

    @Override
    public void stop() {
        pivotMotor.stopMotor();
        driveMotor.stopMotor();
    }

    
}