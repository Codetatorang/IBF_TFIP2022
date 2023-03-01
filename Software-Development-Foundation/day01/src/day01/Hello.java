//package name
package src.day01;

public class Hello {
    // entry point
    public static void main(String[] args) {
        System.out.printf("hello, world\n");
        System.out.printf("args.length = %d\n", args.length);

        // print the contentse of args array
        for (int i = 0; i < args.length; i++) {
            System.out.printf(">>>>> args[%d] = %s\n", i, args[i]);
        }
    }
}
