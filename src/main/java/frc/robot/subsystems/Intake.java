// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
	public final CANSparkMax intake;
	public final DoubleSolenoid solenoid;
	
	/** Creates a new Intake. */
	public Intake() {
		intake = new CANSparkMax(Constants.INTAKE_MOTOR, MotorType.kBrushed);
		//TODO: what are all these? can we remove them?
		//intake.restoreFactoryDefaults();
		//intake.setSmartCurrentLimit(40);
		intake.setIdleMode(IdleMode.kBrake);
		// intake.setInverted(true);
		// intake.burnFlash();
		
		solenoid = new DoubleSolenoid(Constants.PCM_CAN_ID, 1, 2); //TODO: move these to constants
		solenoid.set(DoubleSolenoid.Value.kForward); //TODO: is this correct? test this
	}
	
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
	
	public void setSpeed(double speed) {
		intake.set(speed);
	}
		
	public void stop() {
		intake.stopMotor();
		intake.set(0);
	}
	
	public void toggle() {
		if (solenoid.get() == DoubleSolenoid.Value.kOff) 
			solenoid.set(DoubleSolenoid.Value.kReverse); //TODO: make sure this shouldnt be forwards
		else solenoid.toggle();
	}
	
	public void forward() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void reverse() {
		solenoid.set(DoubleSolenoid.Value.kReverse);	
	}
}
