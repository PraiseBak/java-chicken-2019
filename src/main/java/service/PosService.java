package service;

import dto.OrderRequest;
import repository.PosRepository;

public class PosService {
    private final PosRepository posRepository;

    public PosService(PosRepository posRepository) {
        this.posRepository = posRepository;
    }

    public void order(OrderRequest orderRequest) {

    }
}
