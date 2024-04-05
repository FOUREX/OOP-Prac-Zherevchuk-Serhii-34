package Task_5.ConsoleCommands;

import Task_5.ConsoleCommand;
import Task_5.View;

import java.io.IOException;

public class Save implements ConsoleCommand {
    private final Task_5.View view;

    public Save(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '4';
    }

    public String toString() {
        return "Зберегти";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException {
        view.save("temp/Task_5/results.bin");
    }
}
