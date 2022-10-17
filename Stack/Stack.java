package Stack;

import java.util.LinkedList;

public class Stack {
	protected int top;
	protected LinkedList<Object> list = new LinkedList<Object>();
	protected String name;

	public Stack(int size) {
		for (int i = 0; i < size; i++) {
			this.list.add(null);
		}
		this.top = -1;
		printStack();
		System.out.println(this.top);
	}

	public Stack(String name, int size) {
		this(size);
		this.name = name;
	}

	public Stack(Object[] array) {
		this(array.length);
		for (int i = 0; i < array.length; i++) {
			push(array[i]);
		}
		System.out.println(this.top);
	}

	public Stack(String name, Object[] array) {
		this(array);
		this.name = name;
	}

	public void push(Object element) {
		if (!isFull()) { // addLast
			int newTop = this.top + 1;
			this.list.set(newTop, element);
			this.top = newTop;
			printStack();
			System.out.println(this.top + " Success");
		} else { 
			printStack();
			System.out.println(this.top + " Overflow: Stack is full");
		}
	}

	public Object pop() {
		if (!isEmpty()) { // removeLast
			Object popItem = list.get(this.top);
			this.list.set(this.top, null);
			this.top -= 1;
			printStack();
			System.out.println(this.top + " " + popItem + " Success");
			return popItem;
		} else {
			printStack();
			System.out.println(this.top + " " + "None Underflow: Stack is empty");
		}
		return null;
	}

	public boolean isFull() {
		return this.top == this.list.size() - 1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public void printStack() {// 印出list: from down to top
		System.out.print("[");
		for (int i = 0; i < this.list.size(); i++) {

			if (this.list.get(i) instanceof Character) {// 若該項為字元則為其加上單引號
				System.out.print("'" + this.list.get(i) + "'");
			} else if (this.list.get(i) == null) {// 若該項未放入Object輸出None
				System.out.print("None");
			} else { // 否則直接輸出該項Object本身
				System.out.print(this.list.get(i));

			}

			if (i == this.list.size() - 1) {// 為list最後一項輸出下括號
				System.out.print("] ");

			} else {// 非最後一項者則加入一個逗號於尾端，與下一項分隔
				System.out.print(",");

			}

		}
	}

	public void view() {
		printStack();
		System.out.println(this.list.size() + " " + this.top);
	}

	public void resize(int size) {
		if (this.list.size() < size) {
			for (int i = this.list.size(); i < size; i++) {
				this.list.add(null);
			}
		} else {
			for (int i = this.list.size() - 1; i >= size; i--) {
				this.list.remove();
			}
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Object getPeak() {
		if (isEmpty()) {
			return -1;
		} else {
			return this.list.get(this.top);
		}
	}

	public static void main(String[] args) {

		// ==================================
		/* [None,None,None,None,None] -1 */
		System.out.println("Stack create...");
		Stack stack = new Stack(5);

		// =================================

		/*
		 * ['a',None,None,None,None] 0 Success ['a','b',None,None,None] 1 Success
		 * ['a','b','c',None,None] 2 Success ['a','b','c','d',None] 3 Success
		 * ['a','b','c','d','e'] 4 Success ['a','b','c','d','e'] 4 Overflow: Stack is
		 * full
		 */

		System.out.println("Stack push...");
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		stack.push('e');
		stack.push('f');

		// ==================================

		/*
		 * ['a','b','c','d',None] 3 e Success ['a','b','c',None,None] 2 d Success
		 * ['a','b',None,None,None] 1 c Success ['a',None,None,None,None] 0 b Success
		 * [None,None,None,None,None] -1 a Success [None,None,None,None,None] -1 None
		 * Underflow: Stack is empty
		 */
		System.out.println("Stack pop...");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		// =================================

		System.out.println("Stack view...");
		stack.view();// [None,None,None,None,None] 5 -1

		// ================================

		System.out.println("Stack resize...");
		stack.resize(8);

		// ================================
		System.out.println("Stack view...");
		stack.view();// [None,None,None,None,None,None,None,None] 8 -1

	}

}
