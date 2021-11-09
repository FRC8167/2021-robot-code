// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // can for wiring team
	public static final int LEFT_FRONT = 1;
	public static final int RIGHT_FRONT = 2;
	public static final int LEFT_BACK = 3;
    public static final int RIGHT_BACK = 4;
    public static final int INTAKE_MOTOR = 6;

    // gamepad controller
	public static final int GP_LEFT_Y_AXIS = 0;
    public static final int GP_LEFT_X_AXIS = 1;
    public static final double DRIVETRAINSPEED = 0.7;
	public static final double DRIVE_FORWARD_TIME = 3.0;
    public static final double AUTONOMOUS_SPEED = 0.4;
    public static final int JOYSTICK_NUMBER = 0;

    //Solenoid
    public static final int K_INTAKEUP = 7;
    public static final int K_INTAKEDOWN = 8;
    public static final double INTAKE_SPEED = 0.5;
	}