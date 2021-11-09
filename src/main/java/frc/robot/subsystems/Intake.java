// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  public final CANSparkMax intake;
  //public final Solenoid solUp;
  //public final Solenoid solDown;
  /** Creates a new Intake. */
  public Intake() {
    intake = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushed);
    intake.restoreFactoryDefaults();
    intake.setSmartCurrentLimit(40);
    intake.setIdleMode(IdleMode.kCoast);
    intake.setInverted(true); //not sure
    intake.burnFlash();

    //solUp = new Solenoid(Constants.K_INTAKEUP);
    //solDown = new Solenoid(Constants.K_INTAKEDOWN);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void setSpeed(double speed){
    intake.set(speed);
  }

public void collectBall(double speed){
  intake.set(speed);
}

public void reverse(){
  setSpeed(-0.75);
}

public void stop(){
  intake.stopMotor();
  //maybe intake.set(0);
}

public void up(){
  //solDown.set(false);
  //solUp.set(true);
}

public void down(){
  //solDown.set(true);
  //solUp.set(false);
}

}
