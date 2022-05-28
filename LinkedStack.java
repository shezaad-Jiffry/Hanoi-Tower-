//Student 1 full name:Shezaad Jiffry
//Student 2 full name:N/A
//==================================================

/**
 * the class <b>LinkedStack</b> implements a linked stack. By utilizing
 * the classes Stack and Elem, this class is able to 
 * create a functional stack of elements that point towards the
 * next element in the stack until we reach the end of the stack.
 * contains one instance variable "top" that represents the top
 * of the stack and several methods that are implemented from the
 * interface Stack
 */

public class LinkedStack implements Stack {
    /**
    * the class <b>Elem</b> is used to help implement LinkedStack.
    * the instance variable value stores any generic object
    * while the instance variable next points towards
    * another Elem which will have its own value and next variable
    * creating a link until the variable next is null, ending the chain
    */
    public static class Elem {
        private Object value;
        private Elem next;
        
        /**
         * Constructor that has users of the class specify
         * the variables value and next
         * used in the class LinkedStack
         * @param value represents any generic object, this is the "content" part
         * @param next represents the next element in our link, if null then the chain has ended
         */
        public Elem(Object value, Elem next){
            this.value = value;
            this.next = next;
        }
    }

	private Elem top;//reference to linked structure
    private int size;//reference to the size
    /**
     * Constructor for LinkedStack that sets the instance variable top to
     * null and size to 0 whenever a LinkedStack is created
    */
    public LinkedStack(){
        top = null;
        size = 0;
    }
    /**
     * Checks if the stack is empty by simply checking if top = null
     * used in: HanoiTowerGame play method
     * @return true if the stack is empty false if not
    */
    public boolean isEmpty(){
        return top == null;
    }
    /**
     * Pushes element to the top of the stack by making a temporary element that has
     * the current "top" element as its "next" parameter and then setting top to the temporary variable
     * used in: HanoiTowerGame constructor
     * @param o the element that is being set as the "value" of the new top element
    */
    public void push(Object o){
    //precondition
        if(top == null){
            size++;
            top = new Elem(o,null);
        }
        else{
            size++;
            Elem temp = new Elem(o,top);
            top = temp;
        }
    }
    /**
     * returns top element of stack, specifically the "value" portion
     * used in: 
     * @return value of top element of stack
    */
    public Object peek(){
        if(isEmpty())
            return null;
        return top.value;
    }
    /**
     * returns top element's value and removes it by first storing the
     * top element in a temporary variable, setting the next top element
     * to the next element in the stack and then returning the temporary
     * elements "value"
     * used in:
     * implemented in the class LinkedStack
     * @return value of top element of stack
    */
    public Object pop(){
        Elem temp;
        //precondition
        if(top == null)
            return null;

        size--;
        temp = top;
        top = top.next;
        return temp.value;
    }
    /**
     * returns the size of the stack by simply returning
     * the size instance variable which has been altered in
     * other the other class methods
     * used in:
     * @return the amount of elements in the stack
    */
    public int size(){
        return size;
    }
    /**
     * returns a string representation of the current stack
     * by resetting top to temp after the procedure is done we
     * do not mess with the integrity of the other methods
     * used in: HanoiTowerGame.java, toString method as a way to get the values within the stack
     * input: N/A
     * @return string representation of the stack ie the values of the elements in string form
     */
    public String toString() {
        String res = "";
        Elem temp = top;
        if ( top != null ) {
                res = res + top.value;
                top = top.next;
            while ( top != null ) {
                res = res + "," + top.value;
                top = top.next;
            }
        }

        top = temp;
        return res;
    }

}