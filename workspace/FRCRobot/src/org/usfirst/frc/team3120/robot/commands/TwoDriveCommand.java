package org.usfirst.frc.team3120.robot.commands;

import org.usfirst.frc.team3120.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import utils.Utilities;

/**
 *
 */
public class TwoDriveCommand extends Command 
{

    public TwoDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double y = -Robot.oi.joystick1.getY();
    	double twist = -Robot.oi.joystick1.getTwist();
    	double throttle = -Robot.oi.joystick1.getThrottle() * 0.5 + 0.5;
    	double lPower = 0;
    	double rPower = 0;
    	
    	if(Math.abs(y) > Robot.oi.threshold)
    	{
    		lPower = y;
    		rPower = y;
    	}
    	
    	if(Math.abs(twist) > Robot.oi.threshold)
    	{
    		lPower += twist;
    		rPower -= twist;
    	}
    	
    	lPower *= throttle;
    	rPower *= throttle;
    	
    	double[] powers = Utilities.scalePower(lPower, rPower);
    	Robot.drive.setPower(powers[0], powers[1]);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
