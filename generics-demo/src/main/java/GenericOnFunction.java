public class GenericOnFunction {
    // by type argument inference, compiler get type form parameter.
    public static <T> void printClass(T obj) {
        System.out.println(obj.getClass().toString());
    }

    public static void main(String[] args) {
        printClass("abc");
        printClass(10);
    }
}
