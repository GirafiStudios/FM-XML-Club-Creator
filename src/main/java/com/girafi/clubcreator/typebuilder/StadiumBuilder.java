package com.girafi.clubcreator.typebuilder;

import com.girafi.clubcreator.ClubCreator;
import com.girafi.clubcreator.helper.Templates;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.*;

public class StadiumBuilder {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(3); //Stadiums Sheet

        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    fileWriter.write(Templates.stadium(ClubCreator.START_STADIUM_UNIQUE_ID + row.getRowNum(), cell(row.getCell(0)), cell(row.getCell(1)), cell(row.getCell(2)), cellDouble(row.getCell(3)), cellDouble(row.getCell(4)), cellNumber(row.getCell(5)), cellNumber(row.getCell(6)), cell(row.getCell(7)), cellNumber(row.getCell(8)), cell(row.getCell(9)), cellNumber(row.getCell(10)), cell(row.getCell(11)), cell(row.getCell(12))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}