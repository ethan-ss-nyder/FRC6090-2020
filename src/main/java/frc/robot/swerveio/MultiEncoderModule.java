package frc.robot.swerveio;

public interface MultiEncoderModule {
    public static enum Encoder {
        ANALOG, SPARK_MAX
    }
    public void setEncoder(Encoder encoder);
    public Encoder getEncoder();
}