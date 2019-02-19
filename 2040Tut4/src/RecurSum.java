public class RecurSum {
    public static int sum(int n) {
        if (n == 1) {
            System.out.println("Sum(1) = 1");
            return 1;
        }
        System.out.println("Sum(" + n + ") = " + n + " + Sum(" + (n - 1) + ")");
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}