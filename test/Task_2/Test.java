package Task_2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

public class Test {
    @org.junit.Test
    public void testCalculateSum() {
        HashMap<Integer, Double> results = new HashMap<>();
        results.put(0, 0.0);
        results.put(1, 1.4330127018922192);
        results.put(2, 5.732050807568877);
        results.put(3, 12.897114317029974);
        results.put(4, 22.928203230275507);
        results.put(5, 35.82531754730548);

        for (int i = 0; i < results.size(); i++) {
            Calculator calculator = new Calculator(i);
            calculator.calculateSum();

            assertEquals(results.get(i), calculator.getResult(), 0.001);
        }
    }

    @org.junit.Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        Calculator calculator = new Calculator(5);

        calculator.serialize("temp/Task_2/calculator.bin");
        Calculator deserializedCalculator = Calculator.deserialize("temp/Task_2/calculator.bin");

        assertEquals(calculator.getResult(), deserializedCalculator.getResult(), 0.001);
    }
}
