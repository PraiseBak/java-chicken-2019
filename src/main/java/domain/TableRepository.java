package domain;

import exception.PosException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static final String INVALID_TABLE_INDEX = "유효하지 않은 테이블 인덱스입니다.";

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void tableUpdate(int tableIdx,boolean isOrderExists){
        for(Table table : tables){
            if(table.isSame(tableIdx)){
                table.setIsOrderExists(isOrderExists);
                return;
            }
        }
    }

    public static void validateTable(int idx){
        for(Table table : tables){
            if(table.isSame(idx)){
                return;
            }
        }
        throw new PosException(INVALID_TABLE_INDEX);
    }

    public static boolean isExists(int tableIdx) {
        for(Table table : tables){
            if(table.isSame(tableIdx)){
                return true;
            }
        }
        return false;
    }
}
