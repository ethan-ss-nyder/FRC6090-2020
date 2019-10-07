package frc.robot;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

/**
 * Instantiate all the subsystems here for static reference,
 * since this is how WPI models it. These are declared final
 * to prevent subsystems from being arbitrarily modified by
 * other code.
 * @author Jordan Bancino
 */
public class Subsystems {
    public static final DriveTrain driveTrain = new DriveTrain();
    public static final Gyro gyro = new Gyro();
}