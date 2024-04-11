package Task_6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Клас для тестів
 */
public class Test {
    private final View view = new ViewableResult().getView();
    private final ConsoleCommand command = new Task_6.ConsoleCommands.Execute(view);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Тест виконання команди
     */
    @org.junit.Test
    public void testExecute() throws IOException, ClassNotFoundException, InterruptedException {
        System.setOut(new PrintStream(outContent));

        view.init(15, 1);
        view.calculate();

        command.execute();

        String output = outContent.toString().trim();
        assert output.contains("Максимальне значення: 322,427858");
        assert output.contains("Середнє значення: 118,56");
        assert output.contains("Мінімальне значення: 1,433013");
    }
}
