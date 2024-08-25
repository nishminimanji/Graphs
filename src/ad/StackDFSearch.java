package ad;

public class StackDFSearch {
	 private int[] elements;
	    private int top, capacity;

	    public StackDFSearch(int capacity) {
	        this.capacity = capacity;
	        elements = new int[capacity];
	        top = -1;
	    }

	    public boolean isFull() {
	        return top == capacity - 1;
	    }

	    public boolean isEmpty() {
	        return top == -1;
	    }

	    public void push(int item) {
	        if (isFull())
	            return;
	        elements[++top] = item;
	    }

	    public int pop() {
	        if (isEmpty())
	            return Integer.MIN_VALUE;
	        return elements[top--];
	    }
	}


