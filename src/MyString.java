import java.util.Objects;

public class MyString {
    String word;

    public MyString(String str) {
        word = str;
    }

    public MyString substring(int bIndex, int endIndex) {
        return new MyString(word.substring(bIndex, endIndex));
    }

    public int length() {
        return word.length();
    }

    public String getString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myStr = (MyString) o;
        return Objects.equals(word, myStr.word);
    }

    @Override
    public int hashCode() {
        //int hashCode = 0;
        //char[] chars = word.toCharArray();
        //for (char c : chars)
        //    hashCode += Objects.hash(c);
        //return hashCode;
        return Objects.hash(word);
    }
}
