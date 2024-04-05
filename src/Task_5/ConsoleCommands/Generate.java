package Task_5.ConsoleCommands;

import Task_5.CalcResult;
import Task_5.ConsoleCommand;
import Task_5.View;

import java.io.IOException;
import java.util.Scanner;

public class Generate extends ChangeItem implements ConsoleCommand {
    private View view;

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }

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
