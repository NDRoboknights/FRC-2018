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
	
	public Pneumatics()
	{
		compressor = new Compressor(RobotMap.PCMPort);
		solenoid0 = new Solenoid(RobotMap.solenoid0);
		solenoid1 = new Solenoid(RobotMap.solenoid1);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

