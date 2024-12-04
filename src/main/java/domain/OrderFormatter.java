package domain;

import java.util.List;

public class OrderFormatter {
    private final static String ORDER_RESULT_PREFIX = "## 주문 내역\n메뉴 수량 금액\n";

    public static String getOrderResult(List<Order> orders) {
        StringBuilder stringBuilder = new StringBuilder(ORDER_RESULT_PREFIX);
        for(Order order : orders){
            System.out.println(order.toString());
            stringBuilder.append(order.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
