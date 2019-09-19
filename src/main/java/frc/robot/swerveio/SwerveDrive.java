package frc.robot.swerveio;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class SwerveDrive extends Subsystem {
    private AbstractSwerveModule frontRightModule, frontLeftModule, rearLeftModule, rearRightModule;
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
            this.frontLeftModule = frontLeftModule;
            this.frontRightModule = frontRightModule;
            this.rearLeftModule = rearLeftModule;
            this.rearRightModule = rearRightModule;
        }
        if (baseWidth <= 0 || baseLength <= 0) {
            throw new IllegalArgumentException("Invalid base dimensions: " + baseWidth + " x " + baseLength);
        } else {
            this.calc = new SwerveDriveCalculator(baseWidth, baseLength);
        }
    }

    public void drive(double fwd, double str, double rcw, double gyroAngle) throws SwerveImplementationException {
        for (SwerveModule module : SwerveModule.values()) {
            double speed = calc.getWheelSpeed(module, fwd, str, rcw);
            double angle = calc.getWheelAngle(module, fwd, str, rcw, gyroAngle);
        }
    }

    public void stop() {
        frontLeftModule.stop();
        frontRightModule.stop();
        rearLeftModule.stop();
        rearRightModule.stop();
    }
}