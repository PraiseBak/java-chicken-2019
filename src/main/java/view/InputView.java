package view;

import exception.PosException;
import java.util.Scanner;
import utility.NumberUtility;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_METHOD = "## 원하는 기능을 선택하세요.";
    private static final String INVALID_METHOD = "유효하지 않은 기능 선택입니다.";
    private static final String INVALID_TABLE_NUMBER = "유효하지 않은 테이블 숫자입니다.";
    private static final String INVALID_MENUS_IDX = "유효하지않은 메뉴 숫자입니다.";
    private static final String INPUT_MENUS_BUY = "## 메뉴의 수량을 입력하세요.";
    private static final String INVALID_MENUS_BUY = "유효하지않은 메뉴 수량입니다.";
    private static final int MAX_MENUS_BUY = 99;

    public static int inputTableNumber() {
        OutputView.printInputTableNumber();
        String tableNumber =readLine();
        if(!NumberUtility.isNumber(tableNumber)){
            throw new PosException(INVALID_TABLE_NUMBER);
        }
        return Integer.parseInt(readLine());
    }

    public static int inputMethod() {
        OutputView.println(INPUT_METHOD);
        String s = readLine();
        if(!NumberUtility.isNumber(s)){
            throw new PosException(INVALID_METHOD);
        }
        int num = Integer.parseInt(s);
        if(num >= 1 && num <= 3){
            return num;
        }
        throw new PosException(INVALID_METHOD);
    }

    public static int inputMenusBuy() {
        OutputView.println(INPUT_MENUS_BUY);
        String s = readLine();
        if(!NumberUtility.isNumber(s)){
            throw new PosException(INVALID_MENUS_BUY);
        }
        int num = Integer.parseInt(s);
        if(num > MAX_MENUS_BUY){
            throw new PosException(INVALID_MENUS_BUY);
        }
        return num;
    }


    private static String readLine() {
        return scanner.nextLine();
    }

    public static int inputMenusIdx() {
        OutputView.printMenusIdx();
        String s = readLine();
        if(!NumberUtility.isNumber(s)){
            throw new PosException(INVALID_MENUS_IDX);
        }
        return Integer.parseInt(s);
    }

    private static void validateMenusIdx() {

    }
}
