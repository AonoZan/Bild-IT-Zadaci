
package zadaci_02_09_2016;

import java.util.ArrayList;


/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Program tests Comparable implementation.
	 * 
	 * @see <a href="https://github.com/LuizGsa21/intro-to-java-10th-edition/blob/master/src/Chapter_13/Exercise_08.java">This guys solution</a>
	*/
	public static void main(String[] args) {
		// create stack and add few items to it
		MyStack stack = new MyStack();
		for (int i = 1; i < 10; i++) {
			stack.push(i);
		}
		// clone stack and remove few items
		MyStack clone = (MyStack) stack.clone();
		clone.pop();
		clone.pop();
		// print stats
		System.out.println("Stack size: " + stack.getSize());
		System.out.println("Clone size: " + clone.getSize());
	}

}
/** Simple My stack class that implements comparable*/
class MyStack implements Cloneable {
	// store list of values
	private ArrayList<Object> list = new ArrayList<>();
	// is list empty
	public boolean isEmpty() {
		return list.isEmpty();
	}
	// get list size
	public int getSize() {
		return list.size();
	}
	// get element at the end
	public Object peek() {
		return list.get(getSize() - 1);
	}
	// remove and return last
	public Object pop() {
		Object o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	// add to the list
	public void push(Object o) {
		list.add(o);
	}

	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
	// implement comparable method
	@Override
    protected Object clone()  {
		// create brand new stack
        MyStack myStack = null;
        // cry to clone
        try {
            myStack = (MyStack) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // set list to the new stack and retrieve it
        myStack.list = new ArrayList<>(list);
        return myStack;
    }
}