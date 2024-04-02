package Task_3;

import static org.junit.Assert.*;

public class Test {
    /** Тест серіалізації класу {@link View} */
    @org.junit.Test
    public void testSerialization() throws Exception {
        View view = new ViewableResult().getView();
        view.init(10);

        view.save("temp/Task_3/calculator.bin");

        view.init(40);

        view.restore("temp/Task_3/calculator.bin");

        assertEquals(10, view.getCount());
    }
}
