package Task_3;

import java.io.*;


/**
 * Клас для обчислення та серіалізації даних
 *
 * @author FOUREX aka Сергій Жеревчук
 */
public class Calculator implements Serializable {
    /** Довжина сторони */
    private double length;
    /** Площа трикутника із властивістю transient тому, що дані кожного разу обчислюються по новій */
    private transient double triangleArea;
    /** Площа прямокутника із властивістю transient тому, що дані кожного разу обчислюються по новій */
    private transient double rectangleArea;
    /** Результат обчислень */
    private double result;

    /** Базовий ініціалізатор класу */
    public Calculator() {
        this(0);
    }

    /**
     * Ініціалізатор класу
     *
     * @param length Довжина сторони за якою обчислюватимуться площі трикутника та прямокутника
     */
    public Calculator(double length) {
        this.length = length;
    }

    /**
     * Обчислює суму площ трикутника та прямокутника
     */
    public void calculateSum() {
        this.triangleArea = (Math.sqrt(3) / 4) * Math.pow(length, 2);
        this.rectangleArea = Math.pow(this.length, 2);

        this.result = this.triangleArea + rectangleArea;
    }

    /** Повертає площу трикутника із заданою стороною */
    public double getTriangleArea() {
        return this.triangleArea;
    }

    /** Повертає площу прямокутника із заданою стороною */
    public double getRectangleArea() {
        return this.rectangleArea;
    }

    /** Повертає поточну довжину сторони */
    public double getLength() {
        return length;
    }

    /** Встановлює довжину сторони */
    public void setLength(double length) {
        this.length = length;
    }

    /** Повертає результат обчислень */
    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("Сума площ трикутника та прямокутника: %f\n", this.getResult());
    }

    /**
     * Серіалізація класу {@link Calculator}
     *
     * @param path Шлях до серіалізованого класу
     */
    public void serialize(String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this);
        }
    }

    /**
     * Десеріалізація класу {@link Calculator}
     *
     * @param path Шлях до серіалізованого класу
     * @return Десеріалізований екземпляр класу
     */
    public static Calculator deserialize(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Calculator) objectInputStream.readObject();
        }
    }
}
