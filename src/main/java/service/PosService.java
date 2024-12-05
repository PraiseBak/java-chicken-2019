package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.OrderManager;
import dto.OrderRequest;
import exception.PosException;
import repository.PosRepository;

public class PosService {
    private static final String INVALID_PAY_METHOD = "INVALID_PAY_METHOD";
    private final PosRepository posRepository;
    private final String INVALID_TABLE_ORDER_EXISTS = "주문이 없는 테이블입니다.";


    public PosService(PosRepository posRepository) {
        this.posRepository = posRepository;
    }

    public void order(OrderRequest orderRequest) {
        OrderManager orderManager = posRepository.getOrderManager();
        Menu menu = MenuRepository.getMenu(orderRequest.getMenusIdx());
        Order order = new Order(orderRequest.getMenusBuy(), menu);
        orderManager.addOrder(order, orderRequest.getTableNumber());
    }

    public String orderResult(int tableIdx) {
        OrderManager orderManager = posRepository.getOrderManager();
        return orderManager.getOrderResult(tableIdx);
    }

    public String payResult(int payMethod, int tableIdx) {
        validatePayMethod(payMethod);
        return posRepository.getOrderManager().payCalculate(tableIdx,payMethod);

    }

    private static void validatePayMethod(int payMethod) {
        if(payMethod == 1 || payMethod == 2){
            return;
        }
        throw new PosException(INVALID_PAY_METHOD);
    }

    public void checkCalculateTableIdx(int tableIdx) {
        OrderManager orderManager = posRepository.getOrderManager();
        if(orderManager.isExistsOrderInTable(tableIdx)){
            return;
        }
        throw new PosException(INVALID_TABLE_ORDER_EXISTS);
    }

    public void checkMenusIdx(int menusIdx) {
        MenuRepository.validateMenusIdx(menusIdx);
    }
}
