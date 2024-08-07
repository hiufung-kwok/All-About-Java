package designPattern.strategy;

public class SimpleDecoder implements BaseStrategy{
    @Override
    public String decode(String input) {
        return "I'm a simple decoder";
    }
}
