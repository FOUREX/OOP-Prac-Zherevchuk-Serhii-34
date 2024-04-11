package Task_6;

import java.io.IOException;

/*
 * Тут просто відбувся рефактор
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Application app = Application.getInstance();
        app.run();
    }
}
