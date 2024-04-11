package Task_6;

import java.io.*;

/**
 * Клас який серіалізується для обчислення суми площ трикутника та прямокутника
 */
public class CalcResult implements Serializable {
    /** Довжина сторони трикутника/прямокутника */
    private int length;
    /** Площа трикутника. Створена для демонстрації поля transient */
    private transient double triangleArea;
    /** Площа прямокутника. Створена для демонстрації поля transient */
    private transient double rectangleArea;
    /** Результат обчислень */
    private transient double result;

    /** Повертає поточну довжину сторони */
    public int getLength() {
        return length;
    }

    /** Змінює поточну довжину сторони */
    public void setLength(int length) {
        this.length = length;
    }

    /** Повертає результат обчислень */
    public double getResult() {
        return result;
    }

    /** Конструктор класу за замовчуванням */
    public CalcResult() {
        this.length = 5;
    }

    /** Конструктор класу */
    public CalcResult(int length) {
        this.length = length;
    }

    /** Обчислює суму площ трикутника та прямокутника. Так же макрофункція */
    public void calculate() {
        calculateTriangleArea();
        calculateRectangleArea();

        this.result = this.triangleArea + this.rectangleArea;
    }

    /** Обчислює суму прощу трикутника */
    private void calculateTriangleArea() {
        this.triangleArea = (Math.sqrt(3) / 4) * Math.pow(length, 2);
    }

    /** Обчислює суму прощу прямокутника */
    private void calculateRectangleArea() {
        this.rectangleArea = Math.pow(this.length, 2);
    }

    /**
     * Серіалізує клас у файл
     *
     * @param path Директорія файлу для збереження файлу із серіалізованим класом {@link CalcResult}
     */
    public void serialize(String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this);
        }
    }

    /**
     * Десеріалізує клас із файлу
     *
     * @param path Директорія файлу з серіалізованим класом {@link CalcResult}
     */
    public static CalcResult deserialize(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            CalcResult calcResult = (CalcResult) objectInputStream.readObject();
            calcResult.calculate();

            return calcResult;
        }
    }
}
