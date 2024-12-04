package domain;

import java.util.List;
import java.util.Map;

public class Table {
    private final int number;
    private boolean isOrderExists;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isSame(int idx) {
        return number == idx;
    }

    public Integer getIdx() {
        return number;
    }

    public void setIsOrderExists(boolean isOrderExists) {
        this.isOrderExists = isOrderExists;
    }

    public boolean isExistsOrder() {
        return isOrderExists;
    }
}
