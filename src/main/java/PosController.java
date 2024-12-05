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

    public void checkMenusIdx(int menusIdx) {
        posService.checkMenusIdx(menusIdx);

    }

    public void orderRequest(OrderRequest orderRequest) {
        posService.order(orderRequest);
        TableRepository.tableUpdate(orderRequest.getTableNumber(),true);
    }

    /**
     * 계산 걸려있는지
     * @param tableIdx
     */
    public void checkCalculateTableIdx(int tableIdx) {
        posService.checkCalculateTableIdx(tableIdx);
    }

    public String pay(int payMethod, int tableIdx) {
        return posService.payResult(payMethod,tableIdx);
    }

    public String getOrderResult(int tableIdx) {
        return posService.orderResult(tableIdx);
    }
}
