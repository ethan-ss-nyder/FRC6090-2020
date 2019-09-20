package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.swerveio.AbstractSwerveModule;
import frc.robot.swerveio.SwerveDrive;
import frc.robot.swerveio.SwerveModule;

import java.util.HashMap;

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
public class DriveTrain extends SwerveDrive {
  public static final double BASE_WIDTH = 10;
  public static final double BASE_LENGTH = 10;

  private static final HashMap<SwerveModule, AbstractSwerveModule> modules = createModuleMap();

  private static HashMap<SwerveModule, AbstractSwerveModule> createModuleMap() {
    HashMap<SwerveModule, AbstractSwerveModule> moduleMap = new HashMap<SwerveModule, AbstractSwerveModule>();
    /* TODO put modules in the hashmap */
    return moduleMap;
  }

  /**
   * Create the SwerveDrive with the default settings and the
   * robot map.
   */
  public DriveTrain() {
    super(BASE_WIDTH, BASE_LENGTH, modules.get(SwerveModule.FRONT_LEFT), modules.get(SwerveModule.FRONT_RIGHT),
      modules.get(SwerveModule.REAR_LEFT), modules.get(SwerveModule.REAR_RIGHT));
  }


  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoystick());
  }
}
