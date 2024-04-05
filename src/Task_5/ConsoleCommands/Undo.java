package Task_5.ConsoleCommands;

import Task_5.View;
import Task_5.ConsoleCommand;

import java.io.IOException;

public class Undo implements ConsoleCommand {
    private final View view;

    public Undo(View view) {
        this.view = view;
    }

    public char getKey() {
        return '6';
    }

    public String toString() {
        return "відмінити";
    }

    public void execute() throws IOException, ClassNotFoundException {
        view.restore("temp/Task_5/results.bin");
    }
}
