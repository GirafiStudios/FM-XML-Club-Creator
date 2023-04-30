package com.girafi.clubcreator;

import com.girafi.clubcreator.types.ClubBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ClubCreator {
    public static final String EXCEL_INPUT = "./clubs.xlsx";
    public static final int FM_XML_ID_VERSION = 3509;

    public static void main(String[] args) {
        try {
            Workbook workbook = WorkbookFactory.create(new File(EXCEL_INPUT));

            ClubBuilder.run(workbook);

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}