
public class Stack {
    int[] stack;
    int size = 0;
    public Stack(int n){
        this.stack = new int[n]; 
        this.size = -1;
    }
    void push(int num) {
        if(size >= stack.length) return;
        size++;
        stack[size] = num;
        
    }
    int pop() {
        if(size == -1) return -1;
        int remove = stack[size];
        size--;
        return remove;
    }
    int top() {
        if(size == -1) return -1;
        return stack[size];
    }
    int isEmpty() {
        return size == -1 ? 1 : 0;
    }
    int isFull() {
        return size == stack.length ? 1 : 0;
    }
}
