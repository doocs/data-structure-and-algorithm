package com.Fundamentals.Stack;

import java.lang.*;

/*define the manipulation of stack*/
public interface Stackkk<T>
{
    int length();

    T peek();//cat the element if the head of stack, whereas not remove it

    int search(T t); //return the addr of obj in stack

    boolean push(T data);

    T pop();

    boolean isEmpty();

    void clear();
}



/*THE ARRAY OF STACK*/

public class ImpArrayStac<T> implements Stackkk<T> {

    private T[] t = (T[]) new Object[16]; //stack items
    private int size = 0;//number of items

    @Override
    public int length() {
        return size;
    }

    public void resize() {
    //Move stack to a new array of size max.
        T[] tmp = (T[]) new Object[t.length * 2];//can be insted of max
        for (int i = 0; i < t.length; i++) {
            tmp[i] = t[i];
            t[i] = null;
        }
        t = tmp;
        tmp = null;//便于gc处理，提高程序效率
    }


	/*查看栈顶元素，但是并不删除*/
    @Override
    public T peek() {
        if (size == 0)
            return null;
        else {
            return t[size - 1];
        }
    }

    @Override
    public int search(T t) {
        for (int i = 0; i < size; i++)
            if (t.equals(this.t[i]))
                return i + 1;
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < t.length; i++)
            t[i] = null;
        size = 0;
        //将其引用只为null，方便gc进行回收
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean push(T data) {
        if (size >= t.length) {
            resize();
        }
        //Add item to top of stack.
        t[size++] = data;
        return true;
    }

    @Override
    //if (N > 0 && N == a.length/4) resize(a.length/2);
    public T pop() {
        if (size == 0)
            return null;
            // Avoid loitering
        else
            {
                T tmp = t[size-1];
                t[size-1] = null;
                size--;
                //Remove item from top of stack.
                return tmp;
            }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack:\n[\n");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(" " + t[i].toString());
            if (i != size + 1) {
                sb.append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        com.Fundamentals.Stack.ImpArrayStac<String> arrayStack = new com.Fundamentals.Stack.ImpArrayStac<>();
        arrayStack.push("Hello");
        arrayStack.push("World");
        arrayStack.push("00001");
        arrayStack.push("00002");
        arrayStack.pop();
        arrayStack.peek();
        arrayStack.pop();
        System.out.println(arrayStack.toString());

    }
}
