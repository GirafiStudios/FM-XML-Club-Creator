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
                    fileWriter.write(Templates.club(ClubCreator.START_CLUB_UNIQUE_ID + row.getRowNum(),
                            cell(row.getCell(0)), //Full Name
                            cell(row.getCell(1)), //Short Name
                            cell(row.getCell(2)), //6-Letter Name
                            cell(row.getCell(3)), //3-Letter Name
                            cell(row.getCell(4)), //Alt 3-Letter Name
                            cellNumber(row.getCell(5)), //Year Founded
                            cell(row.getCell(6)),  //City Name/ID
                            cell(row.getCell(7)),  //Stadium Name/ID
                            cell(row.getCell(8)),  //Reputation
                            hexColorBG(row.getCell(9)), //Titlebar Color FG
                            hexColorBG(row.getCell(10)), //Titlebar Color BG
                            cell(row.getCell(11)), //Division Name/ID
                            cell(row.getCell(12)), //Last Division Name/ID
                            cell(row.getCell(13)), //Home Kit Type
                            hexColorBG(row.getCell(14)), //Home Kit FG Color
                            hexColorBG(row.getCell(15)), //Home Kit BG Color
                            cell(row.getCell(16)), //Away Kit Type
                            hexColorBG(row.getCell(17)), //Away Kit FG Color
                            hexColorBG(row.getCell(18)), //Away Kit BG Color
                            cell(row.getCell(19)), //A-Team Name/ID (For reserve teams only)
                            cell(row.getCell(20)))); //Reserve Team Type (For reserve teams only
                } catch (Exception e) {
                    System.out.println("Club creation failed for: " + cell(row.getCell(1)));
                    throw new RuntimeException(e);
                }
            }
        });
    }
}