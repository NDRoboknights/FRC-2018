package org.usfirst.frc.team3120.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static int PCMPort = 0;
	public static int hSolenoid1_0 = 0;
	public static int hSolenoid1_1 = 1;
	public static int hSolenoid2_0 = 0;
	public static int hSolenoid2_1 = 0;
	public static int hSolenoid3_0 = 0;
	public static int hSolenoid3_1 = 0;

	
	public static int LMotor = 0;
	public static int RMotor = 1;
	public static int LSMotor = 2;
//	public static int BLMotor = 2;
//	public static int BRMotor = 3;
}
