/**
 * Created by Menelaos Kotsollaris on 3/1/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description:
 */
public class StringBuilder
{
    private ArrayList<String> arrayList;

    public StringBuilder()
    {
        this.arrayList = new ArrayList<>(String.class);
    }

    public StringBuilder(String givenString)
    {
        this.arrayList.add(givenString);
    }

    public void append(String givenString)
    {
        this.arrayList.add(givenString);
    }


    public void remove(String givenString)
    {
        this.arrayList.remove(givenString);
    }

    public String getValue()
    {
        String string = "";
        for(int i = 0; i<this.arrayList.length(); i++)
        {
            string+=arrayList.get(i);
        }
        return string;
    }

    /**
     * Source: http://algs4.cs.princeton.edu/34hash/
     *
     * Returns an integer hash code for this StringBuilder object.
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        int R=31;
        for(int i = 0; i<arrayList.length(); i++)
        {
            String wantedString = arrayList.get(i);
            for(int j=0;j<wantedString.length();j++)
            {
                hash = (R * hash + wantedString.charAt(i));
            }
        }
        return hash;
    }
}