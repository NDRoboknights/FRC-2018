package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Compressor compressor;
	public Solenoid solenoid0;
	public Solenoid solenoid1;
	public Solenoid solenoid2;
	public Solenoid solenoid3;
	public Solenoid solenoid4;
	public Solenoid solenoid5;
	
	public Pneumatics()
	{
		compressor = new Compressor(RobotMap.PCMPort);
		solenoid1 = new Solenoid(RobotMap.solenoid1);
	}
	
    public void initDefaultCommand() {
    	
		solenoid0 = new Solenoid(RobotMap.solenoid0);
		solenoid1 = new Solenoid(RobotMap.solenoid1);
		solenoid2 = new Solenoid(RobotMap.solenoid2);
		solenoid3 = new Solenoid(RobotMap.solenoid3);
		solenoid4 = new Solenoid(RobotMap.solenoid4);
		solenoid5 = new Solenoid(RobotMap.solenoid5);
		
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

