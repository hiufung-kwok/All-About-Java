package advanced.serviceLoader;

import java.util.ServiceLoader;

public class ServiceLoaderMain {

    public static void main(String[] args) {
        // This won't work by default as class name is not part of the manifest, either add it or use Google auto-service.
        ServiceLoader<PayService> serviceLoader = ServiceLoader.load(PayService.class);
        for (PayService ps : serviceLoader) {
            System.out.println(ps.getProviderName());
        }
    }
}
