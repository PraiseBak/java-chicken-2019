package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.OrderManager;
import dto.OrderRequest;
import repository.PosRepository;

public class PosService {
    private final PosRepository posRepository;

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
}
