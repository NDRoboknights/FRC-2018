package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Talon drive1;
	
	public Drive()
	{
		drive1 = new Talon(RobotMap.Drive1);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	drive1.set(0);
    	
    }
}

