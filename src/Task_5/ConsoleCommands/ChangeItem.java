package Task_5.ConsoleCommands;

import Task_5.CalcResult;
import Task_5.Command;

import java.io.IOException;

public class ChangeItem implements Command {
    private CalcResult calcResult;
    private int length;

    public void setResult(CalcResult calcResult) {
        this.calcResult = calcResult;
    }

    public CalcResult getResult() {
        return this.calcResult;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    /**
     * Виконує команду
     */
    @Override
    public void execute() throws IOException {
        calcResult.setLength(length);
        calcResult.calculate();
    }
}
