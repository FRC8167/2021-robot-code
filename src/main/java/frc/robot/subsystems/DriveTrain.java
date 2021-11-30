// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonFX leftFront = new WPI_TalonFX(Constants.LEFT_FRONT);
  WPI_TalonFX rightFront = new WPI_TalonFX(Constants.RIGHT_FRONT);
  WPI_TalonFX leftBack = new WPI_TalonFX(Constants.LEFT_BACK);
  WPI_TalonFX rightBack = new WPI_TalonFX(Constants.RIGHT_BACK);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFront, leftBack); 
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFront, rightBack);
  DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront.setSafetyEnabled(false);
    leftBack.setSafetyEnabled(false);
    rightFront.setSafetyEnabled(false);
    rightBack.setSafetyEnabled(false);
    leftFront.configOpenloopRamp(0.05);
    leftBack.configOpenloopRamp(0.05);
    rightFront.configOpenloopRamp(0.05);
    rightBack.configOpenloopRamp(0.05);

  // VERY VERY IMPORTANT
  // Comment out three motors at a time to test the invert(true/false) coding for one

    rightFront.setInverted(false);
    rightBack.setInverted(false);
    leftFront.setInverted(true);
    leftBack.setInverted(true);

   // leftMotors = new SpeedControllerGroup(leftFront, leftBack);
   // rightMotors = new SpeedControllerGroup(rightFront, rightBack);
   // drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  /**
   * @param l
   * @param r
   */
/*  public void tankDrive(double l, double r) {
    drive.tankDrive(l, r);
  } */

  public void driveWithJoysticks(Joystick driverJoystick, double speed)
  {
    drive.arcadeDrive(driverJoystick.getRawAxis(Constants.GP_LEFT_Y_AXIS) * speed, driverJoystick.getRawAxis(Constants.GP_LEFT_X_AXIS) * speed);
  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}
