package Task_4;

import Task_3.View;

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
    private static void pause() {
        System.out.println("\nНатисніть Enter для продовження");
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) throws Exception {
        boolean serialized = false;
        Scanner scanner = new Scanner(System.in);
        View view = new ViewableTable().getView();

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
                    System.out.print("Кількість результатів: ");
                    view.init(scanner.nextInt());
                }
                case 2 -> {
                    view.show();
                }
                case 3 -> {
                    serialized = true;
                    view.save("temp/Task_3/view.bin");
                    System.out.println("Клас серіалізований");
                }
                case 4 -> {
                    if (!serialized) {
                        System.out.println("Серіалізуйте клас");
                        break;
                    }

                    view.restore("temp/Task_3/view.bin");
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
