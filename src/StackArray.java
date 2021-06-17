public class StackArray {

    private int[] stack;
    private int size1;
    private int size = 10;
    public StackArray() {
        stack = new int [size];
        size1 = 0;
    }

    public void push (int value) {

        //push only if the stack is not full
        //use length
        if(size1 == stack.length) {
            doubleCapacity(); //increase the capacity of stack. check void method at the bottom
        }
        stack[size1] = value;
        size1++;
    }

    public int pop(){
        //che the stack if it is empty first
        if (size1 == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int results = stack[size1 - 1];
        stack[size1 - 1] = 0; //clear out old value

        size --;
        return results;
    }
    public int peek(){
        //che the stack if it is empty first
        if (size1 == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int results = stack[size1 - 1];
        stack[size1 - 1] = 0; //clear out old value

        size --;
        return results;
    }
    public int capacity () {
        return stack.length;
    }
    public int size () {
        return size1;
    }

    public void empty () {    //empty the stack
        //optional add a for loop
        for (int i = 0 ; i < stack.length; i++) {
            stack[i] = 0;
        }
        size1 = 0;
    }

    public void compress() { //modify the array that its capacity is equal to its size (no cells unused)

        if (size1 < stack.length) {
            int newCapacity = size1;

            int [] newStack = new int[newCapacity];

            for (int i= 0; i<stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }


    public void doubleCapacity() {
        int newCapacity = 2*stack.length;

        int [] newStack = new int[newCapacity];

        for (int i= 0; i<stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public static void main (String[] args) {
        StackArray st = new StackArray();
        st.push(5);
        st.push(10);
        st.push(8);

        System.out.println(st.peek()); //NB: remember Last In Fist Out
    }

}
