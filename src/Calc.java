import java.util.Scanner;

class Calculator{

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение двух  чисел: ");
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
    }

    public static String calc(String input) throws Exception {
        int a;
        int b;
        String oper;
        String result;
        boolean isRoman;
        String[] numbers = input.split("[+\\-*/]");
        if (numbers.length <2||numbers.length>2) throw new Exception("должно быть 2 числа");
        oper = findOperation(input);

        if (Roman.numberIsRoman(numbers[0]) && Roman.numberIsRoman(numbers[1])) {
            a = Roman.convertToArabiс(numbers[0]);
            b = Roman.convertToArabiс(numbers[1]);
            isRoman = true;
        }

        else if (!Roman.numberIsRoman(numbers[0]) && !Roman.numberIsRoman(numbers[1])) {
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
            isRoman = false;
        }

        else {
            throw new Exception("error: Числа должны быть в одном формате");
        }
        if (a > 10 || b > 10) {
            throw new Exception("error: Числа должны быть от 1 до 10");
        }
        int arabian = calc(a, b, oper);
        if (isRoman) {

            if (arabian <= 0) {
                throw new Exception("error: Римские числа должно быть положительные");
            }
            result = Roman.convertToRoman(arabian);
        } else {

            result = String.valueOf(arabian);
        }
        return result;
    }

    static String findOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

}

class Roman {
    static String[] romanArray = new String[]{ "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean numberIsRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabiс(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}