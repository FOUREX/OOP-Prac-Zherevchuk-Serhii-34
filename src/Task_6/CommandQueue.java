package Task_6;

import java.util.ArrayList;

/**
 * Реалізує чергу виконання команд
 */
public class CommandQueue implements Queue {
    private final ArrayList<Command> tasks = new ArrayList<>();
    private boolean shutdown = false;
    private boolean waiting = false;

    /**
     * Конструктор класу
     */
    public CommandQueue() {
        new Thread(new Worker()).start();
    }

    /**
     * Додає команду в чергу
     *
     * @param command Команда
     */
    @Override
    public void add(Command command) {
        tasks.add(command);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /** Вилучає команду з черги */
    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command) tasks.remove(0);
    }
     /** Завершує виконання потоку */
    public void shutdown() {
        this.shutdown = true;
    }

    private class Worker implements Runnable {

        /**
         * Запускає операції з черги
         */
        @Override
        public void run() {
            while (!shutdown) {
                Command command = take();
                try {
                    command.execute();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
