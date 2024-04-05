package Task_5;

/**
 * Клас, який реалізує інтерфейс {@link Viewable}
 */
public class ViewableResult implements Viewable {
    /**
     * Створює об'єкт типу {@link View}
     *
     * @return {@link View}
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
