/**
 * Created by Menelaos Kotsollaris on 2017-01-08.
 *
 * Class Explanation: TODO
 */
abstract class Deck
{
    protected CardSet[] myCardSet;

    abstract Deck newDeck(int setNumber);

    @Override public String toString()
    {
        return "Deck";
    }
}
