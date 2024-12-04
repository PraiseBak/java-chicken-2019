package dto;

public class OrderRequest {
    public int getTableNumber() {
        return tableNumber;
    }

    public int getMenusIdx() {
        return menusIdx;
    }

    public int getMenusBuy() {
        return menusBuy;
    }

    private final int tableNumber;
    private final int menusIdx;
    private final int menusBuy;

    public OrderRequest(int tableNumber, int menusIdx, int menusBuy) {
        this.tableNumber = tableNumber;
        this.menusIdx = menusIdx;
        this.menusBuy = menusBuy;
    }
}
