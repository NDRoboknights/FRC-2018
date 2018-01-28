package controllers.PID;

public class PIDCoefficients 
{
	double p;
	double i;
	double d;
	
	public PIDCoefficients(double p, double i, double d)
	{
		this.p = p;
		this.i = i;
		this.d = d;
	}

}
