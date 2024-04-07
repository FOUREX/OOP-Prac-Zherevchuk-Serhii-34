package Task_5.ConsoleCommands;

import Task_5.ConsoleCommand;
import Task_5.View;

import java.io.IOException;

/**
 * Клас який реалізує збереження поточних результатів обчислень
 */
public class Save implements ConsoleCommand {
    /** Екземпляр класу {@link Task_5.View} який реалізує виведення результатів */
    private final Task_5.View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link Task_5.View}
     */
    public Save(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '4';
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
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
