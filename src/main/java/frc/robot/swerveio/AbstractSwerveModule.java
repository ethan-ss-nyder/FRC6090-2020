package frc.robot.swerveio;

/**
 * A swerve module definition that swerve drive implementations
 * should use to drive a module. These methods should be standardized
 * and implemented similarly across variations in motor controllers
 * and motors. This class is the sole abstraction layer between the
 * hardware-specific API and the SwerveIO API.
 * @author Jordan Bancino
 */
public abstract class AbstractSwerveModule {

    /**
     * Set the speed of the pivot motor. A negative value
     * is the reverse direction.
     * @param speed The speed to set the motor to.
     */
    public abstract void setPivotMotorSpeed(double speed);

    /**
     * Set the speed of the drive motor. A negative value
     * is the reverse direction.
     * @param speed The speed to set the motor to.
     */
    public abstract void setDriveMotorSpeed(double speed);

    /**
     * Get the currently set speed of the pivot motor.
     * @return The speed of the motor.
     */
    public abstract double getPivotMotorSpeed();

    /**
     * Get the currently set speed of the drive motor.
     * @return The speed of the motor.
     */
    public abstract double getDriveMotorSpeed();

    /**
     * Get an encoder reading from the pivot motor.
     * @return A raw encoder reading.
     */
    public abstract double getPivotMotorEncoder();

    /**
     * Get an encoder reading from the drive motor.
     * @return A raw encoder reading.
     */
    public abstract double getDriveMotorEncoder();

    /**
     * Zero the pivot encoder.
     */
    public abstract void zeroPivotEncoder();

    /**
     * Zero the drive encoder.
     */
    public abstract void zeroDriveEncoder();

    /**
     * Stop the pivot motor.
     */
    public abstract void stopPivotMotor();

    /**
     * Stop the drive motor.
     */
    public abstract void stopDriveMotor();

    /**
     * Set the drive motor to the given reference. This should act
     * as the interface for a closed-loop position control. PID constants
     * should be placed in the actual implementation of the module.
     * @param ref The reference to set for closed loop control.
     */
    public abstract void setDriveReference(double ref);

    /**
     * Set the pivot motor to the given reference. This should act
     * as the interface for a closed-loop position control. PID constants
     * should be placed in the actual implementation of the module.
     * @param ref The reference to set for closed loop control.
     */
    public abstract void setPivotReference(double ref);

    /**
     * Stop the entire module, this just calls the
     * stop function for each motor.
     */
    public final void stop() {
        stopPivotMotor();
        stopDriveMotor();
    }

    /**
     * Zero all the encoders by calling the zero functions
     * for both the drive and pivot motors.
     */
    public final void zero() {
        zeroPivotEncoder();
        zeroDriveEncoder();
    }

    /**
     * Reset this module by stopping all motors and resetting
     * all the encoders.
     */
    public final void reset() {
        stop();
        zero();
    }
}