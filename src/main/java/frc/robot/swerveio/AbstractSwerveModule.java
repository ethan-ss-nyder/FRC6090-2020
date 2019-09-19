package frc.robot.swerveio;

public abstract class AbstractSwerveModule {
    public abstract void setPivotMotorSpeed(double speed);
    public abstract void setDriveMotorSpeed(double speed);

    public abstract double getPivotMotorSpeed();
    public abstract double getDriveMotorSpeed();

    public abstract double getPivotMotorEncoder();
    public abstract double getDriveMotorEncoder();

    public abstract void zeroPivotEncoder();
    public abstract void zeroDriveEncoder();

    public abstract void stopPivotMotor();
    public abstract void stopDriveMotor();

    public final void stop() {
        stopPivotMotor();
        stopDriveMotor();
    }
}