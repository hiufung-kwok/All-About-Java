package advanced.serviceLoader;

import com.google.auto.service.AutoService;

@AutoService(PayService.class)
public class SamsungPay implements PayService{
    @Override
    public String getProviderName() {
        return "Samsung Pay";
    }
}
