
package org.usfirst.frc.team3120.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import partstest.ColorTest;
import partstest.MotorTest;
import partstest.NavXTest;
import partstest.PIDCalibration;
import partstest.SolenoidTest;

import org.usfirst.frc.team3120.robot.commands.LSCommand;
import org.usfirst.frc.team3120.robot.commands.TwoDriveCommand;
import org.usfirst.frc.team3120.robot.subsystems.TwoMotorDrive;

import autonomous.DriveForward;
import controllers.Arduino;
import controllers.Camera;
import controllers.NavX;
import controllers.PID.PIDCoefficients;

import org.usfirst.frc.team3120.robot.subsystems.LiftPlusRotate;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Compressor compressor = new Compressor(RobotMap.PCMPort);
	public static LiftPlusRotate LPR = new LiftPlusRotate();
	public static TwoMotorDrive drive = new TwoMotorDrive();
	
	public static PIDCoefficients pidc = new PIDCoefficients(6.2E-3, 6.2E-5, 1.7E-7);
	public static NavX navx;
	public static OI oi;
	public static Camera camera;
	public static Arduino arduino;
	
	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();
	SendableChooser<Command> teleOpChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		arduino = new Arduino(new SerialPort(9600, Port.kUSB1));
		oi = new OI();
		navx = new NavX(Port.kMXP);
		
		CommandGroup teleopCommand = new CommandGroup();
		teleopCommand.addParallel(new SolenoidTest());
		teleopCommand.addParallel(new TwoDriveCommand());
		teleOpChooser.addDefault("TeleOp Main", teleopCommand);
		
		teleOpChooser.addObject("CameraColorTest", new ColorTest());
		teleOpChooser.addObject("Pneumatics Test", new SolenoidTest());
		teleOpChooser.addObject("PIDCalibration", new PIDCalibration());
		teleOpChooser.addObject("Motor Test", new MotorTest());
		teleOpChooser.addObject("NavX Test", new NavXTest());
		teleOpChooser.addObject("Drive Test", new TwoDriveCommand());
		teleOpChooser.addObject("LazySusan Test", new LSCommand());
	
		SmartDashboard.putData("TeleOp Mode", teleOpChooser);
		
		autoChooser.addDefault("DriveForward", new DriveForward());
		SmartDashboard.putData("Auto Mode", autoChooser);
		
		camera = new Camera();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = autoChooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		teleOpChooser.getSelected().start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
