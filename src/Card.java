/**
 * Created by Menelaos Kotsollaris on 2017-01-08.
 *
 * Class Explanation: TODO
 */
class Card
{
    private final String name;
    private final int number;

    private Card()
    {
        throw new AssertionError();
    }

    private Card(int number)
    {
        switch(number)
        {
            case 0:
                this.name = CardName.ACE.name;
                break;
            case 1:
                this.name = CardName.DOUCE.name;
                break;
            case 2:
                this.name = CardName.THREE.name;
                break;
            case 3:
                this.name = CardName.FOUR.name;
                break;
            case 4:
                this.name = CardName.ACE.name;
                break;
            case 5:
                this.name = CardName.ACE.name;
                break;
            case 6:
                this.name = CardName.ACE.name;
                break;
            case 7:
                this.name = CardName.ACE.name;
                break;
            case 8:
                this.name = CardName.ACE.name;
                break;
            case 9:
                this.name = CardName.ACE.name;
                break;
            case 10:
                this.name = CardName.ACE.name;
                break;
            case 11:
                this.name = CardName.ACE.name;
                break;
            case 12:
                this.name = CardName.ACE.name;
                break;
            case 13:
                this.name = CardName.ACE.name;
                break;
            default:
                throw new IllegalArgumentException();
        }
        this.number = number;

    }

    public static Card newCard(int number)
    {
        return new Card(number);
    }

    private enum CardName
    {
        ACE("Ace"),
        DOUCE("Douce"),
        THREE("Three"),
        FOUR("Four"),
        FIVE("Five"),
        SIX("Six"),
        SEVEN("SEVEN"),
        EIGHT("EIGHT"),
        NINE("NINE"),
        TEN("TEN"),
        JACK("JACK"),
        QUEEN("QUEEN"),
        KING("KING"),
        Joker("JOKER");

        private final String name;

        CardName(String name)
        {
            this.name = name;
        }
    }

    enum Color
    {
        BLACK,
        RED,
        BLUE,
        GREEN
    }

}
