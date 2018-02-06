package controllers;

import edu.wpi.first.wpilibj.SerialPort;

public class Arduino 
{ 
	SerialPort port;
	
	public Arduino(SerialPort port)
	{
		this.port = port;
	}
}