package src;

public class WaitingQueue {
    private String[] waitingHere;
    private int front; // "Leave a gap" when array is full
    private int back; // back is the index AFTER last element
    private static final int ARR_LENGTH = 10; // At most 9 people, one more slot for gap

    public WaitingQueue() {
        waitingHere = new String[ARR_LENGTH];
    }

    public boolean isEmpty() {
        return front == back;
    }

    // Returns true if Person is successfully added
    public boolean addAPerson(String newPerson) {
        if ((back + 1) % ARR_LENGTH == front) // array full
            return false;
        waitingHere[back] = newPerson;
        back = (back + 1) % ARR_LENGTH; // circular array behavior
        return true;
    }

    public String serveNextPerson() {
        if (isEmpty())
            return null;
        String firstPerson = waitingHere[front];
        waitingHere[front] = null; // optional
        front = (front + 1) % ARR_LENGTH;
        return firstPerson;
    }

    // Returns true if someone is removed from the queue
    public boolean leave(String personName) {

        // find first matching person
        boolean found = false;
        int position = front;
        while (position != back) { // pos may NOT be < back !!!
            if (waitingHere[position].equals(personName)) {
                found = true;
                break;
            }
            position = (position + 1) % ARR_LENGTH;
        }

        if (!found)
            return false;

        // left shift elements
        waitingHere[position] = null; // optional
        position = (position + 1) % ARR_LENGTH;
        while (position != back) {
            // notice in Java, -1 % 10 = -1 rather than 9 !!!
            waitingHere[(position - 1 + ARR_LENGTH) % ARR_LENGTH] = waitingHere[position];
            position = (position + 1) % ARR_LENGTH;
        }

        // decrement back
        back = (back - 1 + ARR_LENGTH) % ARR_LENGTH;
        System.out.println(-1 % 8);
        return true;
    }

    public static void main(String[] args) {
        WaitingQueue q = new WaitingQueue();
        q.addAPerson("Person 1");
        q.addAPerson("Person 2");
        q.addAPerson("Person 3");
        q.addAPerson("Person 4");
        q.addAPerson("Person 5");
        q.addAPerson("Person 6");
        q.addAPerson("Person 7");
        q.addAPerson("Person 8");
        System.out.println(q.serveNextPerson());
        System.out.println(q.serveNextPerson());
        boolean b1 = q.leave("Person 2");
        boolean b2 = q.leave("Person 3");
        boolean b3 = q.leave("Person 4");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        while (!q.isEmpty())
            System.out.println(q.serveNextPerson());
    }
}