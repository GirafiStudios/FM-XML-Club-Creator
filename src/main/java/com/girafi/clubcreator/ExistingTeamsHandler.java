package com.girafi.clubcreator;

import com.girafi.clubcreator.helper.RegionalDivisionHelper;
import com.girafi.clubcreator.helper.Templates;
import com.girafi.clubcreator.helper.UtilityHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileWriter;
import java.io.IOException;

import static com.girafi.clubcreator.helper.SheetHelper.cell;
import static com.girafi.clubcreator.helper.SheetHelper.cellNumber;

public class ExistingTeamsHandler {

    public static void run(FileWriter fileWriter, Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(4); //Existing teams Sheet

        sheet.forEach(row -> {
            if (row.getRowNum() > 0) { //Ignore headers
                try {
                    int dbID = cellNumber(row.getCell(0));
                    String originalDivisionName = cell(row.getCell(2));
                    String originalLastDivisionName = cell(row.getCell(3));
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

                    //Add Danish Lower Division teams to correct divisions & last division
                    if (!divisionName.isEmpty()) {
                        fileWriter.write(division(dbID, divisionName, originalDivisionName));
                    }
                    if (!lastDivisionName.isEmpty()) {
                        fileWriter.write(lastDivision(dbID, lastDivisionName, originalLastDivisionName));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static String division(int dbID, String divisionName, String originalDivisionName) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;
        System.out.println("Division: " + divisionName);
        int divisionID = Templates.divIDMap.get(divisionName);

        return
                (originalDivisionName.equals("Danish Lower Division") ?
                        //Remove Division
                        "\t\t<record>\n" +
                                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbID + "\"/>\n" +
                                "\t\t\t<unsigned id=\"property\" value=\"1130657385\"/>\n" +
                                "\t\t\t<null id=\"new_value\"/>\n" +
                                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                                "\t\t</record>" +

                                //Division NOTE: Works, but does not show up under changes in Editor
                                "\t\t<record>\n" +
                                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbID + "\"/>\n" +
                                "\t\t\t<unsigned id=\"property\" value=\"1130657385\"/>\n" +
                                "\t\t\t<record id=\"new_value\">\n" +
                                "\t\t\t\t<integer id=\"competition\" value=\"" + divisionID + "\"/>\n" +
                                "\t\t\t</record>\n" +
                                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                                "\t\t</record>\n" : "");
    }

    public static String lastDivision(int dbID, String lastDivisionName, String originalLastDivisionName) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;
        System.out.println("Last Division: " + lastDivisionName);
        int lastDivisionID = Templates.divIDMap.get(lastDivisionName);

        return
                (originalLastDivisionName.equals("Danish Lower Division") ?
                        //Remove Last Division
                        "\t\t<record>\n" +
                                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbID + "\"/>\n" +
                                "\t\t\t<unsigned id=\"property\" value=\"1131177065\"/>\n" +
                                "\t\t\t<null id=\"new_value\"/>\n" +
                                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                                "\t\t</record>" +

                                //Last Division NOTE: Works, but does not show up under changes in Editor
                                "\t\t<record>\n" +
                                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbID + "\"/>\n" +
                                "\t\t\t<unsigned id=\"property\" value=\"1131177065\"/>\n" +
                                "\t\t\t<record id=\"new_value\">\n" +
                                "\t\t\t\t<integer id=\"competition\" value=\"" + lastDivisionID + "\"/>\n" +
                                "\t\t\t</record>\n" +
                                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                                "\t\t</record>" : "");
    }
}