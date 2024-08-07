package Mockito.testMock;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import testMock.ExternalApiCall;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class testMockTest {


    @Test
    void testLowerCaseCall() {
        ExternalApiCall apiCall = Mockito.mock(ExternalApiCall.class);
        when(apiCall.getLowerString("ABC")).thenReturn("abc");

        Assert.assertEquals(apiCall.getLowerString("ABC"), "abc");



    }
}