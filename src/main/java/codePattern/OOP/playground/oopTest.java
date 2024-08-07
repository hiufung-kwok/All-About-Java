package codePattern.OOP.playground;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Stack;


class Broker {};

// Alarm
// Condition
// Action

abstract class Alarm implements Comparable {

    private List<Action> actions;
    private int priority;

    public Alarm(List<Action> actions) {
        this.actions = actions;
    }

    void checkAndExecutionActions (Broker broker) {
        for (Action action : actions) {
            if (action.conditionCheck(broker)) {
                action.executeAction();
            }
        }
    }

    @Override
    public int compareTo(@NotNull Object alarm) {
        return ((Alarm)alarm).priority - this.priority;
    }
}

abstract class Condition {
    abstract boolean evaluate(Broker broker);

}

abstract class Action {

    List<Condition> conditions;


    abstract void executeAction();

    boolean conditionCheck(Broker broker) {
        for (Condition condition : conditions) {
            if (!condition.evaluate(broker)) {
                return false;
            }
        }
        return true;
    }

}


class ActionImpl extends Action {

    @Override
    void executeAction() {

    }
}


class AlarmImpl extends Alarm {

    public AlarmImpl(List<Action> actions) {
        super(actions);
    }


}

public class oopTest {

    static void processAlarms (Broker broker, List<Alarm> alarms) {
        for (Alarm alarm : alarms) {
            alarm.checkAndExecutionActions(broker);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<> ();


        Broker broker = new Broker();
        List<Alarm> alarms = List.of(new AlarmImpl(null));

        oopTest.processAlarms(broker, alarms);

    }
}
