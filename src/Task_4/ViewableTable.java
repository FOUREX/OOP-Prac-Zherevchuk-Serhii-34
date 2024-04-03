package Task_4;

import Task_3.View;
import Task_3.Viewable;
import Task_3.ViewableResult;

/**
 * Клас, який реалізує інтерфейс {@link Viewable} та надає об'єкт {@link ViewTable}.
 */
public class ViewableTable extends ViewableResult {

    /**
     * Метод для отримання об'єкта {@link ViewTable}.
     * @return об'єкт {@link ViewTable}
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
