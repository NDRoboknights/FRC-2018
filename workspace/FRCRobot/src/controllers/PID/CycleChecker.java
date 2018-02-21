package controllers.PID;

import utils.StatusChecker;


public class CycleChecker implements StatusChecker
{
    int extraCycles;
    PIDFunctions func;

    /**
     * Used in PIDController to specify the amount of extra cycles within ACC_ERROR
     * to continue running.
     * @param func the PIDFunctions object to operate on
     * @param extraCycles how many extra cycles to continue
     */
    public CycleChecker(PIDFunctions func, int extraCycles)
    {
        this.func = func;
        this.extraCycles = extraCycles;
    }

    @Override
    public boolean checkStatus() {
        return func.pidController.cycles < extraCycles;
    }
}
