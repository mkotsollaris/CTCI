import java.util.Date;

/**
 * Created by Menelaos Kotsollaris on 3/24/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description: As described in CTCI p. 99
 */
public class Animal
{
    private AnimalType animalType;
    private Date date;

    public Animal(AnimalType animalType)
    {
        this.animalType = animalType;
    }

    public Date getDate()
    {
        return date;
    }

    public AnimalType getAnimalType()
    {
        return animalType;
    }
}
