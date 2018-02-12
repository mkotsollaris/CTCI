/**
 * Created by Menelaos Kotsollaris on 2017-01-08.
 *
 * Class Explanation: TODO
 */
public class BJDeck extends Deck
{
    private final int cardSetNumber;

    private BJDeck()
    {
        throw new AssertionError();
    }

    private BJDeck(int setNumber)
    {
        this.cardSetNumber = setNumber;
        myCardSet = new CardSet[setNumber];
        for(int i = 0; i < setNumber; i++)
        {
            myCardSet[i] = BJCardSet.newBJCardSet();
        }
    }


    @Override Deck newDeck(int setNumber)
    {
        return new BJDeck(setNumber);
    }

    static BJDeck newBJDeck(int cardSetNumber)
    {
        return new BJDeck(cardSetNumber);
    }

}
