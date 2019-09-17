package frc.robot.subsystems;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SwerveDrive extends Subsystem {

  private static final boolean invert = false;
  private static final EncodingType encodingType = EncodingType.k4X;

  public static enum Module {
    FRONT_LEFT, FRONT_RIGHT,
    REAR_LEFT, REAR_RIGHT
  }

  private HashMap<Module, Encoder> encoders = new HashMap<Module, Encoder>();
  
  public SwerveDrive() {
    encoders.put(Module.FRONT_LEFT, new Encoder(0, RobotMap.FRONT_LEFT_ANALOG_ENCODER, invert, encodingType));
    encoders.put(Module.FRONT_RIGHT, new Encoder(0, RobotMap.FRONT_RIGHT_ANALOG_ENCODER, invert, encodingType));
    encoders.put(Module.REAR_LEFT, new Encoder(0, RobotMap.REAR_LEFT_ANALOG_ENCODER, invert, encodingType));
    encoders.put(Module.REAR_RIGHT, new Encoder(0, RobotMap.REAR_RIGHT_ANALOG_ENCODER, invert, encodingType));
  }

  public HashMap<Module, Encoder> getEncoders() {
    return encoders;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
