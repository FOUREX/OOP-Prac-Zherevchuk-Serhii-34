package Task_5;

public class ViewableResult implements Viewable {
    /**
     * @return
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
