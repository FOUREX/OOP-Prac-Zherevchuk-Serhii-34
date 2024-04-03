package Task_4;

import Task_3.View;

import static org.junit.Assert.assertEquals;

public class Test {
    /** Тест серіалізації класу {@link ViewableTable} */
    @org.junit.Test
    public void testSerialization() throws Exception {
        View view = new ViewableTable().getView();
        view.init(10);

        view.save("temp/Task_3/calculator.bin");

        view.init(40);

        view.restore("temp/Task_3/calculator.bin");

        assertEquals(10, view.getCount());
    }
}
