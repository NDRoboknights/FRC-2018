package controllers;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import utils.Utilities;

public class Camera 
{
	public UsbCamera camera;
	public Double pBlue = new Double(0);
	public Double pRed = new Double(0);
	public boolean colorEnabled = false;
	
	public Camera()
	{
        new Thread(() -> 
        {
        	camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(200, 200);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            //CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 200, 200);
            
            Mat source = new Mat();
            //Mat output = new Mat();
                        
            while(!Thread.interrupted()) 
            {
            	if(cvSink.grabFrame(source) == 0) {
            		DriverStation.reportError(cvSink.getError(), false);
            		continue;
            	}
            	
            	//Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
            	//outputStream.putFrame(output);
            	
            	if(colorEnabled) {
		        	synchronized(pBlue) {
		        		pBlue = new Double(ColorProcessor.percentBlue(source));
		        	}
		        	
		        	synchronized(pRed) {
		        		pRed = new Double(ColorProcessor.percentRed(source));
		        	}
            	}
            	
            	Utilities.delay(15);
            }
        }).start();
	}
	
	public double getPercentRed()
	{
		synchronized(pRed) {
			return pRed;
		}
	}
	
	public double getPercentBlue()
	{
		synchronized(pBlue) {
			return pBlue;
		}
	}
	
	public void enableColorSense()
	{
		colorEnabled = true;
	}
	
	public void disableColorSense()
	{
		colorEnabled = false;
		pBlue = new Double(0);
		pRed = new Double(0);
	}
}