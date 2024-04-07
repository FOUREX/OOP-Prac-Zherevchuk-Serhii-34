package Task_5;

import Task_5.ConsoleCommands.Undo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Клас реалізуючий меню, виконання та скасування команд
 */
public class Menu implements Command {
    /** Екземпляр класу {@link ResultsHistory} який зберігає історію результатів */
    private static final ResultsHistory resultsHistory = ResultsHistory.getInstance();
    /** Список елементів меню */
    private final ArrayList<ConsoleCommand> menu = new ArrayList<>();
    /** Екземпляр класу {@link View} який реалізує виведення результатів */
    private final View view;

    /**
     * Конструкток кламу
     *
     * @param view Екземпляр класу {@link View}
     */
    public Menu(View view) {
        this.view = view;
    }

    /**
     * Додає нову команду в колекцію
     *
     * @param command Реалізує {@link ConsoleCommand}
     * @return {@link ConsoleCommand}
     */
    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    /**
     * Повертає список доступних команд
     *
     * @return список команд у вигляді строки
     */
    @Override
    public String toString() {
        StringBuilder commandsList = new StringBuilder();

        for (ConsoleCommand command : menu) {
            commandsList.append(String.format("%c. %s | ", command.getKey(), command));
        }

        return commandsList.toString();
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        menuLoop:
        while (true) {
            System.out.println(this);
            System.out.print("Виберіть команду: ");

            char key = in.readLine().charAt(0);

            if (key == '0') {
                return;
            }

            for (ConsoleCommand command : menu) {
                if (key == command.getKey()) {
                    if (!(command instanceof Undo || command instanceof Task_5.ConsoleCommands.View)) {
                        resultsHistory.add(view.getResults());
                    }

                    command.execute();
                    continue menuLoop;
                }
            }

            System.out.println("Bruh...");
        }
    }
}
