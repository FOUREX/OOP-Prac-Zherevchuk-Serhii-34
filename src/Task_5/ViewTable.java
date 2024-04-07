package Task_5;

/**
 * Клас реалізуючий виведення результатів в консоль у вигляді таблиці
 */
public class ViewTable extends ViewResult {
    /**
     * Виводить результати обчислень у вигляді програми. Так же є макрофункцією
     */
    @Override
    public void show() {
        splitter();
        header();
        splitter();
        body();
        splitter();
    }

    /**
     * Виводить роздільник таблиці
     */
    private void splitter() {
        System.out.println("+" + "-".repeat(9) + "+-" + "-".repeat(13) + "+");
    }

    /**
     * Виводить заголовок таблиці
     */
    private void header() {
        System.out.printf("| %-8s| %-12s |\n", "Довжина", "Сума");
    }

    /**
     * Виводить основну інформацію
     */
    private void body() {
        for (CalcResult result : getResults()) {
            System.out.printf(
                "| %-8d| %-12.2f |\n",
                result.getLength(),
                result.getResult()
            );
        }
    }
}
