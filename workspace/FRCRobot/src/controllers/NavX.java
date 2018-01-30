package controllers;

import com.kauailabs.navx.frc.AHRS;

import controllers.PID.PIDInput;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class NavX extends PIDInput 
{
	AHRS navx;
	
	public NavX()
	{
		navx = new AHRS(Port.kMXP);
		navx.zeroYaw();
	}
	
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return navx.getAngle();
	}

	/**
	 * Returns value between 0 to 360
	 */
	@Override
	public double normalizeValue(double value) {
		// TODO Auto-generated method stub
		while (value > 360) {
			value -= 360;
		}
		while(value < 0) {
			value += 360;
		}
		return value;
	}

	/**
	 * Returns values between -180 to 180
	 */
	@Override
	public double normalizeError(double error) {
		// TODO Auto-generated method stub
		if(error < -180) {
            error += 360;
        }
        else if(error > 180) {
            error -= 360;
        }
        return error;
	}

}
