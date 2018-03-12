package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.Robot;
import org.usfirst.frc.team3120.robot.RobotMap;

import controllers.Arduino;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import utils.Utilities;

/**
 *
 */
public class LiftPlusRotate extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	/**
	 * Lift
	 */
	public DoubleSolenoid solenoid1;
	
	/**
	 * Top claw
	 */
	public DoubleSolenoid solenoid2;
	
	/**
	 * Bottom claw
	 */
	public DoubleSolenoid solenoid3;
	
	
	public Spark spark1;
	public Arduino arduino;
	public DigitalInput forLimitSwitch = new DigitalInput(1);
	public DigitalInput bacLimitSwitch = new DigitalInput(2);
	public static final double TURN_SPEED = 0.5;
	
	public LiftPlusRotate()
	{
		solenoid1 = new DoubleSolenoid(RobotMap.hSolenoid1_0, RobotMap.hSolenoid1_1);
		solenoid2 = new DoubleSolenoid(RobotMap.hSolenoid2_0, RobotMap.hSolenoid2_1);
		solenoid3 = new DoubleSolenoid(RobotMap.hSolenoid3_0, RobotMap.hSolenoid3_1);

		spark1 = new Spark(RobotMap.LSMotor);
		
		Utilities.delay(500);
		
		solenoid1.set(Value.kReverse);
		solenoid2.set(Value.kReverse);
		solenoid3.set(Value.kReverse);
		
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
			while(!forLimitSwitch.get()) {
				spark1.set(TURN_SPEED);
			}
		}
		else {
			while(!bacLimitSwitch.get()) {
				spark1.set(-TURN_SPEED);
			}
		}
	}

	public boolean readyToTurn()
	{
		return arduino.ableToTurn(650);
	}
	
	public boolean isClomped = false;
	public void clomp()
	{
		isClomped = !isClomped;
		
		if(isClomped) {
			solenoid2.set(Value.kForward);
			solenoid3.set(Value.kForward);
		}
		else {
			solenoid2.set(Value.kReverse);
			solenoid3.set(Value.kReverse);
		}
	}
	
	public boolean isLifted = false;
	private void lift()
	{
		isLifted = !isLifted;
		
		if(isLifted) {
			solenoid1.set(Value.kForward);
		}
		else {
			solenoid1.set(Value.kReverse);
		}
	}
	
	public void safeLift()
	{
		if(isLifted && forLimitSwitch.get()) {
			lift();
		}
		else if(!isLifted) {
			lift();
		}
	}
	
    public void initDefaultCommand() 
    {
    	//setDefaultCommand(new PneumaticsCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

