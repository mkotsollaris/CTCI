/**
 * Created by Menelaos Kotsollaris on 3/21/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description: LIFO
 */
public class Stack<T>
{
    protected LinkedList<T> linkedList;

    public Stack()
    {
        this.linkedList = new LinkedList<>();
    }

    public void push(T element)
    {
        this.linkedList.addToTail(element);
    }

    public void push(LinkedList<T> linkedList)
    {
        if(linkedList == null) return;
        for(int i = 0; i < linkedList.length; i++)
        {
            this.linkedList.addToTail(linkedList.get(i).getElement());
        }
    }

    protected ListNode<T> getHead()
    {
        return linkedList.getHead();
    }

    protected ListNode<T> getTail()
    {
        return linkedList.getTail();
    }

    public void flush()
    {
        linkedList.flush();
    }

    /**
     * Remove the last node from the stack
     */
    public void pop()
    {
        linkedList.remove(linkedList.getTail());
    }

    public boolean remove(T element)
    {
        return (linkedList.remove(element));
    }

    public int getLength()
    {
        return linkedList.length;
    }

    public ListNode<T> get(int index)
    {
        return linkedList.get(index);
    }

    public boolean isEmpty()
    {
        return (linkedList.length == 0);
    }
}