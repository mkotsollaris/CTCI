/**
 * Created by Menelaos Kotsollaris on 3/18/2016. Contact: mkotsollari@gmail.com
 * All rights Reserved. <p> Class Description:
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

    T getElement()
    {
        return data;
    }

    ListNode<T> getPrevious()
    {
        return previous;
    }

    void setPrevious(ListNode<T> previous)
    {
        this.previous = previous;
    }

    ListNode<T> getNext()
    {
        return next;
    }

    void setNext(ListNode<T> next)
    {
        this.next = next;
    }

    void setData(T data)
    {
        this.data = data;
    }

    boolean hasNext()
    {
        return next != null;
    }

    boolean compare(ListNode<T> listNode)
    {
        return (listNode == this);
    }
}