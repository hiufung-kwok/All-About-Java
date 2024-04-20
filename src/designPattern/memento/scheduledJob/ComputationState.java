package designPattern.memento.scheduledJob;

public class ComputationState {

    private long purchaseSum;

    public ComputationState(long purchaseSum) {
        this.purchaseSum = purchaseSum;
    }

    public long getPurchaseSum() {
        return purchaseSum;
    }
}
