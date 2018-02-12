/**
 * Created by Menelaos Kotsollaris on 2017-07-02.
 *
 * Class Explanation: TODO
 *
 * Given a string s, find length of the longest prefix which is also suffix. The
 * prefix and suffix should not overlap.
 *
 *
 * Input : aabcdaabc Output : 4 The string "aabc" is the longest prefix which is
 * also suffix.
 *
 * Input : abcab Output : 2
 *
 * Input : aaaa Output : 2
 */
public class LongestPrefix
{
    public static void main(String[] args)
    {
        longestPrefixAndSuffix();
    }

    private static void longestPrefixAndSuffix()
    {
        String input = "aabcdaabc";
        int counterAnswer = 0;
        int startingPos = 0;
        int
                endingPos =
                (input.length() % 2 == 0) ? input.length() / 2 :
                        (input.length() / 2) + 1;
        System.out.println("endingPos: " + endingPos);
        while(true)
        {
            if(input.charAt(startingPos) == input.charAt(endingPos))
            {
                System.out.println("in");
                counterAnswer++;
            }
            else
            {
                break;
            }
            startingPos++;
            endingPos++;
            if(endingPos > input.length() - 1) break;
        }
        System.out.println(counterAnswer);
    }
}
