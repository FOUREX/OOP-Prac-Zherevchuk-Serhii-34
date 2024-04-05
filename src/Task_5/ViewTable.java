package Task_5;

/**
 * Клас реалізуючий виведення результатів в консоль у вигляді таблиці
 */
public class ViewTable extends ViewResult {
    @Override
    public void show() {
        splitter();
        header();
        splitter();
        body();
        splitter();
    }

    private void splitter() {
        System.out.println("+" + "-".repeat(9) + "+-" + "-".repeat(13) + "+");
    }

    private void header() {
        System.out.printf("| %-8s| %-12s |\n", "Довжина", "Сума");
    }

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
