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
        TableRepository.tableUpdate(orderRequest.getTableNumber(),true);
    }

    public String getCalculateSummery() {
        /**
         *
         ## 주문 내역
         메뉴 수량 금액
         후라이드 1 16000
         콜라 1 1000

         */
        return "";
    }

    /**
     * 계산 걸려있는지
     * @param tableIdx
     */
    public void checkCalculateTableIdx(int tableIdx) {

    }

    public String pay(int payMethod, int tableIdx) {
        return "";
    }

    public String getOrderResult(int tableIdx) {
        return posService.orderResult(tableIdx);
    }
}
