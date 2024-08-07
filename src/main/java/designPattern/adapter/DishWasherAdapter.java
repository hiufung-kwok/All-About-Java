package designPattern.adapter;

public class DishWasherAdapter extends DishWasher {

    private LegacyDishWasher dw = new LegacyDishWasher();

    public void washDishes () {
        dw.washDishes();
    }


}
