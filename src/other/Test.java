package other;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class Test {

	private URL legit_url;
	private URL fourOFour_url;
	private HttpURLConnection conn;
	
	@BeforeEach
	void setUp() throws Exception {
		//Setup all the resources that is needed 
		legit_url = new URL("http://google.com");
		fourOFour_url = new URL("http://www.notExist.com/bababa");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	
	/**
	 * Open up a legit connection which is expected to have a 200 as return code
	 * @throws  
	 */
	@org.junit.jupiter.api.Test
	void testOnSuccess ()  {
		try {
			conn = (HttpURLConnection)legit_url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			//Should get back 200 as return code. 
			assertEquals(200, conn.getResponseCode());
		} catch (IOException e) {
			fail("Connection fail: " + e.getMessage());
		}
	}
	
	
	/**
	 * By having a malformed end-point, expected to have a 404 as response. 
	 */
	@org.junit.jupiter.api.Test
	void testOnFourOFour ()  {
		try {
			conn = (HttpURLConnection)fourOFour_url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			//Make sure it give back 404 first
			assertEquals(404, conn.getResponseCode());
			
			//From this point onward can perform further assertions under the response context.
			//Assertion......abababba, expected behavour babbababa..........
		} catch (IOException e) {
			fail("Connection fail: " + e.getMessage());
		}
	}
	



}
