package repository;

import domain.OrderManager;

public class PosRepository {
    private final OrderManager orderManager = new OrderManager();
    public PosRepository(){

    }

    public OrderManager getOrderManager() {
        return orderManager;
    }
}
