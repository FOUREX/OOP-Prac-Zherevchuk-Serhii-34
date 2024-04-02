package Task_3;

import java.io.*;
import java.util.ArrayList;

public class ViewResult implements View {
    private static final int DEFAULT_COUNT = 5;
    ArrayList<Calculator> calculators = new ArrayList<Calculator>();

    public ViewResult() {
        this(DEFAULT_COUNT);
    }

    public ViewResult(int count) {
        this.init(count);
    }

    /**
     * Показує заголовок
     */
    @Override
    public void header() {
        System.out.println("========Обчислення========");
    }

    /**
     * Показує основну частину
     */
    @Override
    public void body() {
        for (Calculator calculator : calculators) {
            System.out.printf(
                "Сума площ трикутника та прямокутника зі стороною %f = %f\n",
                calculator.getLength(), calculator.getResult()
            );
        }
    }

    /**
     * Показує колонтитул
     */
    @Override
    public void footer() {
        System.out.println("========================");
    }

    /**
     * Показує об'єкт цілком
     */
    @Override
    public void show() {
        header();
        body();
        footer();
    }

    @Override
    public int getCount() {
        return this.calculators.size();
    }

    /**
     * Виконує ініціалізацію екземплярів {@link Calculator}
     */
    @Override
    public void init(int count) {
        calculators.clear();

        for (int i = 0; i < count; i++) {
            calculators.add(new Calculator());
        }

        for (Calculator calculator : this.calculators) {
            calculator.setLength((int) (Math.random() * (50 - 1 + 1)) + 1);
            calculator.calculateSum();
        }
    }

    /**
     * Зберігає дані для наступного відновлення
     */
    @Override
    public void save(String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this.calculators);
        }
    }

    /**
     * Відновлює раніше збережені дані
     */
    @Override
    @SuppressWarnings("unchecked")
    public void restore(String path) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            this.calculators = (ArrayList<Calculator>) objectInputStream.readObject();
        }
    }
}
