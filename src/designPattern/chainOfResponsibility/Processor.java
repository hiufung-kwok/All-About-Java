package designPattern.chainOfResponsibility;

public abstract class Processor {

    private Processor next;

    public void setNext(Processor next) {
        this.next = next;
    }

    public static Processor link (Processor first, Processor... chain) {
        Processor head = first;
        for (Processor nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean handle(String userId);

}
