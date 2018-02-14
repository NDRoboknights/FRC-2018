package controllers.PID;


public interface PIDInput
{
    public double getValue();
    public double normalizeValue(double value);
    public double normalizeError(double error);
}
