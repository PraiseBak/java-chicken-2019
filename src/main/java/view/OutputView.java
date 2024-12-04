package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {


    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String INPUT_TABLE_NUMBER = "## 주문할 테이블을 선택하세요.";
    private static final String INPUT_MENUS_IDX = "## 등록할 메뉴를 선택하세요.";
    private static String INPUT_PAY_METHOD = "## %d번 테이블의 결제를 진행합니다.\n## 신용 카드는 1번, 현금은 2번";


    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printError(String message) {
        println(ERROR_PREFIX + message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printInputTableNumber() {
        println(INPUT_TABLE_NUMBER);
    }

    public static void printMenusIdx() {
        println(INPUT_MENUS_IDX);

    }

    public static void printPayMethod(int tableIdx) {
        println(String.format(INPUT_PAY_METHOD,tableIdx));

    }
}
