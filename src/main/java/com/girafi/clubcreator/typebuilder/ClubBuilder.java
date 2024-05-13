package com.girafi.clubcreator.typebuilder;

import com.girafi.clubcreator.ClubCreator;
import com.girafi.clubcreator.helper.Templates;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.*;

public class ClubBuilder {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(0); //Clubs Sheet

        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    fileWriter.write(Templates.club(ClubCreator.START_CLUB_UNIQUE_ID + row.getRowNum(), cell(row.getCell(0)), cell(row.getCell(1)), cell(row.getCell(2)), cell(row.getCell(3)), cell(row.getCell(4)), cellNumber(row.getCell(5)), cell(row.getCell(6)), cell(row.getCell(7)), cell(row.getCell(8)), hexColorBG(row.getCell(9)), hexColorBG(row.getCell(10)), cell(row.getCell(11)), cell(row.getCell(12)), cell(row.getCell(13)), hexColorBG(row.getCell(14)), hexColorBG(row.getCell(15)), cell(row.getCell(16)), hexColorBG(row.getCell(17)), hexColorBG(row.getCell(18)), cell(row.getCell(19)), cell(row.getCell(20))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}