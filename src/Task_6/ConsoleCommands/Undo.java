package Task_6.ConsoleCommands;

import Task_6.ConsoleCommand;
import Task_6.ResultsHistory;
import Task_6.View;

import java.io.IOException;

/**
 * Клас реалізуючий команду скасування останньої операції
 */
public class Undo implements ConsoleCommand {
    /** Екземпляр класу {@link ResultsHistory} який зберігає історію результатів */
    private static final ResultsHistory resultsHistory = ResultsHistory.getInstance();
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;

    /**
     * Конструктор класу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Undo(View view) {
        this.view = view;
    }

    /** Повертає символ при введенні якого спрацьовуватиме команда */
    public char getKey() {
        return '6';
    }

    /** Повертає назву команди */
    public String toString() {
        return "Відмінити";
    }

    /** Виконує скасування останньої операції */
    public void execute() throws IOException, ClassNotFoundException {
        boolean ok = resultsHistory.undo(view);

        if (!ok) {
            System.out.println("Немає змін");
        }
    }
}
