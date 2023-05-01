package com.girafi.clubcreator.helper;

import org.apache.poi.ss.usermodel.Cell;

public class SheetHelper {

    public static String cell(Cell cell) {
        return cell.toString();
    }

    public static int cellNumber(Cell cell) {
        return (int) cellDouble(cell);
    }

    public static double cellDouble(Cell cell) {
        return cell.getNumericCellValue();
    }
}