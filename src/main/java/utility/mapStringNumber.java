package utility;

import java.util.HashMap;

public class mapStringNumber {
    public static int convertStringtoNumber (String s){
        // Classroom A
        char cur = s.charAt(10);
        return cur - 'A';
    }

    public static String generateNextPermutation(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }
}
