package fundamental.immutable;


final public class ImmutableRGB {

    // Values must be between 0 and 255.
    final private int red;
    final private int green;
    final private int blue;
    final private String name;

    //Constructor
    public ImmutableRGB(int red,
    		int green,
    		int blue,
    		String name) {
    	//Check arg valid or not first
    	check(red, green, blue);
    	//Only assign value when it safe
    	this.red = red;
    	this.green = green;
    	this.blue = blue;
    	this.name = name;
    }
    
    //Check method
    private void check(int red,
                       int green,
                       int blue) {
        if (red < 0 || red > 255
            || green < 0 || green > 255
            || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    //Construct a brand new Obj instead, so it stay safe.
    public ImmutableRGB invert() {
    	return new ImmutableRGB(255 - red,
    			255 - green,
    			255 - blue,
    			"Inverse of " + name);
    }


    /* Getter
     * 
     */
    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public String getName() {
        return name;
    }


}
