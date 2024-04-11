package Task_6;

/**
 * Інтерфейс який представляє чергу команд
 */
public interface Queue {
    /** Додає команду в чергу */
    public void add(Command command);
    /** Вилучає команду з черги */
    public Command take();
}
