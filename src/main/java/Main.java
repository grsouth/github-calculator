import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Welcome to the calculator");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();

            // Exit the program if the user types "exit"
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator exiting. Goodbye!");
                break;
            }

            // Split the input into command and arguments
            String[] tokens = input.trim().split("\\s+");

            if (tokens.length == 0) {
                System.out.println("No command entered.");
                continue;
            }

            String command = tokens[0];

            try {
                switch (command) {
                    case "add":
                        if (tokens.length != 3) {
                            System.out.println("Usage: add num1 num2");
                            continue;
                        }
                        int addNum1 = Integer.parseInt(tokens[1]);
                        int addNum2 = Integer.parseInt(tokens[2]);
                        System.out.println(add(addNum1, addNum2));
                        break;

                    case "subtract":
                        if (tokens.length != 3) {
                            System.out.println("Usage: subtract num1 num2");
                            continue;
                        }
                        int subNum1 = Integer.parseInt(tokens[1]);
                        int subNum2 = Integer.parseInt(tokens[2]);
                        System.out.println(subtract(subNum1, subNum2));
                        break;

                    case "multiply":
                        if (tokens.length != 3) {
                            System.out.println("Usage: multiply num1 num2");
                            continue;
                        }
                        int mulNum1 = Integer.parseInt(tokens[1]);
                        int mulNum2 = Integer.parseInt(tokens[2]);
                        System.out.println(multiply(mulNum1, mulNum2));
                        break;

                    case "divide":
                        if (tokens.length != 3) {
                            System.out.println("Usage: divide num1 num2");
                            continue;
                        }
                        int divNum1 = Integer.parseInt(tokens[1]);
                        int divNum2 = Integer.parseInt(tokens[2]);
                        if (divNum2 == 0) {
                            System.out.println("Cannot divide by zero");
                            continue;
                        }
                        System.out.println(divide(divNum1, divNum2));
                        break;

                    case "fibonacci":
                        if (tokens.length != 2) {
                            System.out.println("Usage: fibonacci n");
                            continue;
                        }
                        int fibNum = Integer.parseInt(tokens[1]);
                        System.out.println(fibonacciNumberFinder(fibNum));
                        break;

                    case "binary":
                        if (tokens.length != 2) {
                            System.out.println("Usage: binary number");
                            continue;
                        }
                        int binNum = Integer.parseInt(tokens[1]);
                        System.out.println(intToBinaryNumber(binNum));
                        break;

                    default:
                        System.out.println("Unknown command");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Addition method
    static int add(int a, int b) {
        return a + b;
    }

    // Subtraction method
    static int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication method
    static int multiply(int a, int b) {
        return a * b;
    }

    // Division method
    static int divide(int a, int b) {
        return a / b;
    }

    // Fibonacci number finder method
    static int fibonacciNumberFinder(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int a = 1; // F(1)
        int b = 1; // F(2)
        int fibNumber = 0;

        for (int i = 3; i <= n; i++) {
            fibNumber = a + b;
            a = b;
            b = fibNumber;
        }

        return fibNumber;
    }

    // Integer to binary string method
    static String intToBinaryNumber(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            int remainder = number % 2;
            binary.insert(0, remainder);
            number = number / 2;
        }

        return binary.toString();
    }
}
