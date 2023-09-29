import java.util.HashSet;

public class FindTwoSubstrings {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("Поиск1:Самая большая повторяющаяся подстрока: " + findRepeatSubstring1("NBTKBKFJKNTYDFTKBKFJKNQWERQWERTYDHGIKFVFFKJJJKJGTYHOJQQWERTYDFTKBKFJKNQWERQWERTYDFQWERTKBKFJKNFLLNDJKDBBMTKBKFJKNFLLNDJKDBBTKBKFJKNMBKFTKBKFJKNJKNFLQWERTYDFQWERTKBKFJKNFLLNDJKDBBMQWERTYDFQWEQWERTYDFQWERTKBKFJKNFLLNDJKDBBMRTKBKFJKNFLLNDJKDBBMLNWEBKFJKQWERTYQWERTYDFQWERTKBKFJKNFLLNDJKDBBMDFQWERTKBKFJKNFLLNDJKDBBMNFRTYWENKJEHFOHEJQWERTYDFQWERTKBKFJKNFLLNDJKDBBM"));
        long endTime = System.nanoTime();
        System.out.println("Поиск № 1 занял " + (endTime - startTime) + " наносекунд.");

        startTime = System.nanoTime();
        System.out.println("Поиск2:Самая большая повторяющаяся подстрока: " + findRepeatSubstring2("NBTKBKFJKNTYDFTKBKFJKNQWERQWERTYDHGIKFVFFKJJJKJGTYHOJQQWERTYDFTKBKFJKNQWERQWERTYDFQWERTKBKFJKNFLLNDJKDBBMTKBKFJKNFLLNDJKDBBTKBKFJKNMBKFTKBKFJKNJKNFLQWERTYDFQWERTKBKFJKNFLLNDJKDBBMQWERTYDFQWEQWERTYDFQWERTKBKFJKNFLLNDJKDBBMRTKBKFJKNFLLNDJKDBBMLNWEBKFJKQWERTYQWERTYDFQWERTKBKFJKNFLLNDJKDBBMDFQWERTKBKFJKNFLLNDJKDBBMNFRTYWENKJEHFOHEJQWERTYDFQWERTKBKFJKNFLLNDJKDBBM"));
        endTime = System.nanoTime();
        System.out.println("Поиск № 2 занял " + (endTime - startTime) + " наносекунд.");

        startTime = System.nanoTime();
        System.out.println("Поиск3:Самая большая повторяющаяся подстрока: " + findRepeatSubstring3("NBTKBKFJKNTYDFTKBKFJKNQWERQWERTYDHGIKFVFFKJJJKJGTYHOJQQWERTYDFTKBKFJKNQWERQWERTYDFQWERTKBKFJKNFLLNDJKDBBMTKBKFJKNFLLNDJKDBBTKBKFJKNMBKFTKBKFJKNJKNFLQWERTYDFQWERTKBKFJKNFLLNDJKDBBMQWERTYDFQWEQWERTYDFQWERTKBKFJKNFLLNDJKDBBMRTKBKFJKNFLLNDJKDBBMLNWEBKFJKQWERTYQWERTYDFQWERTKBKFJKNFLLNDJKDBBMDFQWERTKBKFJKNFLLNDJKDBBMNFRTYWENKJEHFOHEJQWERTYDFQWERTKBKFJKNFLLNDJKDBBM"));
        endTime = System.nanoTime();
        System.out.println("Поиск № 3 занял " + (endTime - startTime) + " наносекунд.");
    }

    public static String findRepeatSubstring1(String mainString) {
        /* Устанавливаем максимально возможную длину проверяемых подстрок и постепенно уменьшаем ее */
        for (int curLength = mainString.length() - 1; curLength > 0; curLength--) {
                /* Формируем индекс для подстроки, которая проверяется. При движении по основному
                слову индекс подстроки сдвигается вправо, а индекс конца формируется так, чтобы
                подстрока сохраняла нужную длину*/
            for (int beginIndex = 0; beginIndex + curLength <= mainString.length(); beginIndex++) {
                /* Получаем главную подстроку для проверки нужной длины*/
                String str1 = mainString.substring(beginIndex, beginIndex + curLength);
                /* Формируем индекс для текущей подстроки. Далее будем сдвигать индекс вправо,
                чтобы не терять длину, и каждый раз проверяем главную*/
                for (int beginIndex1 = beginIndex + 1; beginIndex1 + curLength - 1 < mainString.length(); beginIndex1++) {
                    /* Получаем текущую подстроку нужной длины*/
                    String str2 = mainString.substring(beginIndex1, beginIndex1 + curLength);
                    if (str1.equals(str2)) {
                        return str1;
                    }
                }
            }
        }
        return null;
    }

    public static String findRepeatSubstring2(String mainString) {
        /* Устанавливаем максимально возможную длину проверяемых подстрок и постепенно уменьшаем ее */
        for (int curLength = mainString.length() - 1; curLength > 0; curLength--) {
            HashSet<String> substr = new HashSet<>();
            /* Формируем индекс для текущей подстроки. При движении по основному
                слову индекс подстроки сдвигается вправо, а индекс конца формируется так, чтобы
                подстрока сохраняла нужную длину*/
            for (int beginIndex = 0; beginIndex + curLength <= mainString.length(); beginIndex++) {
                /* Получаем подстроку нужной длины и кладем ее в HashSet
                Если такая уже есть, значит нашли повторение */
                String str = mainString.substring(beginIndex, beginIndex + curLength);
                if (substr.contains(str)) return str;
                else substr.add(str);
            }
        }
        return null;
    }

    public static String findRepeatSubstring3(String mainString) {
        MyString myString = new MyString(mainString);
        /* Устанавливаем максимально возможную длину проверяемых подстрок и постепенно уменьшаем ее */
        for (int curLength = myString.length() - 1; curLength > 0; curLength--) {
            HashSet<MyString> substr = new HashSet<>();
            /* Формируем индекс для текущей подстроки. При движении по основному
                слову индекс подстроки сдвигается вправо, а индекс конца формируется так, чтобы
                подстрока сохраняла нужную длину*/
            for (int beginIndex = 0; beginIndex + curLength <= myString.length(); beginIndex++) {
                /* Получаем подстроку нужной длины и кладем ее в HashSet
                Если такая уже есть, значит нашли повторение */
                MyString str = myString.substring(beginIndex, beginIndex + curLength);
                if (substr.contains(str)) return str.getString();
                else substr.add(str);
            }
        }
        return null;
    }
}