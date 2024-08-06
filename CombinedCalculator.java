import java.util.Scanner;



public class CombinedCalculator {
    static Scanner scanner;

    public CombinedCalculator() {
    }

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static int getInt() {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int num;
        if (scanner.hasNextLine()) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                num = convert(scanner.nextLine());
            }
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }

        return num;
    }

    public static int convert(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; --i) {
            char ch = roman.charAt(i);
            int value = romanToInt(ch);
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }

    public static int romanToInt(char ch) {
        switch (ch) {
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'W':
            default:
                return 0;
            case 'I':
                return 1;
            case 'L':
                return 50;
            case 'M':
                return 1000;
            case 'V':
                return 5;
            case 'X':
                return 10;
        }
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }

        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '*':
                result = num1 * num2;
                break;
            case '+':
                result = num1 + num2;
                break;
            case ',':
            case '.':
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                result = num1 / num2;
        }

        return result;
    }

    static {
        scanner = new Scanner(System.in);
    }
}
