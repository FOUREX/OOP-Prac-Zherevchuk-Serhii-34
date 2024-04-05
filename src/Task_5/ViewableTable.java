package Task_5;

/**
 * Підклас, який розширює клас {@link ViewableResult}
 */
public class ViewableTable extends ViewableResult {
    /**
     * Створює об'єкт типу {@link View}
     *
     * @return {@link View}
     */
    public View getView() {
        return new ViewTable();
    }
}
