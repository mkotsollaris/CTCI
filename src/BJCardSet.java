/**
 * Created by Menelaos Kotsollaris on 2017-01-08.
 *
 * Class Explanation: TODO
 */
class BJCardSet extends CardSet
{
    @Override protected CardSet newCardSet()
    {
        return newBJCardSet();
    }

    private BJCardSet()
    {
        myCardSet = new Card[13];
        for(int i = 1; i <= 13; i++)
        {
            myCardSet[i - 1] = Card.newCard(i);
        }
    }

    static BJCardSet newBJCardSet()
    {
        return new BJCardSet();
    }

}
