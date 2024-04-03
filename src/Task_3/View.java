package Task_3;

import java.io.IOException;
import java.util.ArrayList;

public interface View {
    /** Показує заголовок */
    public void header();

    /** Показує основну частину */
    public void body();

    /** Показує колонтитул */
    public void footer();

    /** Показує об'єкт цілком */
    public void show();

    /** Повертає кількість елементів */
    public int getCount();

    /** Повертає колекцію {@link Calculator} */
    public ArrayList<Calculator> getCalculators();

    /** Виконує ініціалізацію */
    public void init(int count);

    public void save(String path) throws IOException;

    /** Відновлює раніше збережені дані */
    public void restore(String path) throws Exception;
}
