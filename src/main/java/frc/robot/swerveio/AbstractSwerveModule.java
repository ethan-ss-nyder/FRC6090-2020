package frc.robot.swerveio;

public interface AbstractSwerveModule {
    public void setPivotMotorSpeed(double speed);
    public void setDriveMotorSpeed(double speed);

    public double getPivotMotorSpeed();
    public double getDriveMotorSpeed();

    public double getPivotMotorEncoder();
    public double getDriveMotorEncoder();

    public void zeroPivotEncoder();
    public void zeroDriveEncoder();

    public void stopPivotMotor();
    public void stopDriveMotor();
}