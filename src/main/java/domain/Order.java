package domain;

import exception.PosException;
import utility.NumberUtility;

public class Order {

    private static final String INVALID_BUY_COUNT = "유효하지 않은 구매 수량입니다.";
    private static final int MAX_BUY_COUNT = 99;
    private static final String ORDER_RESULT_FORMAT = "%s %d %d";
    private final int buyCount;
    private final Menu menu;

    public Order(int buyCount,Menu menu) {
        validateOrder(buyCount,menu);
        this.buyCount = buyCount;
        this.menu = menu;
    }

    private void validateOrder(int buyCount, Menu menu) {
        if(!NumberUtility.isPositive(buyCount)){
            throw new PosException(INVALID_BUY_COUNT);
        }
        if(buyCount > MAX_BUY_COUNT){
            throw new PosException(INVALID_BUY_COUNT);
        }
    }

    public int getDiscountApplyMoney(){
        int sum = buyCount * menu.getPrice();
        if(menu.isDiscount(buyCount)){
            sum -= menu.getDiscountMoney(buyCount);
        }
        return sum;
    }

    @Override
    public String toString() {
        return String.format(ORDER_RESULT_FORMAT,menu.getName(),buyCount,menu.getPriceSum(buyCount));
    }

}
