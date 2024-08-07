package designPattern.memento.scheduledJob;

public class Computation {

    private Long currentSum;

    public Computation() {
        this.currentSum = 0L;
    }

    public Long getCurrentSum() {
        return currentSum;
    }

    public void UpdateCurrentSum (Long currentSum) {
        this.currentSum = currentSum;
    }

    public ComputationState save() {
        return new ComputationState(currentSum);
    }

    public void restore(ComputationState save) {
        currentSum = save.getPurchaseSum();
    }

}
