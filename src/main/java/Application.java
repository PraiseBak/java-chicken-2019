import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import dto.OrderRequest;
import exception.PosException;
import repository.PosRepository;
import service.PosService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private final static PosController posController = new PosController(new PosService(new PosRepository()));
    public static void main(String[] args) {
        boolean isEnd = false;
        while (!isEnd){
            int method = selectMethod();
            isEnd = doMethod(method);
        }
    }

    private static boolean doMethod(int method) {
        if (method == 1) {
            registerOrder();
            return false;
        }
        if(method == 2){
            calculate();
            return false;
        }
        return true;
    }

    private static void calculate() {
        int tableIdx = calculateSummery();
        pay(tableIdx);
    }

    private static void pay(int tableIdx) {
        while (true){
            try {
                int payMethod = InputView.inputPayMethod(tableIdx);
                String payResult = posController.pay(payMethod,tableIdx);
                OutputView.println(payResult);
                return;
            }catch (PosException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static int calculateSummery() {
        while (true){
            try {
                int tableIdx = selectTable();
                posController.checkCalculateTableIdx(tableIdx);
                calculateSummery(tableIdx);
                return tableIdx;
            }catch (PosException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void calculateSummery(int tableIdx) {
        OutputView.println(posController.getCalculateSummery());
    }

    /**
     * 구조를 menus를 서버에서 가져와서 처리한다?
     */
    private static void registerOrder() {
        int tableNumber = selectTable();
        int menusIdx = selectMenu();
        int menusBuy = selectMenusBuy();
        orderRequest(new OrderRequest(tableNumber,menusIdx,menusBuy));
    }

    private static void orderRequest(OrderRequest orderRequest) {
        posController.orderRequest(orderRequest);
    }

    private static int selectMenusBuy() {
        while (true){
            try {
                return InputView.inputMenusBuy();
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }


    private static int selectMethod() {
        while (true){
            try {
                return InputView.inputMethod();
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static int selectMenu() {
        while (true){
            try {
                final List<Menu> menus = MenuRepository.menus();
                OutputView.printMenus(menus);
                final int menusIdx = InputView.inputMenusIdx();
                posController.checkMenusIdx();
                return menusIdx;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static int selectTable() {
        while (true){
            try {
                final List<Table> tables = TableRepository.tables();
                OutputView.printTables(tables);
                int tableNumber = InputView.inputTableNumber();
                posController.checkTableIdx(tableNumber);
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());

            }
        }
    }
}