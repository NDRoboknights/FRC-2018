package partstest;

import org.usfirst.frc.team3120.robot.Robot;

import controllers.NavX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NavXTest extends Command 
{
	public NavX navx;

    public NavXTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	navx = new NavX();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	SmartDashboard.putString("NavX Value: ", "" + navx.getValue());
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
