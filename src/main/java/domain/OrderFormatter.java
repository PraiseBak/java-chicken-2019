package domain;

import java.util.List;

public class OrderFormatter {
    private final static String ORDER_RESULT_PREFIX = "## 주문 내역\n메뉴 수량 금액\n";
    private static final int IS_CASH = 2;
    private static final String PAY_RESULT_FORMAT = "## 최종 결제할 금액\n%d원";

    public static String getOrderResult(List<Order> orders) {
        StringBuilder stringBuilder = new StringBuilder(ORDER_RESULT_PREFIX);
        for(Order order : orders){
            stringBuilder.append(order.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String getFormattedPayCalculate(List<Order> orders, int payMethod) {
        int discountApplyPrice = 0;
        for(Order order : orders){
            discountApplyPrice += order.getDiscountApplyMoney();
        }
        if(payMethod == IS_CASH){
            discountApplyPrice = discountApplyPrice - (discountApplyPrice * 5 / 100);
        }
        return String.format(PAY_RESULT_FORMAT,discountApplyPrice);
    }
}
