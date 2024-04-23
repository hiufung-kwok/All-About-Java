package designPattern.bridge;

/**
 * In this case the remote can turn the TV on and off regardless of the brand.
 */
public class Remote {

    private TV tv;

    public void togglePower () {
        if (tv.isEnable()) {
            tv.disable();
        } else {
            tv.enable();
        }
    }


}
