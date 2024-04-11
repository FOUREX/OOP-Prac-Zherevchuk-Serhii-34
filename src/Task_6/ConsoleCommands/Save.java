package Task_6.ConsoleCommands;

import Task_6.ConsoleCommand;
import Task_6.View;

import java.io.IOException;

/**
 * Клас який реалізує збереження поточних результатів обчислень
 */
public class Save implements ConsoleCommand {
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
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
        view.save("temp/Task_6/results.bin");
    }
}
