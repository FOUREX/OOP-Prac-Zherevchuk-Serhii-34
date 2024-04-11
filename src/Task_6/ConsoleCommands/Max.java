package Task_6.ConsoleCommands;

import Task_6.CalcResult;
import Task_6.ConsoleCommand;
import Task_6.View;

import java.io.IOException;

/**
 * Клас який реалізує пошук найбільшого значення серед результатів
 */
public class Max implements ConsoleCommand {
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;
    /** Зберігає стан команди */
    private boolean running = true;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Max(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди
     */
    public char getKey() {
        return '2';
    }

    /** Повертає стан програми */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
    public String toString() {
        return "Ввести";
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException {
        double max = view.getResults().get(0).getResult();

        for (CalcResult result : view.getResults()) {
            max = Math.max(result.getResult(), max);
        }

        this.running = false;

        System.out.printf("Максимальне значення: %f\n", max);
    }
}
