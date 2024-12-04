import domain.TableRepository;
import dto.OrderRequest;
import service.PosService;

public class PosController {
    private final PosService posService;

    public PosController(PosService posService){
        this.posService = posService;
    }

    public void checkTableIdx(int tableNumber) {
        TableRepository.validateTable(tableNumber);
    }

    public void checkMenusIdx() {

    }

    public void orderRequest(OrderRequest orderRequest) {
        posService.order(orderRequest);
    }
}
