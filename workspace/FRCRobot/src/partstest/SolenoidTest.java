package partstest;

import org.usfirst.frc.team3120.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidTest extends Command {

    public SolenoidTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.LPR);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.compressor.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.oi.buttons1[3].get()) {
    		Robot.LPR.solenoid1.set(Value.kForward);
    	}
    	else if(Robot.oi.buttons1[5].get()) {
    		Robot.LPR.solenoid1.set(Value.kReverse);
    	}
    	else {
    		Robot.LPR.solenoid1.set(Value.kOff);
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
