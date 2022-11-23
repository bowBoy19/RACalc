import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--Калькулятор римских и арбских чисел--");
        System.out.println("Введите выражение:");
        String expression = sc.nextLine();
        if (calc(expression) == null) {
            System.out.println("Неверный ввод");
        } else {
            System.out.println("Результат: " + calc(expression));
        }
    }

    public static String arabianToRoman(int arabianNum) {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String romanNum =  roman[arabianNum];
        return romanNum;
    }

    public static int romanToArabian(String romanNum){
        switch (romanNum) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        return -1;
    }

    public static String calc(String expression){
        String result = "";
        char op = ' ';
        int num1, num2;
        String[] arrEx = expression.split(" ");
        if (arrEx.length != 3){
            result = null;
        }else{
            if (arrEx[1].equals("+")) {
                op = '+';
            }
            if (arrEx[1].equals("-")) {
                op = '-';
            }
            if (arrEx[1].equals("*")) {
                op = '*';
            }
            if (arrEx[1].equals("/")) {
                op = '/';
            }
        }
        try {
            num1 = romanToArabian(arrEx[0]);
            num2 = romanToArabian(arrEx[2]);
            int checkNum1 = num1;
            int checkNum2 = num2;
            if (checkNum1 == -1 & checkNum2 == -1) {
                num1 = Integer.parseInt(arrEx[0]);
                num2 = Integer.parseInt(arrEx[2]);
                if (num1 < 0 || num2 < 0 || num1 > 10 || num2 > 10){
                    op = ' ';
                }
            }
            switch (op) {
                case '+':
                    result = String.valueOf(num1 + num2);
                    break;
                case '-':
                    result = String.valueOf(num1 - num2);
                    break;
                case '*':
                    result = String.valueOf(num1 * num2);
                    break;
                case '/':
                    try {
                        result = String.valueOf(num1 / num2);
                    } catch (ArithmeticException e) {
                        result = null;
                        break;
                    }
                    break;
                default:
                    result = null;
            }

            if (num1 * num2 < 0){
                result = null;
            }
            if (checkNum1 != -1 & checkNum2 != -1) {
                result = arabianToRoman(Integer.parseInt(result));
                if (result == "0"){
                    result = null;
                }
            }
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException e ){
            result = null;
        }
        return result;
    }
}