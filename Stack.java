//Student 1 full name:Shezaad Jiffry
//Student 2 full name:N/A
//==================================================

/**
 * The interface <b>Stack</b> is an interface that is implenmented within the class LinkedStack.
 * works in conjunction Elem to create our implementation of a linked stack.
 * has 5 methods, isEmpty, push, peek, pop, size that are all used in
 * our implementation of a linked stack
 */

public interface Stack {
    /**
     * Checks if the stack is empty
     * implemented in the class LinkedStack
     * @return true if the stack is empty false if not
     */
    public abstract boolean isEmpty();
    /**
     * Pushes element to the top of the stack
     * implemented in the class LinkedStack
     * @param o the element that is getting put ontop of the stack
     */
    public abstract void push(Object o);
    /**
     * returns top element of stack
     * implemented in the class LinkedStack
     * @return top element of stack
     */
    public abstract Object peek();
    /**
     * returns top element of stack and removes it from the stack
     * implemented in the class LinkedStack
     * @return top element of stack
     */
    public abstract Object pop();
    /**
     * returns the size of the stack
     * implemented in the class LinkedStack
     * @return size/length of stack
     */
    public abstract int size();
}