package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems;

/**
 * A simple command that merely zeros all the drivetrain encoders
 * by calling the subsystem's zero() method. This was created with
 * the purpose of being mapped to a joystick button for easy calibration.
 * @author Jordan Bancino
 */
public class ZeroDrivetrainEncoders extends Command {

  private boolean isFinished = false;

  public ZeroDrivetrainEncoders() {
    requires(Subsystems.driveTrain);
  }

  @Override
  protected void execute() {
    Subsystems.driveTrain.zero();
    isFinished = true;
  }

  @Override
  protected boolean isFinished() {
    return isFinished;
  }

}
