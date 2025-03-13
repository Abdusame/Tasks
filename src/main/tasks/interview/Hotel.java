package tasks.interview;

import java.util.*;

public class Hotel {
    /**
     * Классический отель. Выселение до обеда, заселение после обеда.
     * Кол-во посетителей считается вечером.
     * Найти дни с наибольшим кол-вом посетителей.
     * */
    public static void main(String[] args) {
        List<Pair> intervals = new ArrayList<>();
        intervals.add(new Pair(1,5));
        intervals.add(new Pair(2,6));
        intervals.add(new Pair(3,7));
        intervals.add(new Pair(7,9));

        System.out.println("Дни аншлага: " + countGuests(intervals));
    }

    public static List<Integer> countGuests(List<Pair> intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i + 1, 0);
        }
        int max = 0;
        int maxGuestsDay = 0;
        int countOfGuestsInThisDay;
        int incrementedValue;
        int decrementedValue;
        for (Pair p : intervals) {
            countOfGuestsInThisDay = map.get(p.start);
            incrementedValue = countOfGuestsInThisDay + 1;
            map.put(p.start, incrementedValue);
            //setMax(max, maxGuestsDay, incrementedValue, p.start);
            if (incrementedValue > max) {
                max = incrementedValue;
                maxGuestsDay = p.start;
            }


            for (int j = p.start + 1; j < p.end; j++) {
                countOfGuestsInThisDay = map.get(j);
                incrementedValue = countOfGuestsInThisDay + 1;
                map.put(j, incrementedValue);
                //setMax(max, maxGuestsDay, incrementedValue, j);
                if (incrementedValue > max) {
                    max = incrementedValue;
                    maxGuestsDay = j;
                }
            }

            countOfGuestsInThisDay = map.get(p.end);
            if (countOfGuestsInThisDay > 0) {
                decrementedValue = countOfGuestsInThisDay - 1;
            } else {
                decrementedValue = 0;
            }
            map.put(p.end, decrementedValue);
            //setMax(max, maxGuestsDay, decrementedValue, p.end);
            if (incrementedValue > max) {
                max = incrementedValue;
                maxGuestsDay = p.end;
            }
        }

        System.out.println(map);
        System.out.println("максимальное кол-во гостей = " + max);

        List<Integer> maxDays = new ArrayList<>();

        for (int i = maxGuestsDay; i < map.size(); i++) {
            if (map.get(i).equals(max)) {
                maxDays.add(i);
            } else if (map.get(i) < max) {
                break;
            }
        }

        return maxDays;
    }

    private void setMax(Integer max, Integer maxGuestsDay, Integer currentValue,  Integer currentDay) {
        if (currentValue > max) {
            max = currentValue;
            maxGuestsDay = currentDay;
        }
    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
