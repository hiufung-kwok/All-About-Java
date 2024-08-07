package advanced.serviceLoader;


import com.google.auto.service.AutoService;

@AutoService(PayService.class)
public class ApplePayService implements PayService{

    @Override
    public String getProviderName() {
        return "Apple Pay";
    }
}
