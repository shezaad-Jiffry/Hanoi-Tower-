//Student 1 full name:Shezaad Jiffry
//Student 2 full name:N/A
//==================================================

/**
 * A class that is used to help implement LinkedStack.
 * the instance variable value stores any generic object
 * while the instance variable next points towards
 * another Elem which will have its own value and next variable
 * creating a link until the variable next is null, ending the chain
 */
public class Elem {
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
	/**
     * setter that allows the instance variable "value" to be changed
     * used in the class LinkedStack
     * @param value object that replaces the content of instance variable value
     */
	public void setValue(Object value) {
		this.value = value;
	}
	/**
     * setter that allows the instance variable "next" to be changed
     * used in the class LinkedStack
     * @param next Elem that replaces the content of instance variable "next"
     */
	public void setNext(Elem next) {
		this.next = next;
	}
    /**
     * getter that returns the value of "value"
     * used in the class LinkedStack
     * @return instance variable "value"
     */
	public Object getValue(){
		return value;
	}
	/**
     * getter that returns the value of "next"
     * used in the class LinkedStack
     * @return instance variable "next"
     */
	public Elem getNext(){
		return next;
	}

}