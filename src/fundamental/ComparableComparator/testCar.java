package fundamental.ComparableComparator;


public class testCar implements Comparable<testCar>{
    int horsePower;
    int wheel;

    public testCar(int horsePower, int wheel) {
        this.horsePower = horsePower;
        this.wheel = wheel;
    }

    @Override
    public int compareTo(testCar o) {
        return this.horsePower * this.wheel - o.horsePower * o.wheel;
    }
}
