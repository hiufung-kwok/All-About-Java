package testMock;

public class testMock {

    static String lowerApiCallInLowerCase (ExternalApiCall interfaceReturnStr) {
        return interfaceReturnStr.getLowerString("abc").toLowerCase();

    }

}
