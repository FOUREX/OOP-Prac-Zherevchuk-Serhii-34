package Task_2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * "Очищає" консоль
     */
    private static void clear() {
        for (int i = 0; i < 50; i++) { System.out.println(); }
    }

    /**
     * Зупиняє консоль
     */
    public static void pause() {
        System.out.println("\nНатисніть Enter для продовження");
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean serialized = false;
        Calculator calculator = null;

        while (true)
        {
            clear();

            System.out.println("Список дій:");
            System.out.println("1. Ввести дані");
            System.out.println("2. Вивести результат");
            System.out.println("3. Серіалізувати клас");
            System.out.println("4. Десеріалізувати клас");
            System.out.println("5. Вийти");
            System.out.print("\nВиберіть дію: ");

            int userInput = scanner.nextInt();

            if (userInput != 5) {
                clear();
            }

            switch (userInput) {
                case 1 -> {
                    System.out.print("Довжина сторони: ");
                    calculator = new Calculator(scanner.nextDouble());
                    calculator.calculateSum();
                }
                case 2 -> {
                    if (calculator == null) {
                        System.out.println("Дані не введено, введіть дані");
                        break;
                    }

                    System.out.printf("Сума площ трикутника та прямокутника: %f\n", calculator.getResult());
                }
                case 3 -> {
                    if (calculator == null) {
                        System.out.println("Дані не введено, введіть дані");
                        break;
                    }

                    serialized = true;
                    calculator.serialize("temp/Task_2/calculator.bin");
                    System.out.println("Клас серіалізований");
                }
                case 4 -> {
                    if (calculator == null) {
                        System.out.println("Дані не введено, введіть дані");
                        break;
                    }

                    if (!serialized) {
                        System.out.println("Серіалізуйте клас");
                        break;
                    }

                    calculator = Calculator.deserialize("temp/Task_2/calculator.bin");
                    calculator.calculateSum();
                    System.out.println("Клас десеріалізований");
                }
                case 5 -> {
                    return;
                }
                default -> System.out.printf("Bruh... %d, rly?\n", userInput);
            }

            //noinspection ConstantConditions
            if (userInput != 5 && userInput != 1) {
                pause();
            }
        }
    }
}
