package Task_6.ConsoleCommands;

import Task_6.CalcResult;
import Task_6.ConsoleCommand;
import Task_6.View;

import java.io.IOException;

/**
 * Клас який реалізує пошук середнього значення серед результатів
 */
public class Avg implements ConsoleCommand {
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;
    /** Зберігає стан команди */
    private boolean running = true;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Avg(View view) {
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
        double avg = view.getResults().get(0).getResult();

        for (CalcResult result : view.getResults()) {
            avg += result.getResult();
        }

        this.running = false;

        System.out.printf("Середнє значення: %.2f\n", avg / view.getResults().size());
    }
}
