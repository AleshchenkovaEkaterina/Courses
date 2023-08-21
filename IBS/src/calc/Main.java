package calc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        System.out.println("Enter numbers!");
        try {
            while (!"q".equals(userInput)) {
                int firstNumber = scanner.nextInt();
                int secondNumber = scanner.nextInt();
                userInput = scanner.nextLine();
                double result;
                switch (userInput.trim()) {
                    case "+":
                        result = plus(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = minus(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = ymn(firstNumber, secondNumber);
                        break;
                    case "/":
                        result = del(firstNumber, secondNumber);
                        if (secondNumber == 0) {
                            continue;
                        }
                        break;
                    case "!":
                        result = fact(firstNumber);
                        break;
                    default:
                        result = 0;
                        break;
                }
                System.out.println(result);
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wrong input data!");
        }
    }
    private static int plus(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }
    private static int minus(int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }
    private static int ymn(int numberOne, int numberTwo){
        return numberOne * numberTwo;
    }
    private static int del(int numberOne, int numberTwo){
        return numberOne / numberTwo;
    }
    private static int fact(int numberOne) {
        int res = 1;
        for (int i = 1; i <= numberOne; i++) {
            res *= i;
        }
        return res;
    }
}