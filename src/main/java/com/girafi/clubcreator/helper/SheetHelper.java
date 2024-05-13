package com.girafi.clubcreator.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFColor;

public class SheetHelper {

    public static String cell(Cell cell) {
        try {
            return cell.toString();
        } catch (Exception e) {
            System.out.println("Crashed at Cell - Column: " + cell.getColumnIndex() + " - Row: " + cell.getRowIndex());
            throw new RuntimeException(e);
        }
    }

    public static int cellNumber(Cell cell) {
        try {
            return (int) cellDouble(cell);
        } catch (Exception e) {
            System.out.println("Crashed at Cell - Column: " + cell.getColumnIndex() + " - Row: " + cell.getRowIndex());
            throw new RuntimeException(e);
        }
    }

    public static double cellDouble(Cell cell) {
        try {
            return cell.getNumericCellValue();
        } catch (Exception e) {
            System.out.println("Crashed at Cell - Column: " + cell.getColumnIndex() + " - Row: " + cell.getRowIndex());
            throw new RuntimeException(e);
        }
    }

    public static XSSFColor hexColorBG(Cell cell) {
        try {
            return (XSSFColor) cell.getCellStyle().getFillForegroundColorColor();
        } catch (Exception e) {
            System.out.println("Crashed at Cell - Column: " + cell.getColumnIndex() + " - Row: " + cell.getRowIndex());
            throw new RuntimeException(e);
        }
    }
}