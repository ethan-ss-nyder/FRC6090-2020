package frc.robot.swerveio;

public abstract class MultiEncoderModule extends AbstractSwerveModule {
    public static enum EncoderSetting {
        ANALOG, SPARK_MAX
    }
    public abstract void setEncoder(EncoderSetting encoder);
    public abstract EncoderSetting getEncoderSetting();
}