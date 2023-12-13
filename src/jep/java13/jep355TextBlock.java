package jep.java13;


/**
 * By using text block can largely replace the need of extensive quoting.
 * Ref: https://openjdk.org/jeps/355
 */
public class jep355TextBlock {

    public static void main(String[] args) {
        String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
    }
}
