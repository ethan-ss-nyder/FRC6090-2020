package frc.robot.swerveio;

/**
 * A swerve module definition that swerve drive implementations
 * should use to drive a module. These methods should be standardized
 * and implemented similarly across variations in motor controllers
 * and motors. This class is the sole abstraction layer between the
 * hardware-specific API and the SwerveIO API.
 * @author Jordan Bancino
 * @author Ethan Snyder
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
     * Sets the closed loop ramp rate for the pivot motor.
     * @param rate Time in seconds to go from 0 to full throttle.
     */
    public abstract void setPivotClosedLoopRampRate(double rate);

    /**
     * Sets the open loop ramp rate for the pivot motor.
     * @param rate Time in seconds to go from 0 to full throttle.
     */
    public abstract void setPivotOpenLoopRampRate(double rate);

    /**
     * Sets the closed loop ramp rate for the drive motor.
     * @param rate Time in seconds to go from 0 to full throttle.
     */
    public abstract void setDriveClosedLoopRampRate(double rate);

    /**
     * Sets the open loop ramp rate for the drive motor.
     * @param rate Time in seconds to go from 0 to full throttle.
     */
    public abstract void setDriveOpenLoopRampRate(double rate);

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
     * Set the proportional gain of the PID loop coefficient.
     * (The motor will correct itself proportional to the offset
     * of the measure compared to its targeted measure.)
     * It's only weakness will be when it treats positive and negative
     * offset equally, otherwise it narrows error to 0.
     * @param gain Proportional gain value. Must be positive.
     */
    public abstract void setPivotPidP(double gain);
    public abstract void setDrivePidP(double gain);

    /**
     * Set the integral gain of the PID loop coefficient.
     * (The motor will correct itself based on past errors and integrates
     * the history of offset to narrow error down to 0.)
     * The downside of using a purely integral system is that it's slow to
     * start, as it takes time to accumulate enough information to accurately
     * form it's coefficient.
     * @param gain Integral gain value. Must be positive.
     */
    public abstract void setPivotPidI(double gain);
    public abstract void setDrivePidI(double gain);

    /**
     * Set the derivative gain of the PID loop coefficient.
     * (The motor will correct error based on it's rate of change, not seeking
     * to bring the error to 0, but seeking to keep the error that the system is
     * stable.)
     * A derivative loop will never bring your error to 0, but will simply
     * keep your error from growing larger by catching any change and correcting it.
     * @param gain Derivative gain value. Must be positive.
     */
    public abstract void setPivotPidD(double gain);
    public abstract void setDrivePidD(double gain); 

    /**
     * Sets the range of error allowed in the PID loop for the integral
     * factor to disable. This will prevent the integral loop from continuing
     * to integrate error when the error is too close to 0 to matter.
     * @param iZone IZone value. Must be positive, or set to 0 to disable.
     */
    public abstract void setPivotPidIZone(double iZone);
    public abstract void setDrivePidIZone(double iZone);

    /**
     * Sets the priority held in feed-forward augment. In a closed loop system,
     * the feed-forward predicts the outcome of the next output from the motor
     * controllers for better error correcting accuracy.
     * @param gain Feed-forward gain value. Must be positive.
     */
    public abstract void setPivotPidFF(double gain);
    public abstract void setDrivePidFF(double gain);

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
