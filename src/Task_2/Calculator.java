package Task_2;

import java.io.IOException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


/**
 * Клас для обчислення та серіалізації даних
 *
 * @author FOUREX aka Сергій Жеревчук
 */
public class Calculator implements Serializable {
    /*
     * triangleArea, rectangleArea та result не серіалізуються тому, що вони кожного разу обчислюються
     */
    private final double length;
    private transient double triangleArea;
    private transient double rectangleArea;
    private transient double result;

    /**
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

    /** Геттер для triangleArea */
    public double getTriangleArea() {
        return this.triangleArea;
    }

    /** Геттер для rectangleArea */
    public double getRectangleArea() {
        return this.rectangleArea;
    }

    public double getResult() {
        return result;
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
