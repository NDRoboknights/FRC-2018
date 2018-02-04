package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.RobotMap;
import org.usfirst.frc.team3120.robot.commands.PneumaticsCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Compressor compressor;
	public DoubleSolenoid solenoid1;
	//public DoubleSolenoid solenoid2;
	
	
	public Pneumatics()
	{
		
		compressor = new Compressor(RobotMap.PCMPort);
		solenoid1 = new DoubleSolenoid(RobotMap.hSolenoid1_0, RobotMap.hSolenoid1_1);
		//solenoid2 = new DoubleSolenoid(RobotMap.hSolenoid2_0, RobotMap.hSolenoid2_1);
		
	}
	
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new PneumaticsCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

