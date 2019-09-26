package frc.robot.swerveio;

import java.util.HashMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class SwerveDrive extends Subsystem {
    protected HashMap<SwerveModule, AbstractSwerveModule> moduleMap;
    protected SwerveDriveCalculator calc;

    public SwerveDrive(double baseWidth, double baseLength, AbstractSwerveModule frontLeftModule, AbstractSwerveModule frontRightModule, AbstractSwerveModule rearLeftModule, AbstractSwerveModule rearRightModule) {
        StringBuilder nullModule = new StringBuilder("The following modules are null: [");
        boolean haveNullModule = false;
        if (frontRightModule == null) {
            nullModule.append(" FrontRight");
            haveNullModule = true;
        }
        if (frontLeftModule == null) {
            nullModule.append(" FrontLeft");
            haveNullModule = true;
        }
        if (rearLeftModule == null) {
            nullModule.append(" RearLeft");
            haveNullModule = true;
        }
        if (rearRightModule == null) {
            nullModule.append(" RearRight");
            haveNullModule = true;
        }
        if (haveNullModule) {
            nullModule.append("] Please provide an implemented swerve module for these parameters.");
            throw new SwerveImplementationException(nullModule.toString());
        } else {
            moduleMap.put(SwerveModule.FRONT_LEFT, frontLeftModule);
            moduleMap.put(SwerveModule.FRONT_RIGHT, frontRightModule);
            moduleMap.put(SwerveModule.REAR_LEFT, rearLeftModule);
            moduleMap.put(SwerveModule.REAR_RIGHT, rearRightModule);
            if (baseWidth <= 0 || baseLength <= 0) {
                this.calc = new SwerveDriveCalculator();
            } else {
                this.calc = new SwerveDriveCalculator(baseWidth, baseLength);
            }
        }
    }

    public abstract void drive(double fwd, double str, double rcw, double gyroAngle) throws SwerveImplementationException;

    public void stop() {
        for (AbstractSwerveModule module : moduleMap.values()) {
            module.stop();
        }
    }
}