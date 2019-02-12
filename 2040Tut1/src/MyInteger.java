import java.util.Arrays;

class MyInteger {
    public int x;

    public MyInteger(int n) {
        x = n;
    }

    public static void swap1(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap2(MyInteger a, MyInteger b) {
        int temp = a.x;
        a.x = b.x;
        b.x = temp;
    }

    public static void swap3(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swapInteger(Integer x1, Integer x2) {
        Integer temp = x1;
        x1 = x2;
        x2 = temp;
    }

    public static void runSwapInteger() {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);

        swapInteger(integer1, integer2);
        System.out.println(String.format("integer1: %d", integer1));
        System.out.println(String.format("integer2: %d", integer2));
    }

    public static void modifyArray(int[] arr) {
        arr[0] = 100000000;
    }

    public static void runModifyArray() {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(arr));

        // array is passed by referrence. Because arrays are objects?
        modifyArray(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void runValueEqualAndReferenceEqual() {
        int int1 = 1;
        int int2 = 1;
        System.out.println(int1 == int2);

        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);
        System.out.println(integer1 == integer2);

        int[] arr1 = { 1, 2, 3, 4 };
        int[] arr2 = { 1, 2, 3, 4 };
        System.out.println(arr1 == arr2);
    }

    public static void runIsArrayObject() {
        // array of primitive types
        int[] intArr = { 1, 2, 3, 4 };
        char[] charArr = { 'a', 'b' };
        boolean[] booleanArr = { true, false };

        // https://docs.oracle.com/javase/specs/jvms/se9/html/jvms-4.html#jvms-4.3.2
        System.out.println(intArr.getClass().getName());
        System.out.println(intArr.getClass().getSuperclass().getName());
        System.out.println(charArr.getClass().getName());
        System.out.println(charArr.getClass().getSuperclass().getName());
        System.out.println(booleanArr.getClass().getName());
        System.out.println(booleanArr.getClass().getSuperclass().getName());

        // array of class instances
        Integer[] integerArr = { 1, 2, 3, 4 };
        System.out.println(integerArr.getClass().getName());
        System.out.println(integerArr.getClass().getSuperclass().getName());

        System.out.println(integerArr[0].getClass().getName());
        System.out.println(integerArr[0].getClass().getSuperclass().getName());
    }

    public static void main(String[] args) {
        // Are the int values within c and d swapped?
        // int c = 1;
        // int d = 3;
        // swap1(c, d);
        // System.out.println(String.format("c: %d", c));
        // System.out.println(String.format("d: %d\n", d));

        // // Are the int values contained in e and f swapped?
        // MyInteger e = new MyInteger(1);
        // MyInteger f = new MyInteger(2);
        // swap2(e, f);
        // System.out.println(String.format("e: %d", e.x));
        // System.out.println(String.format("f: %d\n", f.x));

        // // Are the int values within arr[1] and arr[3] swapped?
        // int[] arr = { 9, 8, 7, 6, 5 };
        // swap3(arr, 1, 3);
        // System.out.println(String.format("arr[1]: %d", arr[1]));
        // System.out.println(String.format("arr[3]: %d\n", arr[3]));

        // lets have more fun
        // runSwapInteger();
        // runModifyArray();
        // runValueEqualAndReferenceEqual();
        runIsArrayObject();
    }
}