package fundamental.ComparableComparator.example2;


/**
 * Either implement the interface comparable,
 * but this will limit the sorting into one single
 * method, the better way is to create a separate
 * Comparator object instead.
 */
public class PlainPojoCar implements Comparable<PlainPojoCar> {

    public String brand;

    public int brandWeight;

    public int customerPreference;


    public PlainPojoCar(String brand, int brandWeight, int customerPreference) {
        this.brand = brand;
        this.brandWeight = brandWeight;
        this.customerPreference = customerPreference;
    }


    @Override
    public int compareTo(PlainPojoCar car) {

        //Calculate the weighted sum.
        int selfSum = brandWeight*10 + customerPreference;
        int incomingSum = car.brandWeight*10 + car.customerPreference;

        return selfSum - incomingSum;
    }

    @Override
    public String toString() {
        return "PlainPojoCar{" +
                "brand='" + brand + '\'' +
                ", brandWeight=" + brandWeight +
                ", customerPreference=" + customerPreference +
                '}';
    }
}
