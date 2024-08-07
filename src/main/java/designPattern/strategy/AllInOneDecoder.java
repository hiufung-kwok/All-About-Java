package designPattern.strategy;

public class AllInOneDecoder {
    public String decode (String input, DecoderOptions option) {
        return switch (option) {
            case SIMPLE -> new SimpleDecoder().decode(input);
            case COMPLEX -> new ComplexDecoder().decode(input);
        };
    }
}
