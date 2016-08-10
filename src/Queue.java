/**
 * Created by Menelaos Kotsollaris on 3/22/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description: FIFO
 */
public class Queue<T> extends Stack<T>
{
    public Queue()
    {
        super();
    }

    @Override
    public void pop()
    {
        linkedList.remove(linkedList.getHead());
    }
}
