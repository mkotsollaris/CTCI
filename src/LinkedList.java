import org.jetbrains.annotations.Contract;

/**
 * Created by Menelaos Kotsollaris on 3/18/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description: Double Linked ArrayList as described in the CTCI
 */
public class LinkedList<T>
{
    private ListNode<T> headNode;
    private ListNode<T> tailNode;
    int length;

    public LinkedList()
    {
        length = 0;
    }

    public LinkedList(T element)
    {
        initialize(element);
    }

    private void initialize(T element)
    {
        ListNode<T> elementNode = new ListNode<>(element);
        headNode = elementNode;
        tailNode = elementNode;
        length = 1;
    }

    /**
     * Returns the last ListNode (tail) of the LinkedList.
     * <p>
     * In case of no tail returns null.
     */
    public ListNode<T> getTail()
    {
        return tailNode;
    }

    /**
     * O(1) Complexity
     */
    public void addToTail(T element)
    {
        if(headNode == null)
        {
            initialize(element);
            return;
        }
        ListNode<T> newNode = new ListNode<>(element);
        tailNode.setNext(newNode);
        newNode.setPrevious(tailNode);
        tailNode = newNode;
        length++;
    }

    public void addToHead(T element)
    {
        if(headNode == null)
        {
            initialize(element);
            return;
        }
        ListNode<T> newNode = new ListNode<T>(element);
        headNode.setPrevious(newNode);
        newNode.setNext(headNode);
        headNode = newNode;
        length++;
    }

    /**
     * Removes All the data that match and fixes the pointers.
     * <p>
     * TODO test
     */
    public boolean remove(T data)
    {
        ListNode<T> currNode = headNode;
        if(headNode == null) return false;
        do
        {
            if(currNode.getElement() == data)
            {
                if(currNode == tailNode) tailNode = currNode.getPrevious();
                if(remove(currNode)) return true;
            }
            currNode = currNode.getNext();
        }
        while (currNode != null);
        return false;
    }

    //FIXME does not makes head/ tail null...
    public boolean remove(ListNode<T> element)
    {
        if(headNode == null) return false;//empty list
        boolean linkedListAltered = false;
        if(element == headNode)
        {
            linkedListAltered = true;
            headNode = headNode.getNext();
        }
        if(element == tailNode)
        {
            linkedListAltered = true;
            tailNode = tailNode.getPrevious();
        }
        if(element.getPrevious() != null)
        {
            element.getPrevious().setNext(element.getNext());
            linkedListAltered = true;
        }
        if(element.getNext() != null)
        {
            element.getNext().setPrevious(element.getPrevious());
            linkedListAltered = true;
        }
        if(linkedListAltered) length--;
        return linkedListAltered;
    }

    /**
     * If the next node of newNode is null, then newNode will be the Tail.
     */
    @Contract("null -> false")
    private boolean updateTail(ListNode<T> newNode)
    {
        if(newNode != null && newNode.getNext() == null)
        {
            tailNode = newNode;
            return true;
        }
        return false;
    }

    /**
     * Removes middle node (if it's not the head or tail) by using the "Runner Technique"
     * <p>
     * returns whether the middle element was removed or not (as described in p.94)
     */
    public boolean removeMiddleNode()
    {
        ListNode<T> fastNode = headNode;//first "fast" pointer
        ListNode<T> slowNode = headNode;//second "slow" pointer
        int iterationCounter = 0;
        if(headNode == null) return false;
        while (true)
        {
            iterationCounter++;
            //System.out.println("itr: " + iterationCounter);
            if(fastNode.getNext() != null)
            {
                fastNode = fastNode.getNext();
            }
            else
            {
                if(iterationCounter > 2)
                {
                    slowNode.getPrevious().setNext(slowNode.getNext());
                    slowNode.getNext().setPrevious(slowNode.getPrevious());
                    if(slowNode.getNext() == null) updateTail(slowNode);
                    else updateTail(slowNode.getNext());
                    return true;
                }
                else
                {
                    return false;
                }
            }
            if(iterationCounter % 2 == 0)
            {
                slowNode = slowNode.getNext();
            }
            fastNode.setNext(fastNode.getNext());
        }
    }

    /**
     * Returns the first element that matches with the T data. Null in case of not existing element
     *
     * @param data: the value of the element
     *              <p>
     *              Complexity : O(N)
     */
    public ListNode<T> get(T data)
    {
        ListNode<T> currNode = headNode;
        while (currNode.hasNext())
        {
            if(currNode.getElement() == data)
            {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return null;
    }

    /**
     * Complexity : O(N)
     */
    public boolean find(T element)
    {
        ListNode<T> currNode = headNode;
        while (currNode != null)
        {
            if(currNode.getElement() == element)
            {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    //FIXME wrong
    public ListNode<T> get(int index)
    {
        ListNode<T> currNode = headNode;
        int counter = 0;
        while (true)
        {
            if(counter == index)
            {
                return currNode;
            }
            currNode = currNode.getNext();
            if(currNode == null) return null;
            counter++;
        }
    }

    public void flush()
    {
        ListNode currNode = headNode;
        while (currNode != null)
        {
            System.out.println(currNode.getElement());
            currNode = currNode.getNext();
        }
    }

    public ListNode<T> getHead()
    {
        return headNode;
    }

    /**
     * Returns a LinkedList whose elements are in the reversed order with the stack
     * <p>
     * Complexity: O(N)
     */
    public LinkedList<T> getInverse()
    {
        LinkedList<T> newLinkedList = new LinkedList<>();
        ListNode<T> currNode = headNode;
        while (currNode != null)
        {
            newLinkedList.addToHead(currNode.getElement());
            currNode = currNode.getNext();
        }
        return newLinkedList;
    }
}