package partstest;

import org.usfirst.frc.team3120.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ColorTest extends Command 
{

    public ColorTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.camera.enableColorSense();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	SmartDashboard.putString("Percent Blue: ", Double.toString(Robot.camera.getPercentBlue()));
    	SmartDashboard.putString("Percent Red: ", Double.toString(Robot.camera.getPercentRed()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !this.isRunning();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.camera.disableColorSense();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
