package other;

import org.neo4j.cypher.internal.runtime.interpreted.pipes.aggregation.NumericExpressionOnly;

import java.util.Optional;

public class OptionalTest {

    static class City {
        private String name;

        public City(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Address {
        private City city;

        public Address(City city) {
            this.city = city;
        }

        public Optional<City> getCity() {
            return Optional.ofNullable(city);
        }
    }

    static class Person {
        private Address address;

        public Person(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }
    }


    public static void main(String[] args) {

        City city = new City("Toronto");
        Address address = new Address(city);
        Person person = new Person(address);

        // Using flatMap to get the city name if it exists
        Optional<String> cityName = person.getAddress()
                .flatMap(Address::getCity)
                .map(City::getName);

        cityName.ifPresent(System.out::println);  // Output: Toronto

        // Example with a person without an address
        Person personWithoutAddress = new Person(null);
        Optional<String> cityNameWithoutAddress = personWithoutAddress.getAddress()
                .flatMap(Address::getCity)
                .map(City::getName);

        cityNameWithoutAddress.ifPresent(System.out::println);  // No output

        // Example with city but not name
        City unNamedCity = new City(null);
        Address invalidAddress = new Address(unNamedCity);
        Person personWIthCityWithoutName = new Person(invalidAddress);
        Optional<String> cityNameNull = personWIthCityWithoutName.getAddress()
                .flatMap(Address::getCity)
                .map(City::getName);

        cityNameNull.ifPresent(System.out::println);
        ;



    }
}
