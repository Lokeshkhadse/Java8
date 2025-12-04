package Stack_Queue.Using_LinkedList;

public class Stack_Using_LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node top;   // top of stack

        // Push
        public void push(int x) {
            Node newNode = new Node(x);
            newNode.next = top;   // insert at beginning
            top = newNode;
            System.out.println(x + " pushed");
        }

        // Pop
        public int pop() {
            if (top == null) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int value = top.data;
            top = top.next;        // remove first node
            return value;
        }

        // Peek
        public int peek() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }

        // Check empty
        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top = " + st.peek());

        System.out.println("Popped = " + st.pop());
        System.out.println("Popped = " + st.pop());
    }
}

