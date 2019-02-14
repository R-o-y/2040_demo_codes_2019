class ListNode<T> {
    private T element;
    private ListNode<T> next = null;

    public ListNode(T element) {
        this.element = element;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return this.element;
    }
}

public class BasicLinkedList<T> {
    public ListNode<T> head = null;

    public BasicLinkedList(ListNode<T> head) {
        this.head = head;
    }

    public BasicLinkedList(T[] arr) {
        if (arr.length > 0) {
            this.head = new ListNode<T>(arr[0]);
            ListNode<T> currTail = this.head;
            for (int i = 1; i < arr.length; i++) {
                currTail.setNext(new ListNode<T>(arr[i]));
                currTail = currTail.getNext();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode<T> curr = this.head;
        while (curr != null) {
            builder.append(curr.getElement().toString() + ", ");
            curr = curr.getNext();
        }
        return builder.toString();
    }

    private static ListNode<Integer> mergeRecur(ListNode<Integer> firstCurr, ListNode<Integer> secondCurr) {
        if (firstCurr == null)
            return secondCurr;
        else if (secondCurr == null)
            return firstCurr;
        else {
            if (firstCurr.getElement() <= secondCurr.getElement()) {
                firstCurr.setNext(mergeRecur(firstCurr.getNext(), secondCurr));
                return firstCurr;
            } else {
                secondCurr.setNext(mergeRecur(firstCurr, secondCurr.getNext()));
                return secondCurr;
            }
        }
    }

    public static BasicLinkedList<Integer> mergeUsingRecur(BasicLinkedList<Integer> firstList,
            BasicLinkedList<Integer> secondList) {
        ListNode<Integer> head = mergeRecur(firstList.head, secondList.head);

        firstList.head = null;
        secondList.head = null;
        return new BasicLinkedList<Integer>(head);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Integer[] arr1 = { 1, 2, 4, 6 };
        Integer[] arr2 = { 1, 3, 4, 5 };
        System.out.println(mergeUsingRecur(new BasicLinkedList<Integer>(arr1), new BasicLinkedList<Integer>(arr2)));
    }

    // test empty list case
    public static void test2() {
        Integer[] arr1 = {};
        Integer[] arr2 = { 1, 3, 4, 5 };
        System.out.println(mergeUsingRecur(new BasicLinkedList<Integer>(arr1), new BasicLinkedList<Integer>(arr2)));
    }
}