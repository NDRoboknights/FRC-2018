package org.usfirst.frc.team3120.robot.commands;

import org.usfirst.frc.team3120.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import utils.Utilities;

public class LSCommand extends Command 
{

    public LSCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.LPR);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.compressor.start();
    }

    boolean isForked = false;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.oi.buttons1[1].get()) {
    		Robot.LPR.solenoid2.set(Value.kForward);
    	}
    	else {
    		Robot.LPR.solenoid2.set(Value.kReverse);
    	}
    	
    	if(Robot.oi.buttons1[2].get()) {
    		isForked = !isForked;
    		while(Robot.oi.buttons1[2].get()) {
    			Utilities.delay(5);
    		}
    	}
    	
    	if(isForked) {
    		Robot.LPR.solenoid3.set(Value.kForward);
    	}
    	else {
    		Robot.LPR.solenoid3.set(Value.kReverse);
    	}
    	
    	if(Robot.oi.buttons1[3].get()) {
    		Robot.LPR.safeTurnLS();
    	}
    	
    	if(Robot.oi.buttons1[6].get()) {
    		Robot.LPR.turnLS();
    	}
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
