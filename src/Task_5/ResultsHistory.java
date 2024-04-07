package Task_5;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Клас який зберігає попередні результати обчислень для подальшого скасування команд. Використовує патерн Singleton
 * для створення єдиного екземпляра класу
 */
public class ResultsHistory {
    /** Екземпляр класу */
    private static final ResultsHistory instance = new ResultsHistory();
    /** Стек типу {@link ArrayList<CalcResult>} який зберігає історію результатів */
    private final Stack<ArrayList<CalcResult>> resultsHistory = new Stack<>();

    /** Приватний конструктор класу */
    private ResultsHistory() {

    }

    /** Повертає єдиний екземпляр класу */
    public static ResultsHistory getInstance() {
        return instance;
    }

    /** Додає результати в історію результатів */
    public void add(ArrayList<CalcResult> results) {
        this.resultsHistory.push(new ArrayList<>(results));
    }

    /**
     * Видаляє зі стеку та повертає останній список результатів
     *
     * @return Минулі результати обчислень
     */
    public boolean undo(View view) {
        if (resultsHistory.isEmpty()) {
            return false;
        }

        view.setResults(resultsHistory.pop());

        return true;
    }
}
