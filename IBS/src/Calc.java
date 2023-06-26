public class Calc {

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
        for (int i = 1; i < numberOne; i++) {
            res *= i;
        }
        return res;
    }
    switch (userInput){
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
            break;
        case "!":
            result = fact(firstNumber);
            break;
        default:
            result = 0;
            break;

    }    case "/":
            if(secondNumber == 0){
        continue;
    }
    result = del(firstNumber, secondNumber);
break;
}
