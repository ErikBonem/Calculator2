import java.util.Scanner;

public class Calculator {
    static String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    static Scanner sc = new Scanner(System.in);
    static String example1 = sc.nextLine();
    public static void main(String[] args) throws CalculExeption {
        String[] array = example1.split(" ");
        char operator = array[1].charAt(0);

        int t = typeOfNumb();
        switch (t) {
            case (1):   //римские цифры
                int count1 = 0;
                int count2 = 2;
                for (int k = 0; k < rome.length; k++) {
                    if (rome[k].equals(array[0])) {
                        count1 = k + 1;
                    }
                    if (rome[k].equals(array[2])) {
                        count2 = k + 1;
                    }
                }
                if (count1 <= 10 && count1 >= 1 && count2 <= 10 && count2 >= 1 ){
                if (operator == '-' &&  (count1 <= count2))
                    throw new CalculExeption("В римских цифрах не бывает неположительных значений");
                else if (operator == '+')
                    System.out.println(rome[count1 + count2 - 1]);
                else if (operator == '-')
                    System.out.println(rome[count1 - count2 - 1]);
                else if (operator == '/')
                    System.out.println(rome[count1 / count2 - 1]);
                else if (operator == '*')
                    System.out.println(rome[count1 * count2 - 1]);
                }
                else
                    throw new CalculExeption("Недопустимые значения");
                break;

            case (2):   //арабские цифры
                int num1 = Integer.parseInt(array[0]);
                int num2 = Integer.parseInt(array[2]);
                if (num1 <= 10 && num1 >= 1 && num2 <= 10 && num2 >= 1 ){
                    switch (operator) {
                        case ('+') -> System.out.println(num1 + num2);
                        case ('-') -> System.out.println(num1 - num2);
                        case ('/') -> System.out.println(num1 / num2);
                        case ('*') -> System.out.println(num1 * num2);
                    }
                }
                else
                    throw new CalculExeption("Недопустимые значения");
                break;

            case (3):   //смесь типов цифр либо не соответсвует шаблону
                throw new CalculExeption("Ошибка при вводе данных");



        }
    }

    static int typeOfNumb() {   //метод для определения типа цифр
        int a;
        if (example1.matches("\\D\\D?\\D?\\D?\\s[+,\\-,*,/]\\s\\D\\D?\\D?\\D?"))    //римские
        {
            a = 1;
        }
        else if (example1.matches("(\\d\\d?\\s[+,\\-,*,/]\\s\\d\\d?)"))     //арабские
        {
            a = 2;
        }
        else {                                                                    //ошибка при вводе
            a = 3;
        }
        return a;
    }
}