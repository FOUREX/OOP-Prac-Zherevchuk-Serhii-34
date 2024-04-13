package Task_7;

import Task_6.ViewTable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Спостерігаємий клас на основі {@link ViewTable}
 */
public class ObservableViewTable extends ViewTable implements Observable {
    private final ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Додає спостерігача
     *
     * @param observer Екземпляр спостерігача
     */
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * Оповіщає всіх спостерігачів
     *
     * @param type Тип дії
     * @param message Повідомлення про дію
     */
    @Override
    public void notify(String type, String message) {
        for (Observer observer : observers) {
            observer.notify(type, message);
        }
    }

    /** Відправляє повідомлення про випадкову ініціалізацію та викликає метод із батьківського класу */
    @Override
    public void init(int count) {
        notify(
            "генерація",
            String.format("Викликана випадкова генерація даних. Кількість результатів: %d", count)
        );

        super.init(count);
    }

    /** Відправляє повідомлення про ініціалізацію та викликає метод із батьківського класу */
    @Override
    public void init(int count, int start) {
        notify(
            "генерація",
            String.format("Викликана генерація даних. Кількість результатів: %d, початкове значення: %d", count, start)
        );

        super.init(count, start);
    }

    /** Відправляє повідомлення про серіалізацію та викликає метод із батьківського класу */
    @Override
    public void save(String path) throws IOException {
        notify("серіалізація", "Викликана серіалізація");
        super.save(path);
    }

    /** Відправляє повідомлення про десеріалізацію та викликає метод із батьківського класу */
    @Override
    public void restore(String path) throws IOException, ClassNotFoundException {
        notify("серіалізація", "Викликана десеріалізація");
        super.restore(path);
    }
}
