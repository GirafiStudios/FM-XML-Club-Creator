package com.girafi.clubcreator.types;

import com.girafi.clubcreator.ClubCreator;
import com.girafi.clubcreator.helper.Templates;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.cell;

public class ClubBuilder {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(0);

        //Clubs
        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    fileWriter.write(Templates.club(ClubCreator.START_CLUB_UNIQUE_ID + row.getRowNum(), cell(row.getCell(0)), cell(row.getCell(1)), cell(row.getCell(2)), cell(row.getCell(3)), cell(row.getCell(4)), cell(row.getCell(5)), cell(row.getCell(6)), cell(row.getCell(7)), cell(row.getCell(8)), cell(row.getCell(9)), cell(row.getCell(10)), cell(row.getCell(11))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}