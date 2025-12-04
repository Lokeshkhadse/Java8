package Stack_Queue.Using_LinkedList;

public class Queue_Using_LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node start;   // front
        Node end;     // rear

        // Enqueue
        public void enqueue(int x) {
            Node newNode = new Node(x);

            if (start == null) {
                start = end = newNode;   // first node
            } else {
                end.next = newNode;      // add at end
                end = newNode;
            }

            System.out.println(x + " inserted");
        }

        // Dequeue
        public int dequeue() {
            if (start == null) {
                System.out.println("Queue Underflow");
                return -1;
            }

            int value = start.data;
            start = start.next;   // move front

            if (start == null) {
                end = null;       // queue becomes empty
            }

            return value;
        }

        // Peek (front)
        public int peek() {
            if (start == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            return start.data;
        }

        public boolean isEmpty() {
            return start == null;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front = " + q.peek());

        System.out.println("Removed = " + q.dequeue());
        System.out.println("Removed = " + q.dequeue());

        System.out.println("Front = " + q.peek());
    }
}
