package utils;

public class TimeChecker implements StatusChecker
{
    private long endTime;

    /**
     * @param time the time in milliseconds to complete the loop
     */
    public TimeChecker(long time)
    {
        this.endTime = System.currentTimeMillis() + time;
    }

    @Override
    public boolean checkStatus() {
        return System.currentTimeMillis() < endTime;
    }
}
