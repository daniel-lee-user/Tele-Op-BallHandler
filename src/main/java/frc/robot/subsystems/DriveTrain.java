package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;
import frc.robot.OI;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private PWMTalonSRX left = new PWMTalonSRX(0), right = new PWMTalonSRX(1);
  public static DriveTrain drive;

  public DriveTrain() {
    right.setInverted(true);
  }

  public static DriveTrain getInstance() {
    if (drive == null) {
      drive = new DriveTrain();
    }
    return drive;
  }

  public void tankDrive(double leftPow, double rightPow) {
    left.set(leftPow);
    right.set(rightPow);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  @Override
  public void periodic() {
    tankDrive(-OI.returnController().getRawAxis(1), -OI.returnController().getRawAxis(4));
  }
}
