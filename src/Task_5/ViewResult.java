package Task_5;

import java.io.*;
import java.util.ArrayList;

public class ViewResult implements View {
    /** Колекція типу {@link CalcResult} в якій зберігаються результати обчислень */
    protected ArrayList<CalcResult> results = new ArrayList<>();

    /**
     * Ініціалізує та встановлює кількість результатів
     *
     * @param count Кількість обчислень
     * @param start Початкове значення
     */
    public void init(int count, int start) {
        results.clear();

        for (int i = 0; i < count; i++) {
            results.add(new CalcResult(start + i));
        }
    }

    /**
     * Проводить обчислення
     */
    @Override
    public void calculate() {
        for (CalcResult result : getResults()) {
            result.calculate();
        }
    }

    /**
     * Виводить результати обчислень в консоль
     */
    @Override
    public void show() {
        for (CalcResult result : getResults()) {
            System.out.printf(
                "Сума площ трикутника та прямокутника зі стороною %d = %f\n",
                result.getLength(),
                result.getResult()
            );
        }
    }

    /**
     * Повертає колекцію {@link CalcResult}
     */
    @Override
    public ArrayList<CalcResult> getResults() {
        return this.results;
    }

    /**
     * Зберігає поточні результати
     *
     * @param path Директорія збереження
     */
    @Override
    public void save(String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this.results);
        }
    }

    /**
     * Відновлює раніше збережені результати
     *
     * @param path Директорія збереження
     */
    @Override
    @SuppressWarnings("unchecked")
    public void restore(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            this.results = (ArrayList<CalcResult>) objectInputStream.readObject();
        }
    }
}
