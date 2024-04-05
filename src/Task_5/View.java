package Task_5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Інтерфейс фабрикуємих об'єктів. Реалізує виведення результатів в консоль та їх зберігання/відновлення
 */
public interface View {
    /**
     * Ініціалізує та встановлює кількість результатів, випадкова генерація чисел
     *
     * @param count Кількість обчислень
     */
    public void init(int count);

    /**
     * Ініціалізує та встановлює кількість результатів
     *
     * @param count Кількість обчислень
     * @param start Початкове значення
     */
    public void init(int count, int start);

    /** Проводить обчислення */
    public void calculate();

    /** Виводить результати обчислень в консоль */
    public void show();

    /** Повертає колекцію {@link CalcResult} */
    public ArrayList<CalcResult> getResults();

    /**
     * Зберігає поточні результати
     *
     * @param path Директорія збереження
     */
    public void save(String path) throws IOException;

    /**
     * Відновлює раніше збережені результати
     *
     * @param path Директорія збереження
     */
    public void restore(String path) throws IOException, ClassNotFoundException;
}
