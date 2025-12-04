package Stack_Queue.Using_Array;

public class Stack_Impl_Using_Array {

    static class Stack{
        int arr[] = new int[5];
        int top = -1;

        public void push(int x){
            if(top == arr.length-1){
                System.out.println("stack overflow");
                return ;
            }
            top = top+1;
            arr[top] = x;
            System.out.println("pushed");
        }

        public int pop(){
            if(top == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            int removed = arr[top];
            top = top -1;
            return removed;

        }

        public int top(){
            if(top == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top];
        }

        public int size(){
            return top+1;
        }

        public boolean isEmpty(){
            return top == -1;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element = " + st.top());
        System.out.println("Size = " + st.size());

        System.out.println("Removed = " + st.pop());
        System.out.println("Removed = " + st.pop());

        System.out.println("Top element = " + st.top());
        System.out.println("Size = " + st.size());
    }
}
