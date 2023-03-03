package leetcode;

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumberHigherOrLower /*extends GuessGame*/ {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int index;
        int result;
        while (true) {
            if (guess(start) == 0) {
                index = start;
                break;
            }
            if (guess(end) == 0) {
                index = end;
                break;
            }
            index = (end - start)/2 + start;
            result = guess(index);
            if (result == -1) {
                end = index;
            } else if (result == 1) {
                start = index;
            } else if (result == 0) {
                break;
            }
        }
        return index;
    }

    private int guess(int num) {
        return 0;
    }
}