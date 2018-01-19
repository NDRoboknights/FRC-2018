/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3120.robot.subsystems;

import org.usfirst.frc.team3120.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
	
	Talon[] driveTrain = new Talon[2];
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		driveTrain[0] = new Talon(RobotMap.leftMotor);
		driveTrain[1] = new Talon(RobotMap.rightMotor);
	}
}
