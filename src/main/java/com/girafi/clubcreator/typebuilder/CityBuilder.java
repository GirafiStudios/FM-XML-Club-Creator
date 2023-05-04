package com.girafi.clubcreator.typebuilder;

import com.girafi.clubcreator.ClubCreator;
import com.girafi.clubcreator.helper.Templates;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.*;

public class CityBuilder {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(2); //City Sheet

        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    fileWriter.write(Templates.city(ClubCreator.START_CITY_UNIQUE_ID + row.getRowNum(), cell(row.getCell(0)), cellNumber(row.getCell(1)), cellNumber(row.getCell(2)), cell(row.getCell(3)), cellDouble(row.getCell(4)), cellDouble(row.getCell(5)), cellNumber(row.getCell(6))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}