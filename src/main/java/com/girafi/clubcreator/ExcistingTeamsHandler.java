package com.girafi.clubcreator;

import com.girafi.clubcreator.helper.RegionalDivisionHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.cell;
import static com.girafi.clubcreator.helper.SheetHelper.cellNumber;

public class ExcistingTeamsHandler {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(4); //Existing teams Sheet

        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    int dbID = cellNumber(row.getCell(0));
                    String originalDivisionName = cell(row.getCell(2));
                    String divisionName = cell(row.getCell(4));
                    String lastDivisionName = cell(row.getCell(5));
                    String regionalDivision = cell(row.getCell(6));

                    //Handle regional divisions
                    if (!regionalDivision.isEmpty()) {
                        fileWriter.write(RegionalDivisionHelper.selectRegionalDivision(dbID, regionalDivision, false));
                    } else if (!divisionName.isEmpty()) {
                        fileWriter.write(RegionalDivisionHelper.selectRegionalDivision(dbID, divisionName, false)); //Regional Divisions, for teams in Danish Lower Division by default
                    } else {
                        fileWriter.write(RegionalDivisionHelper.selectRegionalDivision(dbID, originalDivisionName, false)); //Regional Divisions based on default divisions
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static String division(int dbID, String divisionName, String lastDivisionName, String regionalDivision) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;

        return "";
    }
}