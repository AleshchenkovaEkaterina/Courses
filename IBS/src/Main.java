import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!"q".equals(userInput)) {
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            userInput = scanner.nextLine();
            double result;
            switch (userInput){
                case "+":
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                case "!":
                    break;
                default:
                    break;
            }
        }
        System.out.println(result);

    }
}