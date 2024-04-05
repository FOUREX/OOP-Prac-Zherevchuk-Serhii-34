package Task_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu implements Command {
    private ArrayList<ConsoleCommand> menu = new ArrayList<>();

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
                    command.execute();
                    continue menuLoop;
                }
            }

            System.out.println("Bruh...");
        }
    }
}
