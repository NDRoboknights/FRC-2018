package utils;

public interface StatusChecker
{
    /**
     * @return if a loop should continue running
     */
    public boolean checkStatus();
}