package Task_6;

import java.io.IOException;

/**
 * Клас який використовує шаблон Singleton для створення єдиного екземпляра додатка
 */
class Application {
    /** Єдиний екземпляр додатка {@link Application} */
    private static final Application instance = new Application();
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view = new ViewableTable().getView();
    /** Екземпляр класу {@link Menu} який виконує команди */
    private final Menu menu = new Menu(view);

    /** Приватний конструктор класу */
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
    public void run() throws IOException, ClassNotFoundException, InterruptedException {
        menu.add(new Task_6.ConsoleCommands.View(view));
        menu.add(new Task_6.ConsoleCommands.Insert(view));
        menu.add(new Task_6.ConsoleCommands.Generate(view));
        menu.add(new Task_6.ConsoleCommands.Save(view));
        menu.add(new Task_6.ConsoleCommands.Restore(view));
        menu.add(new Task_6.ConsoleCommands.Undo(view));
        menu.add(new Task_6.ConsoleCommands.Execute(view));
        menu.execute();
    }
}