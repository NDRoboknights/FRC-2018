package controllers;

import org.opencv.core.Mat;

public class ColorProcessor 
{
	public enum ColorRange
	{
		RED(172, 15),
		BLUE(93, 142);
		
		int min;
		int max;
		
		ColorRange(int min, int max)
		{
			this.min = min;
			this.max = max;
		}
	}
	
	public static double percentBlue(Mat mat)
	{
		double val = 0;
		
		for(int i=0; i<mat.width(); i++)
		{
			for(int j=0; j<mat.height(); j++)
			{
				double[] bgr = mat.get(i, j);
				
				if( (bgr[0] > ColorRange.BLUE.min && bgr[0] < ColorRange.BLUE.max) &&
						(bgr[2] < ColorRange.RED.min || bgr[2] > ColorRange.RED.max) ) {
					val++;
				}
			}
		}
		
		val /= (mat.rows() * mat.cols());
		
		return val;
	}
	
	public static double percentRed(Mat mat)
	{
		double val = 0;
		
		for(int i=0; i<mat.width(); i++)
		{
			for(int j=0; j<mat.height(); j++)
			{
				double[] bgr = mat.get(i, j);
				
				if( (bgr[2] > ColorRange.RED.min && bgr[2] < ColorRange.RED.max) &&
						(bgr[0] < ColorRange.BLUE.min || bgr[0] > ColorRange.BLUE.max) ) {
					val++;
				}
			}
		}
		
		val /= (mat.rows() * mat.cols());
		
		return val;
	}
}
