package designPattern.strategy;

public class ComplexDecoder implements BaseStrategy{
    @Override
    public String decode(String input) {
        return "I'm a complex decoder";
    }
}
