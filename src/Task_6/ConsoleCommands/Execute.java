package Task_6.ConsoleCommands;

import Task_6.CommandQueue;
import Task_6.ConsoleCommand;
import Task_6.View;

import java.util.concurrent.TimeUnit;

/**
 * Запускає WorkerThread
 */
public class Execute implements ConsoleCommand {
    private final Task_6.View view;

    public Execute(View view) {
        this.view = view;
    }

    /**
     * Метод, що повертає гарячу клавішу для команди консолі.
     *
     * @return гаряча клавіша для команди
     */
    @Override
    public char getKey() {
        return '7';
    }

    /**
     * Повертає назву команди
     *
     * @return Назва команди
     */
    public String toString() {
        return "Виконати";
    }

    /**
     * Метод для виконання команди.
     */
    @Override
    public void execute() throws InterruptedException {
        System.out.println("Початок виконання потоків");

        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        Task_6.ConsoleCommands.Avg avg = new Task_6.ConsoleCommands.Avg(view);
        Task_6.ConsoleCommands.Max max = new Task_6.ConsoleCommands.Max(view);
        Task_6.ConsoleCommands.Min min = new Task_6.ConsoleCommands.Min(view);

        queue1.add(avg);
        queue2.add(max);
        queue2.add(min);

        while (avg.isRunning() || max.isRunning() || min.isRunning()) {
            TimeUnit.MICROSECONDS.sleep(100);
        }

        queue1.shutdown();
        queue2.shutdown();

        System.out.println("Всі потоки завершили свою роботу");
    }
}
