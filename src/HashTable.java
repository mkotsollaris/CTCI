/**
 * Created by Menelaos Kotsollaris on 2/26/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * //TODO
 * Class Description:
 */
public class HashTable<T>
{
    private Class<T> type;
    private ArrayList<T>[] outerArray;

    public HashTable(Class<T> type, int capacity)
    {
        this.type = type;
        //todo check..
        outerArray = new ArrayList[capacity];
        //outerArray = (ArrayList<T>[]) Array.newInstance(type, capacity);
        for(int i=0;i<outerArray.length;i++)
        {
            outerArray[i] = new ArrayList<>(type);
        }
    }

    public ArrayList<T> getInnerArrayList(int index)
    {
        if(index>length()) throw new IndexOutOfBoundsException("HashTable's length is: "+length());
        return outerArray[index];
    }

    /** Complexity: O(1)*/
    public void add(T value)
    {
        int wantedHashCode = value.hashCode() % outerArray.length;
        outerArray[wantedHashCode].add(value);
    }

    /**
     * Complexity: O(1), assuming that the given hashcode is computed correct so that it keeps collisions low.
     **/
    public boolean exists(T value)
    {
        int wantedHashCode = value.hashCode() % outerArray.length;
        ArrayList<T> arrayList = outerArray[wantedHashCode];
        for(int i = 0; i<arrayList.length(); i++)
        {
            if(arrayList.get(i) == value)
            {
                System.out.println(arrayList.get(i) + " == "+ value);
                return true;
            }
        }
        return false;
    }

    public int length()
    {
        return this.outerArray.length;
    }

    public void flush()
    {
        for(int i=0;i<outerArray.length;i++)
        {
            ArrayList<T> arr = outerArray[i];
            for(int j = 0; j<arr.length(); j++)
            {
                System.out.println(i+": "+outerArray[i].get(j));
            }
        }
    }
}