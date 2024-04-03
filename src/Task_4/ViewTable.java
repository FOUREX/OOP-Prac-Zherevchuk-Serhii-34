package Task_4;

import Task_3.ViewResult;

/**
 * Клас для відображення результатів обчислень у вигляді таблиці
 */
public class ViewTable extends ViewResult {
    /**
     * Конструктор за замовчуванням
     */
    public ViewTable() {

    }

    @Override
    public void show() {
        header();
        separator();
        body();
    }

    /** Метод для виведення заголовків таблиці */
    @Override
    public void header() {
        System.out.printf("%-10s| %-10s\n", "Довжина", "Сума");
    }

    /** Метод для виведення розділювача між заголовками та даними */
    public void separator() {
        System.out.println("-".repeat(10) + "+-" + "-".repeat(10));
    }

    /** Метод для виведення даних у вигляді таблиці */
    @Override
    public void body() {
        for (int i = 1; i < getCalculators().size(); i++) {
            System.out.printf(
                "%-10s| %-10s\n",
                getCalculators().get(i).getLength(),
                getCalculators().get(i).getResult()
            );
        }
    }

    /** Перевантажений метод для виведення даних у вигляді таблиці */
    public void body(String[][] data) {
        for (int i = 1; i < data.length; i++) {
            System.out.printf("%-10s| %-10s\n", data[i][0], Double.parseDouble(data[i][1]));
        }
    }

}
