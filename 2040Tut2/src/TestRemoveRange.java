package src;

import java.util.ArrayList;

public class TestRemoveRange extends ArrayList {
    public void removeLastOne() {
        this.removeRange(this.size() - 1, this.size());
    }

    public static void main(String[] args) {
        TestRemoveRange t = new TestRemoveRange();
        t.add(1);
        t.add(2);
        System.out.println(t);
        t.removeLastOne();
        System.out.println(t);

        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        // al.removeRange(1, 2); // not visible here

        String a = new String("a");
        String b = new String("a"); // b and a are references to different objects of the same value
        System.out.println(a == b); // --> false
        System.out.println(a.equals(b)); // --> true
    }
}