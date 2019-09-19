package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.swerveio.AnalogNeoSwerveModule;
import frc.robot.swerveio.SwerveDrive;

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
  /**
   * Create the SwerveDrive with the default settings and the
   * robot map.
   */
  public DriveTrain() {
    super(BASE_WIDTH, BASE_LENGTH,
      new AnalogNeoSwerveModule(-1, -1,
        RobotMap.FRONT_LEFT_ANALOG_ENCODER_A, RobotMap.FRONT_LEFT_ANALOG_ENCODER_B,
        RobotMap.FRONT_LEFT_DRIVE_MOTOR, RobotMap.FRONT_LEFT_PIVOT_MOTOR),
      new AnalogNeoSwerveModule(-1, -1,
        RobotMap.FRONT_RIGHT_ANALOG_ENCODER_A, RobotMap.FRONT_RIGHT_ANALOG_ENCODER_B,
        RobotMap.FRONT_RIGHT_DRIVE_MOTOR, RobotMap.FRONT_RIGHT_PIVOT_MOTOR),
      new AnalogNeoSwerveModule(-1, -1,
        RobotMap.REAR_LEFT_ANALOG_ENCODER_A, RobotMap.REAR_LEFT_ANALOG_ENCODER_B,
        RobotMap.REAR_LEFT_DRIVE_MOTOR, RobotMap.REAR_LEFT_PIVOT_MOTOR),
      new AnalogNeoSwerveModule(-1, -1,
        RobotMap.REAR_RIGHT_ANALOG_ENCODER_A, RobotMap.REAR_RIGHT_ANALOG_ENCODER_B,
        RobotMap.REAR_RIGHT_DRIVE_MOTOR, RobotMap.REAR_RIGHT_PIVOT_MOTOR)
    );
    
  }

  /*
   * Set the default command for a subystem here.
   * setDefaultCommand(new MySpecialCommand());
   */
  @Override
  public void initDefaultCommand() {}
}
