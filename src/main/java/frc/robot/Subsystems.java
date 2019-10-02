package frc.robot;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

public class Subsystems {
    public static DriveTrain driveTrain;
    public static Gyro gyro;

    public Subsystems() {
        System.out.println("Instantiating Subsystems.");
        driveTrain = new DriveTrain();
        gyro = new Gyro();
        System.out.println("Subsystems created.");
    }
}