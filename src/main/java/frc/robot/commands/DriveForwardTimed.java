// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//DriveForwardTimedCommand

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveForwardTimed extends CommandBase {
  DriveTrain drivetrain;
  final double time;
  final double speed;
  private final Timer timer;

  /** Creates a new DriveForwardTimed. */
  public DriveForwardTimed(DriveTrain drivetrain, double time, double speed) {
    this.drivetrain = drivetrain;
	this.time = time;
	this.speed = speed;
    this.timer = new Timer();
    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
	drivetrain.driveForward(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() < time;
  }
}
