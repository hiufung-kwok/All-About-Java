package designPattern.memento.scheduledJob;

public class RecordManager {

    private Computation computation;
    private ComputationState computationState;

    public RecordManager(Computation computation) {
        this.computation = computation;
    }

    public void write (long value) {
        computation.UpdateCurrentSum(value);
    }

    public long print() {
        return computation.getCurrentSum();
    }

    public void save() {
        computationState = computation.save();
    }

    public void restore () {
        computation.restore(computationState);
    }

}
