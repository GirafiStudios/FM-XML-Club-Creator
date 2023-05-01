package com.girafi.clubcreator.typebuilder;

import com.girafi.clubcreator.ClubCreator;
import com.girafi.clubcreator.helper.Templates;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.cell;
import static com.girafi.clubcreator.helper.SheetHelper.cellNumber;

public class StadiumBuilder {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(3); //Stadiums Sheet

        //Clubs
        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    fileWriter.write(Templates.stadium(ClubCreator.START_STADIUM_UNIQUE_ID + row.getRowNum(), cell(row.getCell(0)), cell(row.getCell(1)), cellNumber(row.getCell(2)), cell(row.getCell(3)), cell(row.getCell(4)), cell(row.getCell(5)), cell(row.getCell(6)), cell(row.getCell(7)), cellNumber(row.getCell(8)), cell(row.getCell(9))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}