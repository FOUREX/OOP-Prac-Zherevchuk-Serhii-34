package Task_5;

import Task_5.ConsoleCommands.*;
import Task_5.ConsoleCommands.View;

import java.io.IOException;

/**
 * Клас {@link Application}, який використовує шаблон Singleton для створення єдиного екземпляра додатка
 */
class Application {
    private static final Application instance = new Application();
    private Task_5.View view = new ViewableTable().getView();
    private Menu menu = new Menu();

    private Application() {

    }

    /**
     * Метод для отримання екземпляру додатка
     *
     * @return екземпляр {@link Application}
     */
    public static Application getInstance() {
        return instance;
    }

    /**
     * Метод для запуску додатка, який очікує введення користувача та виконує відповідні команди.
     */
    public void run() throws IOException, ClassNotFoundException {
        menu.add(new View(view));
        menu.add(new Insert(view));
        menu.add(new Generate(view));
        menu.add(new Save(view));
        menu.add(new Restore(view));
        menu.execute();
    }
}