/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SPI;

/**
 * Add your docs here.
 */
public class Gyro extends Subsystem {

  public Gyro() {
    zero();
  }

  /* Create the AHRS NavX Gyro */
  private final AHRS navxGyro = new AHRS(SPI.Port.kMXP);

  public double getAngle() {
    return navxGyro.getAngle();
  }

  public void zero() {
    navxGyro.zeroYaw();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
