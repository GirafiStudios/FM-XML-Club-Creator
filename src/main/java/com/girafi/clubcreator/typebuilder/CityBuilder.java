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
                    fileWriter.write(Templates.city(
                            ClubCreator.START_CITY_UNIQUE_ID + row.getRowNum(),
                            cell(row.getCell(0)), //Name
                            cellNumber(row.getCell(1)), //Region ID
                            cellNumber(row.getCell(2)), //Attraction (Number)
                            cell(row.getCell(3)), //Inhabitants Range
                            cellDouble(row.getCell(4)), //Latitude
                            cellDouble(row.getCell(5)))); //Longitude
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}