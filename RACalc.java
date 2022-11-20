import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class RACalc {
    static int num1, num2;
    static char op;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--Калькулятор римских и арбских чисел--");
        System.out.println("Введите выражение:");
        String exp = sc.nextLine();
        char[] arr = exp.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+') {
                op = '+';
            }
            if (arr[i] == '-') {
                op = '-';
            }
            if (arr[i] == '*') {
                op = '*';
            }
            if (arr[i] == '/') {
                op = '/';
            }
        }
        try {
            String str = String.valueOf(arr);
            String[] arrEx = str.split("[+-/*]");
            if(arrEx.length != 2){
                arrEx[0] = "-1";
            }
            String endNum1 = arrEx[0].trim();
            String endNum2 = arrEx[1].trim();
            num1 = romanToArabian(endNum1);
            num2 = romanToArabian(endNum2);
            if (num1 == -11 && num2 == -11) {
                result = 0;
            } else {
                result = calc(num1, num2, op);
                System.out.println("Результат: " + arabianToRoman(result));
            }
            try {
                num1 = Integer.parseInt(endNum1);
                num2 = Integer.parseInt(endNum2);
                result = calc(num1, num2, op);
                System.out.println("Результат: " + result);
            } catch (NumberFormatException e) {
                System.out.println("");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неверный ввод");
        }
    }


    public static String arabianToRoman(int arabianNum) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
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
        return -11;
    }

    public static int calc(int num1, int num2, char op){
        int result = 0;
        if(num1 < 0 || num2 < 0 || num1 > 10 || num2 > 10){
            System.out.println("Неверыный ввод");
            result = Integer.parseInt(null);
        }else{
            switch (op){
                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    try{
                        result = num1 / num2;
                    }catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Деленеие на это число невозможно");
                        break;
                    }
                    break;
            }
        }return result;
    }
}
