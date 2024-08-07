package jep.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * Ref:
 * https://mkyong.com/java/java-11-httpclient-examples/
 * https://openjdk.org/jeps/321
 */
public class jep321HttpClient {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        /*
         * Request.
         */
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();


        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        /*
         * Response.
         */
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println(response.statusCode());
        System.out.println(response.body());


        /*
         * Send an Async request, then check the result after 5s.
         */
        var responseAsync =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = responseAsync.thenApply(HttpResponse::body).get(15, TimeUnit.SECONDS);
        System.out.println(result);

    }
}
