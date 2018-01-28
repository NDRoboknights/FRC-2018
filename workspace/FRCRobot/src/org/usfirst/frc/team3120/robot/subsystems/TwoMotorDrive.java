package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import utils.Utilities;

public class TwoMotorDrive extends Subsystem 
{

	public Spark LMotor;
	public Spark RMotor;
	
	public TwoMotorDrive()
	{
		LMotor = new Spark(RobotMap.LMotor);
		RMotor = new Spark(RobotMap.RMotor);
		LMotor.setInverted(true);
	}
	
	public void setPower(double lPower, double rPower)
	{
		LMotor.set(lPower);
		RMotor.set(rPower);
	}
	
	public void driveForTime(double lPower, double rPower, long time)
	{
		setPower(lPower, rPower);
		Utilities.delay(time);
		setPower(0, 0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

