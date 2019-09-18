package frc.robot.subsystems;

import java.util.Collections;
import java.util.HashMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

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
public class SwerveDrive extends Subsystem {

  /* Encoder settings */
  public static final boolean ENCODER_INVERT = false;
  public static final EncodingType ENCODING_TYPE = EncodingType.k4X;

  /* Motor settings */
  public static final MotorType MOTOR_TYPE = MotorType.kBrushless;

  /**
   * A module enum that provides the keys for the below
   * maps.
   */
  public static enum Module {
    FRONT_LEFT, FRONT_RIGHT,
    REAR_LEFT, REAR_RIGHT
  }

  /**
   * A collection of the encoders, drive motors, and pivot motors.
   * HashMap was chosen because it doesn't allow duplicate keys and it
   * allows us to easily get what we want in other parts of the code.
   */
  private final HashMap<Module, Encoder> encoders = new HashMap<Module, Encoder>();
  private final HashMap<Module, CANSparkMax> driveMotors = new HashMap<Module, CANSparkMax>();
  private final HashMap<Module, CANSparkMax> pivotMotors = new HashMap<Module, CANSparkMax>();
  
  /**
   * Create the SwerveDrive with the default settings and the
   * robot map.
   */
  public SwerveDrive() {
    this(ENCODER_INVERT, ENCODING_TYPE, MOTOR_TYPE);
  }

  /**
   * Instantate the SwerveDrive using custom settings and the robot map.
   * @param invert Whether or not to invert the motors
   * @param encodingType The encoding settings to use for the encoders.
   */
  public SwerveDrive(boolean invert, EncodingType encodingType, MotorType motorType) {
    encoders.put(Module.FRONT_LEFT, new Encoder(0, RobotMap.FRONT_LEFT_ANALOG_ENCODER, invert, encodingType));
    encoders.put(Module.FRONT_RIGHT, new Encoder(0, RobotMap.FRONT_RIGHT_ANALOG_ENCODER, invert, encodingType));
    encoders.put(Module.REAR_LEFT, new Encoder(0, RobotMap.REAR_LEFT_ANALOG_ENCODER, invert, encodingType));
    encoders.put(Module.REAR_RIGHT, new Encoder(0, RobotMap.REAR_RIGHT_ANALOG_ENCODER, invert, encodingType));

    driveMotors.put(Module.FRONT_LEFT, new CANSparkMax(RobotMap.FRONT_LEFT_DRIVE_MOTOR, motorType));
    driveMotors.put(Module.FRONT_RIGHT, new CANSparkMax(RobotMap.FRONT_RIGHT_DRIVE_MOTOR, motorType));
    driveMotors.put(Module.REAR_LEFT, new CANSparkMax(RobotMap.REAR_LEFT_DRIVE_MOTOR, motorType));
    driveMotors.put(Module.REAR_RIGHT, new CANSparkMax(RobotMap.REAR_RIGHT_DRIVE_MOTOR, motorType));

    pivotMotors.put(Module.FRONT_LEFT, new CANSparkMax(RobotMap.FRONT_LEFT_PIVOT_MOTOR, motorType));
    pivotMotors.put(Module.FRONT_RIGHT, new CANSparkMax(RobotMap.FRONT_RIGHT_PIVOT_MOTOR, motorType));
    pivotMotors.put(Module.REAR_LEFT, new CANSparkMax(RobotMap.REAR_LEFT_PIVOT_MOTOR, motorType));
    pivotMotors.put(Module.REAR_RIGHT, new CANSparkMax(RobotMap.REAR_RIGHT_PIVOT_MOTOR, motorType));
  }

  /**
   * @return A map of the encoders. This map is of size 4, and
   * cannot be modified.
   */
  public HashMap<Module, Encoder> getEncoders() {
    return (HashMap<Module, Encoder>) Collections.unmodifiableMap(encoders);
  }

  /**
   * @return A map of the drive motors. This map is of size 4, and
   * cannot be modified.
   */
  public HashMap<Module, CANSparkMax> getDriveMotors() {
    return (HashMap<Module, CANSparkMax>) Collections.unmodifiableMap(driveMotors);
  }

  /**
   * @return A map of the pivot. This map is of size 4, and
   * cannot be modified.
   */
  public HashMap<Module, CANSparkMax> getPivotMotors() {
    return (HashMap<Module, CANSparkMax>) Collections.unmodifiableMap(pivotMotors);
  }


  /**
   * Set the default command for a subystem here.
   * setDefaultCommand(new MySpecialCommand());
   */
  @Override
  public void initDefaultCommand() {}
}
