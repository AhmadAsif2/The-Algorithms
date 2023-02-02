import java.util.LinkedList;

public class LL {
    class Node {
        String data;
        Node next;
        public int length;
    

        Node(String data) {
            this.data = data;
        }
    }

    int size;

    Node head;  

    public LL() {
        head = null;
        this.size = 0;
    }

    public void addLast(String name) {
        
        size++;
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }


    public void addFirst(String name) {
        size++;
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int getSize() {
        return size;
    }

    public void removeAt(int index) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node currNode = head;
        int count = 1;

        while (count < index - 1) {
            currNode = currNode.next;
            count++;
        }

        Node temp =  currNode.next.next;
        currNode.next = temp;
    }

    public void removeLast() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        size--;
        Node prevNode = null;
        Node currNode = head;  
        
        while (currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        prevNode.next = null;
    }

    public String getFirst() {
        return head.data;
    }

    public String getLast() {
        Node lastNode = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        return lastNode.data;
    }

    public void removeFirst() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
    }

    public void printList() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data+ "->");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        var ll = new LL();
        ll.addLast("this");
        ll.addLast("is");
        ll.addLast("a");
        ll.addLast("string");

        // ll.removeFirst();
        // ll.removeLast();

        ll.removeAt(2);
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

        ll.printList();
        System.out.println(ll.getSize());

        var list = new LinkedList<Integer>();
        list.add(12);
        list.add(14);
        list.add(78);
        list.add(100);
    }
}
