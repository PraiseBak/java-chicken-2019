package domain;

import exception.PosException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private final Map<Integer, List<Order>> orderMap = new HashMap<>();
    private final String INVALID_TABLE = "존재하지 않는 테이블입니다.";

    public OrderManager(){
        initMap();
    }

    private void initMap() {
        for(Table table : TableRepository.tables()){
            orderMap.put(table.getIdx(),new ArrayList<>());
        }
    }

    public void addOrder(Order order,int tableIdx) {
        validateTableIdx(tableIdx);
        List<Order> orders = orderMap.get(tableIdx);
        orders.add(order);
    }

    private void validateTableIdx(int tableIdx) {
        if(!TableRepository.isExists(tableIdx)){
            throw new PosException(INVALID_TABLE);
        }
    }

    public String getOrderResult(int tableIdx) {
        List<Order> orders = orderMap.get(tableIdx);
        return OrderFormatter.getOrderResult(orders);
    }

    public boolean isExistsOrderInTable(int tableIdx) {
        return !orderMap.get(tableIdx).isEmpty();
    }

    public String payCalculate(int tableIdx, int payMethod) {
        List<Order> orders = orderMap.get(tableIdx);
        TableRepository.tableUpdate(tableIdx,false);
        orderMap.put(tableIdx,new ArrayList<>());
        return OrderFormatter.getFormattedPayCalculate(orders,payMethod);
    }
}
