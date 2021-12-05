// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.RunIntakeMotor;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain;
  public static Joystick driverJoystick;
  public final Intake intake;
  public final RunIntakeMotor collectBall;
  private final DriveForwardTimed driveForwardTimed;
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
	driveTrain = new DriveTrain();
    intake = new Intake();
	driverJoystick = new Joystick(Constants.JOYSTICK_NUMBER);
	
    driveTrain.setDefaultCommand(new DriveWithJoysticks(driveTrain, Constants.DRIVETRAINSPEED));
	driveForwardTimed = new DriveForwardTimed(driveTrain, Constants.DRIVE_FORWARD_TIME, Constants.AUTONOMOUS_SPEED);
	  collectBall = new RunIntakeMotor(intake);
	
    // Configure the button bindings
    configureButtonBindings();
  }
  
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton IntakeButton = new JoystickButton(driverJoystick, Constants.kGamepadBumperRight);
    IntakeButton.whileHeld(new RunCommand(() -> intake.setSpeed(Constants.INTAKE_SPEED), intake));
	IntakeButton.whenReleased(new RunCommand(() -> intake.stop(), intake));
	
    JoystickButton ReverseIntakeButton = new JoystickButton(driverJoystick, Constants.kGamepadBumperLeft);
	ReverseIntakeButton.whileHeld(new RunCommand(() -> intake.setSpeed(-Constants.INTAKE_SPEED), intake));
    ReverseIntakeButton.whenReleased(new RunCommand(() -> intake.stop(), intake));
	
    JoystickButton solenoidButtonIn = new JoystickButton(driverJoystick, Constants.gamepadBButton);
    solenoidButtonIn.whenActive(new InstantCommand(() -> intake.solenoid.toggle(), intake));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;
  }
}
