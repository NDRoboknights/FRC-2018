package controllers;

import edu.wpi.first.wpilibj.SerialPort;
import utils.TimeChecker;
import utils.Utilities;

public class Arduino 
{ 
	SerialPort port;
	
	public enum Code
	{
		READY("rdy"),
		CONNECTED("Con"),
		DISCONNECTED("Dis");
		
		public String str;
		
		Code(String str)
		{
			this.str = str;
		}
	}
	
	public Arduino(SerialPort port)
	{
		this.port = port;
	}
	
	public boolean ableToTurn(long timeout)
	{
		TimeChecker tChecker = new TimeChecker(timeout);
		port.writeString(Code.READY.str);
		port.flush();
		while(port.getBytesReceived() < Code.CONNECTED.str.length() && tChecker.checkStatus())
		{
			Utilities.delay(5);
		}
		
		return (port.getBytesReceived() == Code.CONNECTED.str.length() && port.readString().equals(Code.CONNECTED.str));
	}
}