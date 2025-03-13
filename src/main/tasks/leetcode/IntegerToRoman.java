package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1996));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            if (entry.getKey() == num) {
                return String.valueOf(entry.getValue());
            }
        }
        StringBuilder roman = new StringBuilder();
        iteration(roman, map, num);
        return roman.toString();
    }

    public static StringBuilder iteration(StringBuilder roman, Map<Integer, String> map, Integer num) {
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            if (entry.getKey().equals(num)) {
                num = 0;
                roman.append(entry.getValue());
                return iteration(roman, map, num);
            }
        }
        if (num > 1000 && num < 4000) {
            greatThan1000LessThan4000(roman, map, num);
        } else if (num > 500 && num < 1000) {
            greatThan500LessThan1000(roman, map, num);
        } else if (num > 100 && num < 500) {
            greatThan100LessThan500(roman, map, num);
        } else if (num > 50 && num < 100) {
            greatThan50LessThan100(roman, map, num);
        } else if (num > 10 && num < 50) {
            greatThan10LessThan50(roman, map, num);
        } else if (num > 0 && num < 10) {
            greatThan0LessThan10(roman, map, num);
        }

        /*} else if (num > 5 && num < 10) {
            greatThan5LessThan10(roman, map, num);
        } else if (num > 1 && num < 5) {
            greatThan1LessThan5(roman, map, num);
        }*/

        return roman;
    }

    private static StringBuilder greatThan1000LessThan4000(StringBuilder roman, Map<Integer, String> map, Integer num) {
        while (num > 1000) {
            roman.append(map.get(1000));
            num = num - 1000;
        }
        iteration(roman, map, num);
        return roman;
    }

    private static StringBuilder greatThan500LessThan1000(StringBuilder roman, Map<Integer, String> map, Integer num) {
        if (num >= 900) {
            roman.append(map.get(100)).append(map.get(1000));
            num = num - 900;
            iteration(roman, map, num);
        } else {
            while (num > 500) {
                roman.append(map.get(500));
                num = num - 500;
            }
            iteration(roman, map, num);
        }
        return roman;
    }

    private static StringBuilder greatThan100LessThan500(StringBuilder roman, Map<Integer, String> map, Integer num) {
        if (num >= 400) {
            roman.append(map.get(100)).append(map.get(500));
            num = num - 400;
            iteration(roman, map, num);
        } else {
            while (num > 100) {
                roman.append(map.get(100));
                num = num - 100;
            }
            iteration(roman, map, num);
        }
        return roman;
    }

    private static StringBuilder greatThan50LessThan100(StringBuilder roman, Map<Integer, String> map, Integer num) {
        if (num >= 90) {
            roman.append(map.get(10)).append(map.get(100));
            num = num - 90;
            iteration(roman, map, num);
        } else {
            while (num > 50) {
                roman.append(map.get(50));
                num = num - 50;
            }
            iteration(roman, map, num);
        }
        return roman;
    }

    private static StringBuilder greatThan10LessThan50(StringBuilder roman, Map<Integer, String> map, Integer num) {
        if (num >= 40) {
            roman.append(map.get(10)).append(map.get(50));
            num = num - 40;
            iteration(roman, map, num);
        } else {
            while (num > 10) {
                roman.append(map.get(10));
                num = num - 10;
            }
            iteration(roman, map, num);
        }
        return roman;
    }

    private static StringBuilder greatThan0LessThan10(StringBuilder roman, Map<Integer, String> map, Integer num) {
        switch (num) {
            case 9:
                roman.append("IX");
                break;
            case 8:
                roman.append("VIII");
                break;
            case 7:
                roman.append("VII");
                break;
            case 6:
                roman.append("VI");
                break;
            case 5:
                roman.append("V");
                break;
            case 4:
                roman.append("IV");
                break;
            case 3:
                roman.append("III");
                break;
            case 2:
                roman.append("II");
                break;
            case 1:
                roman.append("I");
                break;
        }
        num = 0;
        return roman;
    }

    private static StringBuilder greatThan5LessThan10Old(StringBuilder roman, Map<Integer, String> map, Integer num) {
        if (num == 9) {
            roman.append(map.get(1)).append(map.get(10));
        } else {
            roman.append(map.get(5));
            while (num > 5) {
                roman.append(map.get(1));
                num--;
            }
        }
        return roman;
    }

    public static StringBuilder greatThan1LessThan5Old(StringBuilder roman, Map<Integer, String> map, Integer num) {
        if (num == 4) {
            roman.append(map.get(1)).append(map.get(5));
        } else {
            while (num > 0) {
                roman.append(map.get(1));
                num--;
            }
        }
        return roman;
    }
}
