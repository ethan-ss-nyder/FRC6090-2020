package frc.robot.swerveio;

public interface MultiEncoderModule {
    public static enum EncoderSetting {
        ANALOG, SPARK_MAX
    }
    public void setEncoder(EncoderSetting encoder);
    public EncoderSetting getEncoderSetting();
}