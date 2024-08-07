package jep.java9;

public class jep102ProcessAPI {

    public static void main(String[] args) {
        /*
         * Now more information are available for the process.
         */
        ProcessHandle processHandle = ProcessHandle.current();
        ProcessHandle.Info processInfo = processHandle.info();
        System.out.println();
        System.out.println("PID: " + processHandle.pid());
        System.out.println("Arguments: " + processInfo.arguments());
        System.out.println("Command: " + processInfo.command());
        System.out.println("Instant: " + processInfo.startInstant());
        System.out.println("Total CPU duration: " + processInfo.totalCpuDuration());
        System.out.println("User: " + processInfo.user());

    }
}
