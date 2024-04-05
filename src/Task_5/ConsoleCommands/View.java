package Task_5.ConsoleCommands;

import Task_5.ConsoleCommand;

import java.io.IOException;

public class View implements ConsoleCommand {
    private Task_5.View view;

    public View(Task_5.View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    @Override
    public char getKey() {
        return '1';
    }

    @Override
    public String toString() {
        return "Вивести результати";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException {
        view.show();
    }
}
