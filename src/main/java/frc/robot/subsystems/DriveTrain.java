package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.swerveio.NeoSwerveModule;
import frc.robot.swerveio.SwerveDrive;
import frc.robot.swerveio.SwerveImplementationException;
import frc.robot.swerveio.SwerveModule;
import frc.robot.swerveio.MultiEncoderModule.EncoderSetting;

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

  private static final HashMap<SwerveModule, NeoSwerveModule> modules = createModuleMap();

  public static HashMap<SwerveModule, NeoSwerveModule> createModuleMap() {
    HashMap<SwerveModule, NeoSwerveModule> moduleMap = new HashMap<>();
    moduleMap.put(SwerveModule.FRONT_LEFT, new NeoSwerveModule(RobotMap.FRONT_LEFT_DRIVE_MOTOR, RobotMap.FRONT_LEFT_PIVOT_MOTOR, RobotMap.FRONT_LEFT_ANALOG_ENCODER_A, RobotMap.FRONT_LEFT_ANALOG_ENCODER_B));
    moduleMap.put(SwerveModule.FRONT_RIGHT, new NeoSwerveModule(RobotMap.FRONT_RIGHT_DRIVE_MOTOR, RobotMap.FRONT_RIGHT_PIVOT_MOTOR, RobotMap.FRONT_RIGHT_ANALOG_ENCODER_A, RobotMap.FRONT_RIGHT_ANALOG_ENCODER_B));
    moduleMap.put(SwerveModule.REAR_LEFT, new NeoSwerveModule(RobotMap.REAR_LEFT_DRIVE_MOTOR, RobotMap.REAR_LEFT_PIVOT_MOTOR, RobotMap.REAR_LEFT_ANALOG_ENCODER_A, RobotMap.REAR_LEFT_ANALOG_ENCODER_B));
    moduleMap.put(SwerveModule.REAR_RIGHT, new NeoSwerveModule(RobotMap.REAR_RIGHT_DRIVE_MOTOR, RobotMap.REAR_RIGHT_PIVOT_MOTOR, RobotMap.REAR_RIGHT_ANALOG_ENCODER_A, RobotMap.REAR_RIGHT_ANALOG_ENCODER_B));
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
  public void drive(double fwd, double str, double rcw, double gyroAngle) throws SwerveImplementationException {
    NeoSwerveModule testModule = modules.get(SwerveModule.FRONT_LEFT);
    if (testModule.getEncoderSetting() != EncoderSetting.ANALOG) {
      testModule.setEncoder(EncoderSetting.ANALOG);
    }
    System.out.println("Test module ANALOG ENCODER: " + modules.get(SwerveModule.FRONT_LEFT).getDriveMotorEncoder());
    super.drive(fwd, str, rcw, gyroAngle);
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoystick());
  }
}
