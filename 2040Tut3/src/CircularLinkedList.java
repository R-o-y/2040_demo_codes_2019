package src;

class ListNode<T> {
    private T element;
    private ListNode<T> next = null;

    public ListNode(T element, ListNode<T> next) {
        this.element = element;
        this.next = next;
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

public class CircularLinkedList<E> {
    private int _size = 0;
    private ListNode<E> _head = null;
    private ListNode<E> _tail = null;

    public CircularLinkedList(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            this.addFirst(arr[i]);
        }
    }

    public void addFirst(E element) {
        _size++;
        _head = new ListNode<E>(element, _head);
        if (_tail == null)
            _tail = _head;
        _tail.setNext(_head);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(", ");
        ListNode<E> curr = this._head;
        while (curr != this._tail) {
            builder.append(curr.getElement().toString() + ", ");
            curr = curr.getNext();
        }
        if (this._tail != null)
            builder.append(this._tail.getElement().toString() + ", ");
        return builder.toString();
    }

    public void swap(int index) {
        if (_size < 2)
            return; // if 0 or 1 nodes, do not bother

        if (_size == 2) {
            ListNode<E> newTail = _head;
            _head = _tail;
            _tail = newTail;
            return;
        } // if 2 nodes, only need to swap head and tail references

        // At this point, the list has >2 nodes
        index = index % _size; // ensure that index < size of list first

        // get the 3 desired nodes
        ListNode<E> prev = _tail;
        for (int loopIdx = 0; loopIdx < index; loopIdx++)
            prev = prev.getNext();
        ListNode<E> curr = prev.getNext(); // curr now at indexed node
        ListNode<E> succ = curr.getNext();

        // swap the 2 nodes: Note the order!
        curr.setNext(succ.getNext());
        succ.setNext(curr);
        prev.setNext(succ);

        // update _head and _tail
        if (index == 0) {
            _head = succ; // head incorrect
        } else if (index == _size - 2) {
            _tail = curr; // swap(tail-1), tail incorrect
        } else if (index == _size - 1) {
            _head = curr; // swap(tail), both head & tail swapped
            _tail = succ;
        }
    }

    public void swap2(int index) {
        if (_size <= 2) {
            ListNode<E> newTail = _head;
            _head = _tail;
            _tail = newTail;
            return;
        } // if <= 2 nodes, only need to swap head and tail references becuase circular

        // At this point, the list has >2 nodes
        index = index % _size; // ensure that index < size of list first

        // get the 3 desired nodes
        ListNode<E> prev = _tail;
        for (int loopIdx = 0; loopIdx < index; loopIdx++)
            prev = prev.getNext();
        ListNode<E> curr = prev.getNext(); // curr now at indexed node
        ListNode<E> succ = curr.getNext();

        // swap the 2 nodes: Note the order!
        curr.setNext(succ.getNext());
        succ.setNext(curr);
        prev.setNext(succ);

        // update _head and _tail
        if (index == 0)
            _head = succ; // head incorrect
        else if (index == _size - 2)
            _tail = curr; // swap(tail-1), tail incorrect
        else if (index == _size - 1) {
            _head = curr; // swap(tail), both head & tail swapped
            _tail = succ;
        }
    }

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }

    public static void test1() {
        Integer[] arr1 = { 1, 2, 4, 6 };
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>(arr1);
        System.out.println(list);
        list.swap(5);
        System.out.println(list);
        list.swap(3);
        System.out.println(list);
        System.out.println();
        CircularLinkedList<Integer> list2 = new CircularLinkedList<Integer>(arr1);
        System.out.println(list2);
        list2.swap2(5);
        System.out.println(list2);
        list2.swap2(3);
        System.out.println(list2);
    }

    public static void test2() {
        Integer[] arr1 = { 1, 2 };
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>(arr1);
        System.out.println(list);
        list.swap(1);
        System.out.println(list);
        System.out.println();
        CircularLinkedList<Integer> list2 = new CircularLinkedList<Integer>(arr1);
        System.out.println(list2);
        list2.swap2(1);
        System.out.println(list2);
    }
}