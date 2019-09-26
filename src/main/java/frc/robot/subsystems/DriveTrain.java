package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.swerveio.AbstractSwerveModule;
import frc.robot.swerveio.MultiEncoderModule;
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

  private static final HashMap<SwerveModule, MultiEncoderModule> modules = createModuleMap();

  public static HashMap<SwerveModule, MultiEncoderModule> createModuleMap() {
    HashMap<SwerveModule, MultiEncoderModule> moduleMap = new HashMap<>();
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
    super(BASE_WIDTH, BASE_LENGTH, modules);
  }

  @Override
  public void drive(double fwd, double str, double rcw, double gyroAngle) throws SwerveImplementationException {
    MultiEncoderModule testModule = modules.get(SwerveModule.FRONT_LEFT);
    if (testModule.getEncoderSetting() != EncoderSetting.ANALOG) {
      testModule.setEncoder(EncoderSetting.ANALOG);
    }
    System.out.println("---------------------------------------------");
    System.out.println("Test module ANALOG ENCODER: " + modules.get(SwerveModule.FRONT_LEFT).getDriveMotorEncoder());
    
    System.out.printf("[SwerveDrive] Driving with values: [fwd: %d, str: %d, rcw: %d, gyro: %d]\n");
    
    for (SwerveModule module : modules.keySet()) {
        System.out.println("[SwerveDrive] - Module: " + module.name());
        double speed = calc.getWheelSpeed(module, fwd, str, rcw);
        double angle = calc.getWheelAngle(module, fwd, str, rcw, gyroAngle);
        System.out.println("[SwerveDrive]   - Speed: " + speed);
        System.out.println("[SwerveDrive}   - Angle: " + angle);
        AbstractSwerveModule swerveModule = modules.get(module);
        swerveModule.setDriveMotorSpeed(speed);
    }
    System.out.println("---------------------------------------------");
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoystick());
  }
}
