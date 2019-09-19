package frc.robot.swerveio;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public interface BasicSwerveModule {
    public SpeedController getDriveMotor();
    public SpeedController getPivotMotor();
    public Encoder getDriveEncoder();
    public Encoder getPivotEncoder();
    public void stop();
}