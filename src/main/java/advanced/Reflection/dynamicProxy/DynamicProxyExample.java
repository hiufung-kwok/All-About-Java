package advanced.Reflection.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Interface to be proxied
interface SomeInterface {
    void doSomething();
}

// Implementation of the interface
class SomeImplementation implements SomeInterface {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

// Invocation handler for the dynamic proxy
class CustomInvocationHandler implements InvocationHandler {
    private final Object target;

    public CustomInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Additional behavior before method execution
        System.out.println("Before method execution...");

        // Delegate method call to the target object
        Object result = method.invoke(target, args);

        // Additional behavior after method execution
        System.out.println("After method execution...");

        return result;
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create an instance of the target object
        SomeInterface targetObject = new SomeImplementation();

        // Create a dynamic proxy instance for the interface
        SomeInterface proxy = (SomeInterface) Proxy.newProxyInstance(
                SomeInterface.class.getClassLoader(),
                new Class<?>[]{SomeInterface.class},
                new CustomInvocationHandler(targetObject)
        );

        // Call methods on the proxy instance
        proxy.doSomething();
    }
}
