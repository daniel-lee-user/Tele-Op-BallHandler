/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 */
public class ArmSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private PWMTalonSRX armMotor = new PWMTalonSRX(2);
  public static ArmSubsystem arm;
  public ArmSubsystem() {
  }

  public static ArmSubsystem getInstance() {
    if (arm == null) {
      arm = new ArmSubsystem();
    }
    return arm;
  }

  public void setArmPow(double speed) {
    armMotor.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  @Override
  public void periodic() {
    if (OI.returnController().getRawButton(5)) {
      setArmPow(0.2);
    } else if (OI.returnController().getRawButton(6)) {
      setArmPow(-0.2);
    } else {
      setArmPow(0);
    }
  }
}
