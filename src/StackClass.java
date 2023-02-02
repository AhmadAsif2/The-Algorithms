import java.util.ArrayList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

// Stack using array
class StackArray {
    private int top;
    private int size = 10;
    private int[] data;
    
    public StackArray() {
        top = -1;
        data = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int item) {
        if (isFull()) {
            return;
        }

        top++;
        data[top] = item;
    }

    public boolean isFull() {
        return top == size;
    }

    public int size() {
        return top+1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        return data[top--];
        // top--;
    }

    public int peek() {
        return data[top];
    }
}

// Stack using ArrayList
class StackArrayList {
    private ArrayList<Integer> list;
    
    public StackArrayList() {
        list = new ArrayList<>();
    }

    public void push(int item) {
        list.add(item);
    }

    public int peek() {

        if (isEmpty()) {
            return -1;
        }

        return list.get(list.size()-1);
    }

    public int pop() {

        if (isEmpty()) {
            return -1;
        }

        int top = list.size() -1;
        list.remove(top);
        return top;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

}

// Stack using linkedlist
public class StackClass {

    private static Node head;

    public StackClass() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop() {

        if (isEmpty()) {
            return -1;
        }

        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {

        if (isEmpty()) {
            return -1;
        }

        return head.data;
    }

    public void pushAtBottom(int data, StackClass s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        // recursive case
        pushAtBottom(data, s);
        s.push(top);
    }

    public void reverse(StackClass s) {

        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        // recursive case
        reverse(s);
        s.pushAtBottom(top, s);
    }

    public static void main(String[] args) {
        StackClass stk = new StackClass();

        stk.push(12);
        stk.push(44);
        stk.push(90);

        stk.reverse(stk);
        

        // stk.pop();
        // System.out.println(stk.peek());

        while (!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }

    }
}
