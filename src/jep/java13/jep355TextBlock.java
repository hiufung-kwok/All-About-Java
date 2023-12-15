package jep.java13;


/**
 * By using text block can largely replace the need of extensive quoting.
 * Ref: https://openjdk.org/jeps/355
 */
public class jep355TextBlock {

    public static void main(String[] args) {

        // Initial preview for JDK 13.
        String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

        // Upon JDK 14, \ and \s can be used also.

        // To skip newline char by putting \ at the end.
        String stillThisIsASingleLine = """
            A quick brown fox jumps over a lazy dog; \
            the lazy dog howls loudly.""";

        // \s for single space
        String singleSpace = """
            A quick\sbrown\sfox\sjumps\sover\sa\slazy dog; \
            the\slazy\sdog\showls\sloudly.""";

        System.out.println(stillThisIsASingleLine);
        System.out.println(singleSpace);


    }
}
