package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems;

/**
 * Drive the drivetrain with the joystick. This year is
 * a swerve drive train.
 * @author Jordan Bancino
 */
public class DriveWithJoystick extends Command {
  /**
   * Create the command, requiring the drivetrain to drive
   * and the gyro to provide field-centric navigation.
   */
  public DriveWithJoystick() {
    requires(Subsystems.driveTrain);
    requires(Subsystems.gyro);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    /*
     * The joystick I was given was quite crappy, so a small deadband
     * was added to prevent random values being assigned when the joystick
     * wasn't being touched.
     */
    double deadband = 0.2;
    double y = Robot.oi.deadbandMod(Robot.oi.getThrottledY(), deadband);
    double x = Robot.oi.deadbandMod(Robot.oi.getThrottledX(), deadband);
    double z = Robot.oi.deadbandMod(Robot.oi.getThrottledZ(), deadband);
    /**
     * Drive the drivetrain using the axes from the joystick and the gyro
     * angle.
     */
    Subsystems.driveTrain.drive(y, x, z, Subsystems.gyro.getYaw());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    end();
  }
}
