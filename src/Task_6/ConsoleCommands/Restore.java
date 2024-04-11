package Task_6.ConsoleCommands;

import Task_6.ConsoleCommand;
import Task_6.View;

import java.io.IOException;

/**
 * Клас який реалізує відновлення раніше збережених результатів обчислення
 */
public class Restore implements ConsoleCommand {
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Restore(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '5';
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
    public String toString() {
        return "Відновити";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.restore("temp/Task_6/results.bin");
    }
}
