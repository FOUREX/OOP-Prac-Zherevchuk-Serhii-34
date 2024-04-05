package Task_5;

import java.io.IOException;

/*
 * Тут просто відбувся рефактор
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Application app = Application.getInstance();
        app.run();
    }
}
