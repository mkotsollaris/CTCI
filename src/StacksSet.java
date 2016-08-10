/**
 * Created by Menelaos Kotsollaris on 3/24/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description:
 */
public class StacksSet<T>
{
    private LinkedList<Stack<T>> linkedList;
    int length;

    //the maximum number of elements that an individual stack can contain
    private static final int capacityThreshold = 10;

    public StacksSet()
    {
        length = 0;
        linkedList = new LinkedList<>();
    }

    public void push(T element)
    {
        if(linkedList.getTail().getElement().getLength() == capacityThreshold)
        {
            //adding new stack in the list
            linkedList.addToTail(new Stack<T>());
        }
        else
        {
            linkedList.getTail().getElement().push(element);
        }
        linkedList.getTail().getElement().push(element);
        length++;
    }

    public boolean pop()
    {
        return (linkedList.remove(linkedList.getTail().getElement()));
    }

    public void flush()
    {
        for(int i = 0; i < linkedList.length; i++)
        {
            Stack<T> currStack = linkedList.get(i).getElement();
            if(currStack == null) return;
            for(int j = 0; j < currStack.getLength(); j++)
            {
                System.out.println(currStack.get(j).getElement());
            }
        }
    }

    public int getCapacityThreshold()
    {
        return capacityThreshold;
    }
}