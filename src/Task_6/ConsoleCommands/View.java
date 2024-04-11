package Task_6.ConsoleCommands;

import Task_6.ConsoleCommand;

import java.io.IOException;

/**
 * Клас який реалізує виведення результатів в консоль
 */
public class View implements ConsoleCommand {
    /** Екземпляр класу {@link Task_6.View} який реалізує виведення результатів */
    private final Task_6.View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link Task_6.View}
     */
    public View(Task_6.View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    @Override
    public char getKey() {
        return '1';
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
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
