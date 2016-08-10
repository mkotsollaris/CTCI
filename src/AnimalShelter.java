/**
 * Created by Menelaos Kotsollaris on 3/24/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description:
 */
public class AnimalShelter
{
    private Queue<Animal> animalQueue;

    public AnimalShelter()
    {
        animalQueue = new Queue<>();
    }

    public void enqueue(Animal animal)
    {
        animalQueue.push(animal);
    }

    public boolean dequeue(AnimalType animalType)
    {
        ListNode<Animal> animalNode = animalQueue.getTail();
        do
        {
            if(animalNode == null)
            {
                return false;
            }
            if(animalNode.getElement().getAnimalType() == animalType)
            {
                animalQueue.remove(animalNode.getElement());
                return true;
            }
            animalNode = animalNode.getPrevious();
            System.out.println(animalNode.getElement().getAnimalType());
        }
        while (true);
    }

    public void dequeueAny()
    {
        animalQueue.pop();
    }

    public void flush()
    {
        System.out.println("Tail: "+animalQueue.getTail().getElement().getAnimalType());
        System.out.println("Head: "+animalQueue.getHead().getElement().getAnimalType());
        //System.out.println(animalQueue.getLength());

        for(int i = 0; i < animalQueue.getLength(); i++)
        {
            System.out.println(animalQueue.get(i).getElement().getAnimalType());
        }
        //animalQueue.get(animalQueue.length-1).getElement().getAnimalType();
        //System.out.println(animalQueue.getTail().getElement().getAnimalType());
        //animalQueue.flush();
    }
}
