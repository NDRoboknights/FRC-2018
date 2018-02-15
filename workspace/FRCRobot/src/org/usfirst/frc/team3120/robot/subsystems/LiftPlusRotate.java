package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.Robot;
import org.usfirst.frc.team3120.robot.RobotMap;

import controllers.Arduino;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import utils.TimeChecker;

/**
 *
 */
public class LiftPlusRotate extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public DoubleSolenoid solenoid1 = null;
	public DoubleSolenoid solenoid2 = null;
	public DoubleSolenoid solenoid3 = null;
	public Spark spark1 = null;
	public Arduino arduino;
	
	public LiftPlusRotate()
	{
		solenoid1 = new DoubleSolenoid(RobotMap.hSolenoid1_0, RobotMap.hSolenoid1_1);
		solenoid2 = new DoubleSolenoid(RobotMap.hSolenoid2_0, RobotMap.hSolenoid2_1);
		solenoid3 = new DoubleSolenoid(RobotMap.hSolenoid3_0, RobotMap.hSolenoid3_1);
		
		solenoid1.set(Value.kOff);
		solenoid2.set(Value.kOff);
		solenoid3.set(Value.kOff);
		
		spark1 = new Spark(RobotMap.LSMotor);
		spark1.setPosition(0);
		arduino = Robot.arduino;
	}
	
	public boolean isForward = true;
	
	public void safeTurnLS()
	{
		if(readyToTurn()) {
			turnLS();
		}
	}
	
	public void turnLS()
	{
		isForward = !isForward;
		if(isForward) {
			spark1.setPosition(0);
		}
		else {
			spark1.setPosition(0.5);
		}
	}
	
	public boolean readyToTurn()
	{
		return arduino.ableToTurn(new TimeChecker(650));
	}
	
    public void initDefaultCommand() 
    {
    	//setDefaultCommand(new PneumaticsCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

