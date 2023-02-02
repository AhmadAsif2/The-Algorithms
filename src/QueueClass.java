
// Queue using linkedlist
class QueueLinkedList {     

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public QueueLinkedList() {
        head = null;
        tail = null;
    }

    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public String remove() {

        if (head == null) {
            return "queue is empty";
        }

        if (head == tail) {
            tail= null;
        }

        String front = head.data;
        head = head.next;
        return front;
    }

    public String peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

// Circular Queue
class CircularQueue {
    private int front;
    private int rear;   
    private int size;
    private int[] arr;

    public CircularQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        arr = new int[size];
    }

    public void add(int data) {
        
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        
        int result = arr[front];

        if (rear == front) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return result;
    }

    public int peek() {
        return arr[front];  
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear+1) % size == front;
    }

}

public class QueueClass {
    private int[] arr;
    private int rear;
    private int size;

    public QueueClass(int n) {
        this.size = n;
        rear = -1;
        arr = new int[size];
    }

    // O(1)
    public void push(int data) {

        if (rear == size -1) {
            System.out.println("queue is full");
            return;
        }

        rear++;
        arr[rear] = data;
    }

    // O(1)
    public int remove() {  

        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        int front = arr[0];
        for (int i=0; i<rear; i++) {
            arr[i] = arr[i+1];
        }

        rear--;
        return front;
    }

    public int size() {
        return rear+1;
    }

    public int peek() {
        return arr[0];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.add(12);
        queue.add(14);
        queue.add(18);
        queue.add(20);
        queue.add(34);

        queue.remove();
        queue.remove();
        queue.add(18);
        queue.add(90);


        
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }

        QueueLinkedList q = new QueueLinkedList();
        q.add("Hello");
        q.add("I");
        q.add("am");
        q.add("Ahmad");

        System.out.println(q.peek());


        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}


