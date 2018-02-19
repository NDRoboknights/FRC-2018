package org.usfirst.frc.team3120.robot.commands;

import org.usfirst.frc.team3120.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticsCommand extends Command {

    public PneumaticsCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.pneumatics.compressor.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.oi.buttons1[3].get()) {
    		Robot.pneumatics.solenoid0.set(true);
    		Robot.pneumatics.solenoid1.set(false);
    	}
    	else if(Robot.oi.buttons1[5].get()) {
    		Robot.pneumatics.solenoid0.set(false);
    		Robot.pneumatics.solenoid1.set(true);
    	}
    	else {
    		Robot.pneumatics.solenoid1.set(true);
    		Robot.pneumatics.solenoid0.set(true);
    	}
    	
    	if(Robot.oi.buttons1[4].get()) {
    		Robot.pneumatics.solenoid2.set(true);
    		Robot.pneumatics.solenoid3.set(false);
    	}else if(Robot.oi.buttons1[5].get()) {
    		Robot.pneumatics.solenoid2.set(false);
    		Robot.pneumatics.solenoid3.set(true);
    	}else {
    		Robot.pneumatics.solenoid2.set(true);
    		Robot.pneumatics.solenoid3.set(true);
    	}
    	
    	if(Robot.oi.buttons1[10].get()) {
    		Robot.pneumatics.solenoid4.set(true);
    		Robot.pneumatics.solenoid5.set(false);
    	}else if(Robot.oi.buttons1[12].get()) {
    		Robot.pneumatics.solenoid4.set(false);
    		Robot.pneumatics.solenoid5.set(true);
    	}else {
    		Robot.pneumatics.solenoid4.set(true);
    		Robot.pneumatics.solenoid5.set(true);
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
