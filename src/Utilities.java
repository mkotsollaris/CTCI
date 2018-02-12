/**
 * Created by Menelaos Kotsollaris on 2/26/2016. Contact: mkotsollari@gmail.com
 * All rights Reserved. <p> Class Description:
 */

import org.jetbrains.annotations.Contract;

import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities
{
    public static int randInt(int min, int max)
    {
        // nextInt is normally exclusive of the top value,
        // so addToTail 1 to make it inclusive
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Checks if all the characters of the string are unique <p> Complexity:
     * O(1), if we don't count the string length, else O(N)
     */
    public static boolean isUnique(String str)
    {
        Character[] cArray = new Character[str.length()];
        HashTable<Character> hashTable = new HashTable<>(Character.class, 10);
        for(int i = 0; i < str.length(); i++)
        {
            Character wantedCharacter = str.charAt(i);
            if(i > 1)
            {
                if(hashTable.exists(wantedCharacter))
                {
                    return false;
                }
            }
            hashTable.add(wantedCharacter);
        }
        return true;
    }

    @Contract(pure = true) public static int getMax(int a, int b)
    {
        if(a > b)
        {
            return a;
        }
        return b;
    }

    /**
     * Complexity: O(N) (if the collision rate is normal; depends on the
     * HashFunction and the length of the Hashtable) <p> TODO TEST if logic is
     * right for funding Permutations- SOS question
     */
    public static boolean isPermutation(String str1, String str2)
    {

        HashTable<Character> hashTable = new HashTable<>(Character.class, 10);
        //inserting elements into the hashtable
        for(int i = 0; i < str1.length(); i++)
        {
            Character wantedChar = str1.charAt(i);
            hashTable.add(wantedChar);
        }
        for(int i = 0; i < str2.length(); i++)
        {
            Character wantedChar = str2.charAt(i);
            hashTable.add(wantedChar);
        }
        for(int i = 0; i < hashTable.length(); i++)
        {
            ArrayList<Character> arr = hashTable.getInnerArrayList(i);
            int arrLength = arr.length();
            if(arrLength % 2 != 0)
            {
                return false;
            }
            for(int k = 0; k < arrLength; k++)
            {
                Character c = arr.get(k);
                int containCounter = arr.containCount(c);
                if(containCounter < 2 && containCounter % 2 == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Palindrome is the string that reads the same backwards
     *
     * e.g.: LongestPrefix but tuba
     *
     * More examples: http://www.palindromelist.net
     */
    public static boolean isPalindrome(String str)
    {
        char[]
                specialCharactersArray =
                new char[]{' ', ',', '.', '!', '?', '\\', '/', '\'',
                        '\"'}; //can be appended..
        int counter1 = 0;
        int counter2 = 0;
        int strLength = str.length();
        for(int i = 0; i < strLength / 2; i++)
        {
            char leftChar = Character.toLowerCase(str.charAt(i));
            char
                    rightChar =
                    Character.toLowerCase(str.charAt(strLength - i - 1));
            //FIXME needs a While until it finds proper character.. (!= specialCharactersArray) do..while
            if(Utilities.contains(leftChar, specialCharactersArray))
            {
                System.out.println("left contains at: " + i);
                counter1++;
            }
            if((Utilities.contains(rightChar, specialCharactersArray)))
            {
                System.out.println("rightChar contains at: " + i);
                counter2++;
            }
            leftChar = Character.toLowerCase(str.charAt(i + counter1));
            rightChar =
                    Character.toLowerCase(
                            str.charAt(strLength - i - 1 + counter2));
            if(leftChar != rightChar)
            {
                System.out.println(leftChar + ", not true vs: " + str.charAt(
                        strLength - i - counter2 - 1));
                return false;
            }
        }
        return true;
    }

    /**
     * Returns:
     *
     * @param charArray: char Array
     * @param character: character
     *
     *                   charArray contains character.
     */
    @Contract(pure = true) public static boolean contains(char character,
                                                          char[] charArray)
    {
        boolean contains = false;
        for(char c : charArray)
        {
            if(c == character)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This is a declaration of the generic type in the method signature. For
     * more: http://stackoverflow.com/questions/4209080/using-generic-types-in-a-static-context
     *
     * TODO
     */
    public static <T> boolean binarySearch(Comparable<T>[] array,
                                           T element)
    {
        if(array.length < 1) return false;
        int middlePosition = array.length / 2;
        if(array[middlePosition].compareTo(element) == 0) return true;
        else if(array[middlePosition].compareTo(element) == -1)
        {

        }
        else
        {

        }
        return false;
    }
}
