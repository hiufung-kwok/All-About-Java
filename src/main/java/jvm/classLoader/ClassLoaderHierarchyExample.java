package jvm.classLoader;

public class ClassLoaderHierarchyExample {
    public static void main(String[] args) {
        // Get the class loader of the current class
        ClassLoader currentClassLoader = ClassLoaderHierarchyExample.class.getClassLoader();
        System.out.println("Current class loader: " + currentClassLoader);

        // Get the class loader of the parent class loader
        ClassLoader parentClassLoader = currentClassLoader.getParent();
        System.out.println("Parent class loader: " + parentClassLoader);

        // Get the bootstrap class loader (primordial class loader)
        ClassLoader bootstrapClassLoader = String.class.getClassLoader();
        System.out.println("Bootstrap class loader: " + bootstrapClassLoader);

        // Display the class loader hierarchy
        displayClassLoaderHierarchy(currentClassLoader);
    }

    private static void displayClassLoaderHierarchy(ClassLoader classLoader) {
        System.out.println("ClassLoader hierarchy:");
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}

