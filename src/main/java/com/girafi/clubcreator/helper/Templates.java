package com.girafi.clubcreator.helper;

import com.girafi.clubcreator.ClubCreator;
import org.apache.poi.xssf.usermodel.XSSFColor;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Templates {
    public static HashMap<String, Integer> parentCompIDMap = new HashMap<>();
    public static HashMap<String, Integer> divIDMap = new HashMap<>();
    public static HashMap<String, Integer> cityIDMap = new HashMap<>();
    public static HashMap<String, Integer> stadiumIDMap = new HashMap<>();
    public static HashMap<String, Integer> clubIDMap = new HashMap<>();

    //TODO Figure implement B-Teams/C-teams functionality fully
    public static String club(int dbUniqueID, String fullName, String shortName, String sixLetterName, String threeLetterName, String altTLN, int yearFounded, String city, String stadium, String rep, XSSFColor fgColorCell, XSSFColor bgColorCell, String division, String group, String lastDivision, String homeKitType, XSSFColor homeKitFG, XSSFColor homeKitBG, String awayKitType, XSSFColor awayKitFG, XSSFColor awayKitBG, String aTeam, String teamType) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;
        Color fgColor = UtilityHelper.toColor(fgColorCell);
        Color bgColor = UtilityHelper.toColor(bgColorCell);

        city = city.trim();
        stadium = stadium.trim();
        division = division.trim();
        lastDivision = lastDivision.trim();
        long cityID = UtilityHelper.isNumeric(city) ? Integer.parseInt(city) : cityIDMap.get(city);
        long stadiumID = UtilityHelper.isNumeric(stadium) ? Integer.parseInt(stadium) : stadiumIDMap.get(stadium);
        long divisionID = UtilityHelper.isNumeric(division) ? Integer.parseInt(division) : divIDMap.get(division);
        long divisionGroup = UtilityHelper.isNumeric(group) ? Integer.parseInt(group) : -1;
        long lastDivisionID = !lastDivision.isEmpty() ? (UtilityHelper.isNumeric(lastDivision) ? Integer.parseInt(lastDivision) : divIDMap.get(lastDivision)) : -1;

        clubIDMap.put(fullName, dbUniqueID);
        long aTeamID = -1;
        if (!aTeam.isEmpty()) {
            aTeamID = UtilityHelper.isNumeric(aTeam) ? Integer.parseInt(aTeam) : clubIDMap.get(aTeam);
        }


        //Correct name format after adding to map, as HashMaps does not like special letters
        fullName = new String(fullName.getBytes(StandardCharsets.UTF_8));
        shortName = new String(shortName.getBytes(StandardCharsets.UTF_8));
        sixLetterName = new String(sixLetterName.getBytes(StandardCharsets.UTF_8));
        threeLetterName = new String(threeLetterName.getBytes(StandardCharsets.UTF_8));
        altTLN = new String(altTLN.getBytes(StandardCharsets.UTF_8));

        return
                //Create new record (Same as clicking the "Add"-button in the editor
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"55\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + "4294967297" + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1094992978\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t\t<integer id=\"dcty\" value=\"0\"/>\n" +
                        "\t\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Full Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131307373\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + fullName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Short Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131638381\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + shortName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Six Letter Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131640942\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + sixLetterName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Three Letter Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131164526\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + threeLetterName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Alternative Three Letter Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130443630\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + altTLN + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Nation (Always Denmark)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131312233\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<large id=\"Nnat\" value=\"3281355014908\"/>\n" +
                        "\t\t\t\t<integer id=\"DBID\" value=\"764\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //City
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130591353\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"city\" value=\"" + cityID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Year Founded
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1132029550\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + yearFounded + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Reputation NOTE: Works, but does not show up under changes in Editor
                        (!rep.isEmpty() ? "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570544\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + rep + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"159837637\"/>\n" +
                        "\t\t</record>" : "") +

                        //Professional Status (Always Amateur) NOTE: Works, but does not show up under changes in Editor
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131442803\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"3\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>" +

                        //Foreground Color NOTE: Works, but does not show up under changes in Editor
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1953784684\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"" + fgColor.getRed() + "\" green=\"" + fgColor.getGreen() + "\" blue=\"" + fgColor.getBlue() + "\" alpha=\"" + fgColor.getAlpha() + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Background Color NOTE: Works, but does not show up under changes in Editor
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1952605036\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"" + bgColor.getRed() + "\" green=\"" + bgColor.getGreen() + "\" blue=\"" + bgColor.getBlue() + "\" alpha=\"" + bgColor.getAlpha() + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Division NOTE: Works, but does not show up under changes in Editor
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130657385\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"competition\" value=\"" + divisionID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Division Group
                        (divisionGroup != -1 ? "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668441972\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1768842863\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"1\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<record id=\"Ttea\">\n" +
                        "\t\t\t\t\t\t<large id=\"Ttea\" value=\"7323984393274656\"/>\n" +
                        "\t\t\t\t\t</record>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t\t<integer id=\"info\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<record id=\"nation\">\n" +
                        "\t\t\t\t\t\t<large id=\"Nnat\" value=\"3281355014908\"/>\n" +
                        "\t\t\t\t\t</record>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"3569\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"536047237\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"8590004438758183814\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668441972\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"2036687218\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"" + ClubCreator.START_YEAR + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<record id=\"Ttea\">\n" +
                        "\t\t\t\t\t\t<large id=\"Ttea\" value=\"7323984393274656\"/>\n" +
                        "\t\t\t\t\t</record>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t\t<integer id=\"info\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<record id=\"nation\">\n" +
                        "\t\t\t\t\t\t<large id=\"Nnat\" value=\"3281355014908\"/>\n" + //Always Denmark
                        "\t\t\t\t\t</record>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>" : "") +

                        //Last Division NOTE: Works, but does not show up under changes in Editor
                        (lastDivisionID != -1 ? //Allow for last division not being set
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131177065\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"competition\" value=\"" + lastDivisionID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>" : "" ) +

                        //Stadium
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131639913\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"stad\" value=\"" + stadiumID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Attendance (Just defaulted to this)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130460260\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"20\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131245153\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"10\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"582574739\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131247713\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"80\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Facilities (Defaulted all to 1)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131703414\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"694781365\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1132033142\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1132029538\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570018\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1132030317\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130587717\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>" +

                        RegionalDivisionHelper.selectRegionalDivision(dbUniqueID, division, true) +
                        (homeKitBG != null ? kit(dbUniqueID, homeKitType, homeKitFG, homeKitBG, awayKitType, awayKitFG, awayKitBG) : "" )
                ;
    }

    public static String comp(int dbUniqueID, String fullName, String shortName, String threeLetterName, String parent, int rep, int level) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;

        divIDMap.put(fullName, dbUniqueID);

        if (parent.equalsIgnoreCase("Parent")) {
            parentCompIDMap.put(fullName, dbUniqueID);
        }

        //Correct name format after adding to map, as HashMaps does not like special letters
        fullName = new String(fullName.getBytes(StandardCharsets.UTF_8));
        shortName = new String(shortName.getBytes(StandardCharsets.UTF_8));
        threeLetterName = new String(threeLetterName.getBytes(StandardCharsets.UTF_8));

        String compString =
                //New Comp
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"55\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"4294967297\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1094992978\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t\t<integer id=\"dcty\" value=\"0\"/>\n" +
                        "\t\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Full Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668178285\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + fullName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Short Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668509293\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + shortName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Three Letter Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1664314478\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + threeLetterName + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Colors (Defaulted to the same red/white always)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1667654508\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"248\" green=\"248\" blue=\"248\" alpha=\"255\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1667392364\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"208\" green=\"32\" blue=\"32\" alpha=\"255\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668572012\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"248\" green=\"248\" blue=\"248\" alpha=\"255\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Nation (Default to always be Denmark)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668183145\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<large id=\"Nnat\" value=\"3281355014908\"/>\n" +
                        "\t\t\t\t<integer id=\"DBID\" value=\"764\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Reputation
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668441456\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + rep + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Comp Type (Always default to Domestic Division)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1684173945\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Comp Level
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1818588780\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + level + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Uses Squad Numbers (Always the same)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668641646\"/>\n" +
                        "\t\t\t<boolean id=\"new_value\" value=\"true\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Pitch Requirements (Always the Same)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668116076\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"105.000000\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668116087\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"68.000000\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668118636\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"115.000000\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668118647\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"72.000000\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Winter Ball Color (Always the same)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"2002936684\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"248\" green=\"128\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"2002936684\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"248\" green=\"128\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Contract Types & Media Policies (Always the same)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694891\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694891\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694886\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694898\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694882\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694888\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694905\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692589\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692577\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"568772781\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692579\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692585\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692583\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692601\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348691046\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348695140\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692595\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348691041\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692068\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348692592\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348694899\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348691058\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348691058\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"2\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348890928\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349476912\"/>\n" +
                        "\t\t\t<boolean id=\"new_value\" value=\"true\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348564016\"/>\n" +
                        "\t\t\t<boolean id=\"new_value\" value=\"true\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349348912\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"-1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349351472\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"-1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348890929\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349476913\"/>\n" +
                        "\t\t\t<boolean id=\"new_value\" value=\"true\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1348564017\"/>\n" +
                        "\t\t\t<boolean id=\"new_value\" value=\"true\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349348913\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"-1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349351473\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"-1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1349351473\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"-1\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>";
        String parentString =
                //Parent Competition
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"25\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1668309869\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"competition\" value=\"" + (parent.equalsIgnoreCase("Parent") ? "" : parentCompIDMap.get(parent)) + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n";

        return compString + (parent.equalsIgnoreCase("Parent") ? "" : parentString);
    }

    public static String stadium(int dbUniqueID, String name, String city, String ownerType, double latitude, double longitude, int capacity, int seatCapacity, String pitchType, int pitchCondition, String pitchDetRate, int pitchRecRate, String stadiumCondition, String environment) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;

        long cityID = UtilityHelper.isNumeric(city) ? Integer.parseInt(city) : cityIDMap.get(city);

        name = name.trim();
        stadiumIDMap.put(name, dbUniqueID);
        name = new String(name.getBytes(StandardCharsets.UTF_8)); //Correct name format after adding to map, as HashMaps does not like special letters

        return
                //Stadium Add
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"55\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"4294967297\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1094992978\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t\t<integer id=\"dcty\" value=\"0\"/>\n" +
                        "\t\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399742829\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + name + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //City
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399026793\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"city\" value=\"" + cityID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Owner Type
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399813241\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + UtilityHelper.getStadiumOwnerType(ownerType) + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Seat Color (Just defaulted to whatever is set here)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1400071020\"/>\n" +
                        "\t\t\t<colour id=\"new_value\" red=\"224\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Is Training Ground (Always True)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399420007\"/>\n" +
                        "\t\t\t<boolean id=\"new_value\" value=\"true\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Capacity
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399025785\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + capacity + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Seating Capacity
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1400071033\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + seatCapacity + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>" +

                        //Expansion Capacity (Defaulted to 5000)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399153529\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"5000\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Pitch Type
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399878777\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + UtilityHelper.getPitchType(pitchType) + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Pitch Condition
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399878755\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + pitchCondition + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Pitch Deterioration
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399092338\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + UtilityHelper.getPitchDeterioration(pitchDetRate) + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Pitch Recovery Rate
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399878258\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + pitchRecRate + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Latitude
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399611764\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"" + latitude + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Longitude
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399615342\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"" + longitude + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Pitch Condition
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1400075365\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + UtilityHelper.getStadiumCondition(stadiumCondition) + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Environment
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"21\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1399156342\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + UtilityHelper.getStadiumEnvironment(environment) + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n"
                ;
    }

    public static String city(int dbUniqueID, String name, int regionID, int attraction, String inhabitants, double latitude, double longitude) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;
        int altitude = 2; //Setting default altitude to 2 meters, to save time on creating cities in spreadsheet

        name = name.trim();

        cityIDMap.put(name, dbUniqueID);
        name = new String(name.getBytes(StandardCharsets.UTF_8)); //Correct name format after adding to map, as HashMaps does not like special letters

        return
                //City Add
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"55\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"4294967297\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1094992978\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t\t<integer id=\"dcty\" value=\"0\"/>\n" +
                        "\t\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //City Name
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131307373\"/>\n" +
                        "\t\t\t<string id=\"new_value\" value=\"" + name + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Nation (Always Denmark)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131312233\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<large id=\"Nnat\" value=\"3281355014908\"/>\n" +
                        "\t\t\t\t<integer id=\"DBID\" value=\"764\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Local Region
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131180649\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lcrg\" value=\"" + regionID + "\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Attraction
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130460276\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + attraction + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Inhabitants Range
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130983016\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + UtilityHelper.getInhabitantsRage(inhabitants) + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Latitude
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131176308\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"" + latitude + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Longitude
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131179886\"/>\n" +
                        "\t\t\t<float id=\"new_value\" value=\"" + longitude + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Altitude
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1130458228\"/>\n" +
                        "\t\t\t<integer id=\"new_value\" value=\"" + altitude + "\"/>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Weather (Always Danish)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"2\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131898209\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<large id=\"wthr\" value=\"7310472426158294\"/>\n" +
                        "\t\t\t\t<integer id=\"DBID\" value=\"1702102\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n"
                ;
    }

    public static String kit(int dbUniqueID, String homeKitType, XSSFColor homeKitFG, XSSFColor homeKitBG, String awayKitType, XSSFColor awayKitFG, XSSFColor awayKitBG) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;

        Color homeKitFGColor = UtilityHelper.toColor(homeKitFG);
        Color homeKitBGColor = UtilityHelper.toColor(homeKitBG);
        Color homeKitText = UtilityHelper.textColor(homeKitFGColor, homeKitBGColor, homeKitFGColor);
        Color homeKitIcon= UtilityHelper.textColor(homeKitFGColor, homeKitBGColor, Color.WHITE);
        Color awayKitFGColor = UtilityHelper.toColor(awayKitFG);
        Color awayKitBGColor = UtilityHelper.toColor(awayKitBG);
        Color awayKitText = UtilityHelper.textColor(awayKitFGColor, awayKitBGColor, awayKitFGColor);
        Color awayKitIcon = UtilityHelper.textColor(awayKitFGColor, awayKitBGColor, Color.WHITE);

        return
                //Home Start\\
                //Delete Default Home Kit (DO NOT CHANGE)
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Shirt Add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Shirt Type
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802073203\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"" + homeKitType +"\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Shirt Foreground
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802724967\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitFGColor.getRed() + "\" green=\"" + homeKitFGColor.getGreen() + "\" blue=\"" + homeKitFGColor.getBlue() + "\" alpha=\"" + homeKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + homeKitType + "\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Shirt Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + homeKitType + "\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + homeKitFGColor.getRed() + "\" green=\"" + homeKitFGColor.getGreen() + "\" blue=\"" + homeKitFGColor.getBlue() + "\" alpha=\"" + homeKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Shirt Outline
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + homeKitType +"\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + homeKitFGColor.getRed() + "\" green=\"" + homeKitFGColor.getGreen() + "\" blue=\"" + homeKitFGColor.getBlue() + "\" alpha=\"" + homeKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852665699\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + homeKitType + "\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + homeKitFGColor.getRed() + "\" green=\"" + homeKitFGColor.getGreen() + "\" blue=\"" + homeKitFGColor.getBlue() + "\" alpha=\"" + homeKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Shorts Add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Shorts Type (Always the same)
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"4\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Shorts Foreground Color (Always Black)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802724967\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Short Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Shorts Outline
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Shorts Number Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852662636\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"245\" green=\"245\" blue=\"245\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +

                        //Home Shorts Number Color Outline
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852665699\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"245\" green=\"245\" blue=\"245\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Socks Add
                       "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Socks Type (Always Same Type)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        
                        //Home Socks Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitBGColor.getRed() + "\" green=\"" + homeKitBGColor.getGreen() + "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Icon Add
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Icon Type??
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"2\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Icon Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitBGColor.getRed() + "\" green=\""  + homeKitBGColor.getGreen() +  "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Icon Foreground Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitFGColor.getRed() + "\" green=\"" + homeKitFGColor.getGreen() + "\" blue=\"" + homeKitFGColor.getBlue() + "\" alpha=\"" + homeKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\""  + homeKitBGColor.getGreen() +  "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Icon Number Color (Defaults to white, unless background and foreground color is the same)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852662636\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitIcon.getRed() + "\" green=\"" + homeKitIcon.getGreen() + "\" blue=\"" + homeKitIcon.getBlue() + "\" alpha=\"" + homeKitIcon.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\""  + homeKitBGColor.getGreen() +  "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"" + homeKitFGColor.getRed() + "\" green=\"" + homeKitFGColor.getGreen() + "\" blue=\"" + homeKitFGColor.getBlue() + "\" alpha=\"" + homeKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Home Text Add
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Text Type???
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"3\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Text Foreground Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802724967\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitText.getRed() + "\" green=\"" + homeKitText.getGreen() + "\" blue=\"" + homeKitText.getBlue() + "\" alpha=\"" + homeKitText.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Text Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + homeKitBGColor.getRed() + "\" green=\""  + homeKitBGColor.getGreen() +  "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + homeKitText.getRed() + "\" green=\"" + homeKitText.getGreen() + "\" blue=\"" + homeKitText.getBlue() + "\" alpha=\"" + homeKitText.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Home Text Logo Outline (Always Black)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326961\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + homeKitText.getRed() + "\" green=\"" + homeKitText.getGreen() + "\" blue=\"" + homeKitText.getBlue() + "\" alpha=\"" + homeKitText.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + homeKitBGColor.getRed() + "\" green=\""  + homeKitBGColor.getGreen() +  "\" blue=\"" + homeKitBGColor.getBlue() + "\" alpha=\"" + homeKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Start\\
                        //Delete Default Away Kit (DO NOT CHANGE)
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"255\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"255\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"255\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"255\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"2\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"255\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Shirt Add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Shirt Type
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802073203\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"" + awayKitType +"\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Shirt Foreground
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802724967\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitFGColor.getRed() + "\" green=\"" + awayKitFGColor.getGreen() + "\" blue=\"" + awayKitFGColor.getBlue() + "\" alpha=\"" + awayKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + awayKitType + "\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Shirt Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + awayKitType + "\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + awayKitFGColor.getRed() + "\" green=\"" + awayKitFGColor.getGreen() + "\" blue=\"" + awayKitFGColor.getBlue() + "\" alpha=\"" + awayKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Shirt Outline
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + awayKitType +"\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + awayKitFGColor.getRed() + "\" green=\"" + awayKitFGColor.getGreen() + "\" blue=\"" + awayKitFGColor.getBlue() + "\" alpha=\"" + awayKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852665699\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"" + awayKitType + "\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + awayKitFGColor.getRed() + "\" green=\"" + awayKitFGColor.getGreen() + "\" blue=\"" + awayKitFGColor.getBlue() + "\" alpha=\"" + awayKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Shorts Add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Shorts Type (Always the same)
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"4\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Shorts Foreground Color (Always Black)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802724967\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Short Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Shorts Outline
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Shorts Number Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852662636\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"245\" green=\"245\" blue=\"245\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +

                        //Away Shorts Number Color Outline
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852665699\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"4\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"245\" green=\"245\" blue=\"245\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Socks Add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Socks Type (Always Same Type)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Socks Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitBGColor.getRed() + "\" green=\"" + awayKitBGColor.getGreen() + "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Icon Add
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Icon Type??
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"2\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Icon Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitBGColor.getRed() + "\" green=\""  + awayKitBGColor.getGreen() +  "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Icon Foreground Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitFGColor.getRed() + "\" green=\"" + awayKitFGColor.getGreen() + "\" blue=\"" + awayKitFGColor.getBlue() + "\" alpha=\"" + awayKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\""  + awayKitBGColor.getGreen() +  "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Icon Number Color (Defaults to white, unless background and foreground color is the same)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1852662636\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitIcon.getRed() + "\" green=\"" + awayKitIcon.getGreen() + "\" blue=\"" + awayKitIcon.getBlue() + "\" alpha=\"" + awayKitIcon.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"2\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\""  + awayKitBGColor.getGreen() +  "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"" + awayKitFGColor.getRed() + "\" green=\"" + awayKitFGColor.getGreen() + "\" blue=\"" + awayKitFGColor.getBlue() + "\" alpha=\"" + awayKitFGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>" +

                        //Away Text Add
                        "\t\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Text Type???
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802793074\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"3\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Text Foreground Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802724967\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitText.getRed() + "\" green=\"" + awayKitText.getGreen() + "\" blue=\"" + awayKitText.getBlue() + "\" alpha=\"" + awayKitText.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Text Background Color
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802723943\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"" + awayKitBGColor.getRed() + "\" green=\""  + awayKitBGColor.getGreen() +  "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + awayKitText.getRed() + "\" green=\"" + awayKitText.getGreen() + "\" blue=\"" + awayKitText.getBlue() + "\" alpha=\"" + awayKitText.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>\n" +

                        //Away Text Logo Outline (Always Black)
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1416326962\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1802727285\"/>\n" +
                        "\t\t\t\t<colour id=\"value\" red=\"0\" green=\"0\" blue=\"0\" alpha=\"255\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<integer id=\"kits\" value=\"1\"/>\n" +
                        "\t\t\t\t\t<integer id=\"bost\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<integer id=\"kit_part\" value=\"3\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksfg\" red=\"" + awayKitText.getRed() + "\" green=\"" + awayKitText.getGreen() + "\" blue=\"" + awayKitText.getBlue() + "\" alpha=\"" + awayKitText.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksbg\" red=\"" + awayKitBGColor.getRed() + "\" green=\""  + awayKitBGColor.getGreen() +  "\" blue=\"" + awayKitBGColor.getBlue() + "\" alpha=\"" + awayKitBGColor.getAlpha() + "\"/>\n" +
                        "\t\t\t\t\t<colour id=\"ksou\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmcl\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<colour id=\"nmoc\" red=\"255\" green=\"255\" blue=\"255\" alpha=\"255\"/>\n" +
                        "\t\t\t\t\t<integer id=\"ktal\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                        "\t\t</record>"
                ;
    }

    public static String startTemplate() {
        return "<record>\n" +
                "\t<list id=\"verf\"/>\n" +
                "\t<list id=\"db_changes\">\n";
    }

    public static String endTemplate() {
        return "\t</list>\n" +
                "\t<integer id=\"version\" value=\"" + ClubCreator.FM_XML_ID_VERSION + "\"/>\n" +
                "\t<integer id=\"rule_group_version\" value=\"1503\"/>\n" +
                "\t<boolean id=\"beta\" value=\"false\"/>\n" +
                "\t<string id=\"orvs\" value=\"2340\"/>\n" +
                "\t<string id=\"svvs\" value=\"2340\"/>\n" +
                "</record>";
    }
}