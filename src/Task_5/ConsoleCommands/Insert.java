package Task_5.ConsoleCommands;

import Task_5.ConsoleCommand;
import Task_5.View;

import java.io.IOException;
import java.util.Scanner;

public class Insert implements ConsoleCommand {
    private final View view;

    public Insert(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '2';
    }

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
