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
                    fileWriter.write(Templates.stadium(
                            ClubCreator.START_STADIUM_UNIQUE_ID + row.getRowNum(),
                            cell(row.getCell(0)), //Name
                            cell(row.getCell(1)), //City Name/ID
                            cell(row.getCell(2)), //Owner Type
                            cellDouble(row.getCell(3)), //Latitude
                            cellDouble(row.getCell(4)), //Longitude
                            cellNumber(row.getCell(5)), //Capacity
                            cellNumber(row.getCell(6)), //Seat Capacity
                            cell(row.getCell(7)), //Pitch Type
                            cellNumber(row.getCell(8)), //Pitch Condition
                            cell(row.getCell(9)), //Pitch Deterioration Rate
                            cellNumber(row.getCell(10)), //Pitch Recovery Rate
                            cell(row.getCell(11)), //Stadium Condition
                            cell(row.getCell(12)))); //Environment
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}