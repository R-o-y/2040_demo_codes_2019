import java.util.Stack;

public class StackRecursion {
    // this method will disrupt the stack, since no codes for recovery after pop
    public static int sum(Stack<Integer> s) {
        if (s.empty()) {
            return 0;
        } else {
            return s.pop() + sum(s);
        }
    }

    public static void insert(Stack<Integer> s, Integer val) {
        if (s.empty() || s.peek() < val) {
            s.push(val);
        } else {
            Integer temp = s.pop();
            insert(s, val);
            s.push(temp);
        }
    }

    public static void delete(Stack<Integer> s, Integer val) {
        if (s.empty())
            System.out.println("Requested value not in Stack!");
        else {
            if (s.peek() == val)
                s.pop();
            else {
                Integer temp = s.pop();
                delete(s, val);
                s.push(temp);
            }
        }
    }

    public static void sort(Stack<Integer> s) {
        /*
         * if write in loop. this method is equivalent to: start from back to front,
         * keep inserting the element at the current position to the rest part of the
         * sorted array
         * 
         * good example to demo wishful thinking
         */
        if (!s.empty()) {
            Integer temp = s.pop();
            sort(s);
            insert(s, temp);
        }
    }

    public static void sort2(Stack<Integer> s) {

    }

    public static void main(String[] args) {

    }
}