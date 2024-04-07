package Task_5;

/**
 * Клас для тестів
 */
public class Test {
    private final ResultsHistory resultsHistory = ResultsHistory.getInstance();
    private final View view = new ViewableResult().getView();

    /**
     * Тест скасування попередньої команди
     */
    @org.junit.Test
    public void testUndo() {
        view.init(5);
        view.calculate();

        resultsHistory.add(view.getResults());

        view.init(10);
        view.calculate();

        resultsHistory.undo(view);

        assert view.getResults().size() == 5;
    }
}
