package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.swerveio.AbstractSwerveModule;
import frc.robot.swerveio.SwerveDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Swerve Drive subsystem.
 * 
 * The decision to have the maps be returned as unmodifiable
 * HashMap is so that members outside of this class cannot directly
 * add or remove items to the map, or change the values. That behavior
 * could lead to unpredictable results, so as a safety mechanism, while
 * the values of the map can be operated on, they cannot be modified.
 * @author Jordan Bancino
 */
public class DriveTrain /* extends SwerveDrive */ extends Subsystem {
  public static final double BASE_WIDTH = 10;
  public static final double BASE_LENGTH = 10;
  /**
   * Create the SwerveDrive with the default settings and the
   * robot map.
   */
  public DriveTrain() {
    
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub

  }
}
