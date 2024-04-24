package designPattern.prototype;

/**
 * Then all other Concrete Prototype object will implement this along
 * and place the cloning logic into `clone( )` method.
 */
public interface PrototypeBase {

    PrototypeBase clone();

}
