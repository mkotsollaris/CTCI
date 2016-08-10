/**
 * Created by Menelaos Kotsollaris on 3/18/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description:
 */
public class ListNode<T>
{
    private T data;
    private ListNode<T> next;
    private ListNode<T> previous;
    public ListNode(T data)
    {
        this.data = data;
        previous = null;
        next = null;
    }
    public ListNode(T data, ListNode<T> next, ListNode<T> previous)
    {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    public T getElement()
    {
        return data;
    }
    public ListNode<T> getPrevious()
    {
        return previous;
    }
    public void setPrevious(ListNode<T> previous)
    {
        this.previous = previous;
    }
    public ListNode<T> getNext()
    {
        return next;
    }
    public void setNext(ListNode<T> next)
    {
        this.next = next;
    }
    public void setData(T data)
    {
        this.data = data;
    }
    public boolean hasNext()
    {
        return next != null;
    }
    public boolean compare(ListNode<T> listNode)
    {
        return (listNode == this);
    }
}