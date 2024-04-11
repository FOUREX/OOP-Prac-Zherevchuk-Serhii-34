package Task_6.ConsoleCommands;

import Task_6.ConsoleCommand;
import Task_6.View;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас який реалізує автоматичну генерацію чисел для обчислень
 */
public class Generate implements ConsoleCommand {
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Generate(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    @Override
    public char getKey() {
        return '3';
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
    @Override
    public String toString() {
        return "Згенерувати";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Кількість розрахунків: ");
        int count = scanner.nextInt();

        view.init(count);
        view.calculate();
    }
}
