package Task_5.ConsoleCommands;

import Task_5.ConsoleCommand;
import Task_5.View;

import java.io.IOException;

public class Restore implements ConsoleCommand {
    private final Task_5.View view;

    public Restore(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '5';
    }

    public String toString() {
        return "Відновити";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.restore("temp/Task_5/results.bin");
    }
}
