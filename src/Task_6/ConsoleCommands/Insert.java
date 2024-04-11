package Task_6.ConsoleCommands;

import Task_6.ConsoleCommand;
import Task_6.View;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас який реалізує введення даних для обчислень
 */
public class Insert implements ConsoleCommand {
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Insert(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '2';
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
    public String toString() {
        return "Ввести";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Початкове число: ");
        int start = scanner.nextInt();
        System.out.print("Кількість розрахунків: ");
        int count = scanner.nextInt();

        view.init(count, start);
        view.calculate();
    }
}
