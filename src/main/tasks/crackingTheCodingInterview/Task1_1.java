package tasks.crackingTheCodingInterview;

import java.util.*;

public class Task1_1 {
    /**
     * Реализуйте алгоритм, определяющий все ли символы в строке встречаются только один раз.
     * А если при этом запрещено использование дополнительных структур данных.
     * */
    public static void main(String[] args) {
        System.out.println(solution("poeirbpoie"));
    }

    public static boolean solution(String row) {
        boolean result = true;
        Map<String, Integer> map = new HashMap<>();
        String[] letters = row.split("");
        Set<String> keys = map.keySet();
        for (String letter : letters) {
            if (keys.contains(letter)) {
                int letterCount = map.get(letter);
                map.put(letter, letterCount + 1);
                result = false;
            } else {
                map.put(letter, 1);
            }
        }
        map.forEach((k,v) -> System.out.println(k + ": " + v));
        return result;
    }
}
