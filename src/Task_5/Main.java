package Task_5;

import java.io.IOException;

/*
 * Тут просто відбувся рефактор
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ViewableTable().getView();

        view.init(10, 1);
        view.calculate();
        view.show();
        view.save("temp/Task_5/results.bin");

        System.out.println(" ");

        view.init(10, 11);
        view.calculate();
        view.show();

        System.out.println(" ");

        view.restore("temp/Task_5/results.bin");
        view.calculate();
        view.show();
    }
}
