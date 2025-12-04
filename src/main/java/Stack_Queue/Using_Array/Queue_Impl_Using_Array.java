package Stack_Queue.Using_Array;

public class Queue_Impl_Using_Array {

    static class Queue {
        int[] arr = new int[5];  // queue size = 5
        int start = 0;           // front index
        int end = 0;             // rear index
        int size = 0;            // number of elements

        // Enqueue
        public void enqueue(int x) {
            if(size == arr.length){
                System.out.println("Queue overflow");
                return ;
            }
            arr[end] = x;
            end = (end + 1) % arr.length;
            size++;

            System.out.println(x + " inserted");
        }

        // Dequeue
        public int dequeue() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int removed = arr[start];
            start = (start +1)% arr.length; // circular increment
            size--;

            return removed;
        }

        // Peek (front element)
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");// circular increment
                return -1;
            }
            return arr[start];
        }

        // Check if empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check if full
        public boolean isFull() {
            return size == arr.length;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Front = " + q.peek());

        System.out.println("Removed = " + q.dequeue());
        System.out.println("Removed = " + q.dequeue());

        q.enqueue(60);  // circular insert
        q.enqueue(70);  // circular insert

        System.out.println("Front = " + q.peek());
    }
}
