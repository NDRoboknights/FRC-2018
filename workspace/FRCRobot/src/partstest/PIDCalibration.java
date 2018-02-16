package partstest;

import org.usfirst.frc.team3120.robot.Robot;

import controllers.PID.CycleChecker;
import controllers.PID.PIDController;
import controllers.PID.PIDFunctions;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.TimeChecker;
import utils.Utilities;

/**
 *
 */
public class PIDCalibration extends Command {
	
	PIDFunctions pidFunc;
	PIDController pidCont;

    public PIDCalibration() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pidFunc = new PIDFunctions(pidCont = new PIDController(Robot.navx, Robot.pidc, 3));
    }

    double p = 6.2E-3;
    double i = 6.2E-5;
    double d = 1.7E-7;
    double delta = 1.3E-6;
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("P: ", p + "");
    	SmartDashboard.putString("I: ", i + "");
    	SmartDashboard.putString("D: ", d + "");
    	SmartDashboard.putString("NavX Value: ", "" + Robot.navx.getValue());
    	SmartDashboard.putString("Turning?: ", "false");
    	
    	if(Robot.oi.buttons1[8].get()) {
    		p += delta;
    	}
    	else if(Robot.oi.buttons1[7].get()) {
    		p -= delta;
    	}
    	
    	if(Robot.oi.buttons1[10].get()) {
    		i += delta;
    	}
    	else if(Robot.oi.buttons1[9].get()) {
    		i -= delta;
    	}
    	
    	if(Robot.oi.buttons1[12].get()) {
    		d += delta;
    	}
    	else if(Robot.oi.buttons1[11].get()) {
    		d -= delta;
    	}
    	
    	pidCont.setPidc(p, i, d);
    	
    	if(Robot.oi.buttons1[2].get()) {
    		SmartDashboard.putString("Turning?: ", "true");
    		pidFunc.goToAngle(pidCont.getValue() + 90, new CycleChecker(pidFunc, 50));
    	}
    	
    	if(Robot.oi.buttons1[1].get()) {
    		pidFunc.straight(0.26, new TimeChecker(15000));
    	}
    	
    	Utilities.delay(30);
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
