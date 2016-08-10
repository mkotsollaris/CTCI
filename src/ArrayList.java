import org.jetbrains.annotations.Contract;
import java.lang.reflect.Array;

/**
 * Created by Menelaos Kotsollaris on 2/25/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 */
public class ArrayList<T>
{
    private Class<T> type;
    private T[] myArray;
    /**shows the current capacity*/
    private int currentIndex;

    public ArrayList(Class<T> type)
    {
        this(type,1);
    }

    public ArrayList(Class<T> type, int capacity)
    {
        currentIndex = 0;
        this.type = type;
        myArray = (T[]) Array.newInstance(type, capacity);
    }

    @Contract(pure = true)
    public int getMaxLength()
    {
        return myArray.length;
    }

    public T get(int index)
    {
        if(index > getMaxLength() || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return myArray[index];
    }

    public void add(T newElement)
    {
        if(currentIndex == getMaxLength())
        {
            //copy the elements in a new array with double length
            myArray = extendArray();
        }
        myArray[currentIndex] = newElement;
        currentIndex++;
    }

    public int length()
    {
        return this.currentIndex;
    }
    /**
     * Prints the elements of the list
     */
    public void flush()
    {
        for(int i = 0; i < currentIndex; i++)
        {
            System.out.println(myArray[i]);
        }
    }

    /**
     * @return The times that T element is found
     * */
    public int containCount(T element)
    {
        int counter = 0;
        for(int i=0;i<currentIndex;i++)
        {
            if(myArray[i] == element)counter++;
        }
        return counter;
    }

    /**
     * Searches for the element: O(N)
     *
     * @param element the searching element
     */
    public boolean contains(T element)
    {
        for(int i = 0; i <= currentIndex; i++)
        {
            if(myArray[i] == element)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes an element from the list. In case of duplication, it removes all the elements
     * that match the statement.
     *
     * @return true if the list was modified, in the other case false.
     * <p>
     * TODO rebalanceArray the list
     */
    public boolean remove(T element)
    {
        boolean flag = false;
        int counter = 0; //the number of elements that are being removed
        for(int i = 0; i <= currentIndex; i++)
        {
            if(myArray[i] == element)
            {
                flag = true;
                counter++;
                myArray[i] = null;
            }
        }
        if(flag)
        {
            rebalanceArray();
        }
        currentIndex -= counter;
        return false;
    }

    /**
     * Whenever it finds null element, it checks for the next non-null element and fills it up.
     * In the end of the balancing, it updates the currentIndex with the number of effected elements.
     *
     * Complexity: ~O(N^2), TODO confirm ~ Probably it could be faster
     */
    private void rebalanceArray()
    {
        for(int i=0;i<currentIndex;i++)
        {
            if(myArray[i]==null)
            {
                for(int j=i+1;j<=currentIndex;j++)
                {
                    if(myArray[j]!=null)
                    {
                        T element  = myArray[j];
                        myArray[i] = element;
                        myArray[j] = null;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Copy the elements in a new array with double length
     */
    private T[] extendArray()
    {
        T[] myNewArray = (T[]) Array.newInstance(this.type, 2 * getMaxLength());
        for(int i = 0; i < myArray.length; i++)
        {
            myNewArray[i] = myArray[i];
        }
        return myNewArray;
    }
}
