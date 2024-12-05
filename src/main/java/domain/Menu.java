package domain;

import exception.PosException;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;
    private final int DISCOUNT_PRICE = 10000;
    private final String INVALID_MENU = "유효하지 않은 메뉴입니다.";

    public Menu(final int number, final String name, final Category category, final int price) {
        validateMenu(number,name,price);
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    private void validateMenu(int number, String name, int price) {
        if(price < 0){
            throw new PosException(INVALID_MENU);
        }
        if(name == null || name.isEmpty()){
            throw new PosException(INVALID_MENU);
        }
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public boolean isSame(int menusIdx) {
        return menusIdx == number;
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getPriceSum(int buyCount){
        return price * buyCount;
    }

    public boolean isDiscount(int buyCount) {
        return buyCount >= 10 && category == Category.CHICKEN;
    }

    public int getDiscountMoney(int buyCount) {
        return DISCOUNT_PRICE * (buyCount % 10);
    }
}
