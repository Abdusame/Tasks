package tasks.yandex_championship_2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Qwerty {
    public static void main(String[] args) throws IOException {
        String str = new String(Files.readAllBytes(Paths.get("input.txt").toAbsolutePath()));
        int result = solution(str);
        Files.write(Paths.get("output.txt").toAbsolutePath(),
                Integer.valueOf(result).toString().getBytes());
    }

    private static int solution(String str) {
        String[] symbols = str.split("");
        int posl = 0; // счетчик подряд повторяющихся прописных букв.
        int mainCount = 0;
        if (str.length() == 0) {
            return 0;
        }
        if (symbols.length == 1) {
            if (symbols[0].matches("[A-Z]")) {
                return 2;
            } else {
                return 1;
            }
        }
        for (int i = 0; i < symbols.length; i++) {
            mainCount++;
            if (symbols[i].matches("[A-Z]")) {
                posl++;
                if (i == symbols.length-1) {
                    if (posl >= 3) {
                        mainCount = mainCount + 2;
                    } else {
                        mainCount = mainCount + posl;
                    }
                }
            } else if (symbols[i].matches("[ ]")) {
                if (i == symbols.length-1 && posl > 0) {
                    mainCount = mainCount + 2;
                }
            } else if (symbols[i].matches("[a-z]")) {
                // HIHkk
                if (posl > 0) {
                    if (posl < 4) {
                        mainCount = mainCount + posl;
                    } else { // posl > 4
                        mainCount = mainCount + 4;
                    }
                }
                posl = 0;
            }
        }
        System.out.println(mainCount);
        return mainCount;
    }
}
