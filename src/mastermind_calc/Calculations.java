package mastermind_calc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Class used for finding a win in the game.
 */
public class Calculations {

    /**
     * Method used for calculating how many number of colors in<code>guess</code>
     * are the same and how many colors in<code>guess</code> are in the same position as in <code>candidate</code>.
     * @param guess guess
     * @param candidate one of number from possibleNumbers
     * @return new instance of the class <code>Counter</code>
     */
    public static Counter calcPositionAndColor(String guess, String candidate) {

        int positionCounter=0;
        int colorCounter=0;
        for (int i = 0; i < candidate.length(); i++) {
            if (guess.charAt(i) == candidate.charAt(i)) {
                positionCounter++;
            } else if (guess.contains(String.valueOf(candidate.charAt(i)))) {
                colorCounter++;
            }
        }
        return new Counter(positionCounter, colorCounter);
    }

    /**
     * Method used for generate all possible numbers from 0123 to 5433
     * without 6,7,8,9 and there is only one same digit in each number
     * @return <code>Set</code> list of numbers that meet the requirements
     */
    public static Set<String> generatePossibleNumbers() {
        Set<String> set = new HashSet<>();
        for (int i = 123; i < 5433; i++) {
            if(i<1000){
                set.add(String.valueOf("0"+i));
            }
            else set.add(String.valueOf(i));
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            Set<Character> characters = new HashSet<>();
            for (char c : str.toCharArray()) {
                if (characters.contains(c)) {
                    iterator.remove();
                    break;
                }
                if(c=='6'||c=='7'||c=='8'||c=='9'){
                    iterator.remove();
                    break;
                }
                characters.add(c);
            }
        }
        return set;
    }

    /**
     * Method used for calculating how many number of colors in<code>guess</code>
     * are the same and how many colors in<code>guess</code> are in the same position as in one of <code>possibleNumbers</code>
     * (using method calcPositionAndColor()) and removing all numbers from possibleNumbers, which
     * after calculating and comparing with<code>guess</code> don't have the same number of colors which
     * are the same and don't have the same number of colors in the same position as in <code>guessCount</code>.
     * @param guessCount Instance of class <code>Counter</code> with number of colors which are the same and number of colors in the same position from comparing guess in game and key
     * @param guess guess from game
     * @param possibleNumbers numbers that can give the victory
     */
    public static void removeWrongNumbers(Counter guessCount, String guess,
                                          Set<String> possibleNumbers) {

        //possibleNums.removeIf(str -> !calcPositionAndColor(guess, str).equals(guessCount));

        Iterator<String> iterator = possibleNumbers.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (!calcPositionAndColor(guess, str).equals(guessCount)) {
                iterator.remove();
            }
        }
    }

}