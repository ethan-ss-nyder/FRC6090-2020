package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * The JVM entry class. This is the parent of all the robot code.
 * Note: Do not modify any of this unless you really know what you're
 * doing.
 * @author Jordan Bancino
 */
public final class Main {
public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
