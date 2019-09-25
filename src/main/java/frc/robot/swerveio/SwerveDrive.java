package frc.robot.swerveio;

import java.util.HashMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class SwerveDrive extends Subsystem {
    private HashMap<SwerveModule, AbstractSwerveModule> moduleMap;
    private SwerveDriveCalculator calc;

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

    public void drive(double fwd, double str, double rcw, double gyroAngle) throws SwerveImplementationException {
        System.out.printf("[SwerveDrive] Driving with values: [fwd: %d, str: %d, rcw: %d, gyro: %d]\n");
        for (SwerveModule module : moduleMap.keySet()) {
            System.out.println("[SwerveDrive] - Module: " + module.name());
            double speed = calc.getWheelSpeed(module, fwd, str, rcw);
            double angle = calc.getWheelAngle(module, fwd, str, rcw, gyroAngle);
            System.out.println("[SwerveDrive]   - Speed: " + speed);
            System.out.println("[SwerveDrive}   - Angle: " + angle);
            AbstractSwerveModule swerveModule = moduleMap.get(module);
            swerveModule.setDriveMotorSpeed(speed);
            
        }
    }

    public void stop() {
        for (AbstractSwerveModule module : moduleMap.values()) {
            module.stop();
        }
    }
}