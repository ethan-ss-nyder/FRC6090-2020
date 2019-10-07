package frc.robot.swerveio;

/**
 * A swerve module that has multiple sources of encoder input, this
 * usually is useful when an analog encoder is added to a module that
 * already has encoders in the motor controller. This interface allows
 * switching between encoders so that the getEncoder functions can return
 * the proper reading.
 * @author Jordan Bancino
 */
public abstract class MultiEncoderModule extends AbstractSwerveModule {
    public static enum EncoderSetting {
        ANALOG, SPARK_MAX
    }
    public abstract void setEncoder(EncoderSetting encoder);
    public abstract EncoderSetting getEncoderSetting();
}