package com.girafi.clubcreator.helper;

import com.girafi.clubcreator.ClubCreator;
import com.girafi.clubcreator.types.ClubBuilder;
import com.girafi.clubcreator.helper.UtilityHelper;

import java.awt.*;

import static com.girafi.clubcreator.helper.PrintHelper.print;

public class Templates {

    //TODO Kits
    //TODO Stadiums
    //TODO Regional Divisions
    public static String clubDetails(long dbUniqueID, String fullName, String shortName, String sixLetterName, String threeLetterName, String altTLN, String yearFounded, String cityID, String rep, String bgCHex, String fgCHex) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;
        Color fgColor = Color.decode(fgCHex);
        Color bgColor = Color.decode(bgCHex);

        return
                //Create new record (Same as clicking the "Add"-button in the editor
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"55\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"-1\"/>\n" + //TODO Does the -1 work?
                "\t\t\t<unsigned id=\"property\" value=\"1094992978\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t\t<integer id=\"dcty\" value=\"0\"/>\n" +
                "\t\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t</record>\n" +

                 //Short Name
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131638381\"/>\n" +
                "\t\t\t<string id=\"new_value\" value=\"" + shortName + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t\t<string id=\"odvl\" value=\"\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                "\t\t</record>\n" +

                 //Full Name
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131307373\"/>\n" +
                "\t\t\t<string id=\"new_value\" value=\"" + fullName + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t\t<string id=\"odvl\" value=\"Slangerup &amp; Omegn IF\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                "\t\t</record>\n" +

                 //Six Letter Name
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131640942\"/>\n" +
                "\t\t\t<string id=\"new_value\" value=\"" + sixLetterName + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t\t<string id=\"odvl\" value=\"\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                "\t\t</record>\n" +

                 //Three Letter Name
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131164526\"/>\n" +
                "\t\t\t<string id=\"new_value\" value=\"" + threeLetterName + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t\t<string id=\"odvl\" value=\"\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                "\t\t</record>\n" +

                 //Alternative Three Letter Name
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID +"\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1130443630\"/>\n" +
                "\t\t\t<string id=\"new_value\" value=\"" + altTLN + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t\t<string id=\"odvl\" value=\"\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t\t<boolean id=\"is_language_field\" value=\"true\"/>\n" +
                "\t\t</record>" +

                //Nation (Always Denmark)
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131312233\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<large id=\"Nnat\" value=\"3281355014908\"/>\n" +
                "\t\t\t\t<integer id=\"DBID\" value=\"764\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"458086919\"/>\n" +
                "\t\t\t<record id=\"odvl\">\n" +
                "\t\t\t\t<large id=\"Nnat\" value=\"21474836485\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t</record>" +

                //City
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1130591353\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<large id=\"city\" value=\"4034146817955081\"/>\n" +
                "\t\t\t\t<integer id=\"DBID\" value=\"" + cityID +"\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"577833981\"/>\n" +
                "\t\t\t<null id=\"odvl\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t</record>" +

                //Year Founded
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1132029550\"/>\n" +
                "\t\t\t<integer id=\"new_value\" value=\"" + yearFounded + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"476537685\"/>\n" +
                "\t\t\t<null id=\"odvl\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t</record>" +

                //Reputation
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570544\"/>\n" +
                "\t\t\t<integer id=\"new_value\" value=\"" + rep + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"159837637\"/>\n" +
                "\t\t\t<integer id=\"odvl\" value=\"1000\"/>\n" +
                "\t\t</record>" +

                //Professional Status (Always Amateur) //TODO Test
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131442803\"/>\n" +
                "\t\t\t<integer id=\"new_value\" value=\"3\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"430289970\"/>\n" +
                "\t\t\t<integer id=\"odvl\" value=\"1\"/>\n" +
                "\t\t</record>" +

                //Background Color
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1953784684\"/>\n" +
                "\t\t\t<colour id=\"new_value\" red=\"" + bgColor.getRed() +"\" green=\"" + bgColor.getGreen() +"\" blue=\"" + bgColor.getBlue() + "\" alpha=\"" + bgColor.getAlpha() + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"252405830\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t</record>\n" +

                //Foreground Color
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1952605036\"/>\n" +
                "\t\t\t<colour id=\"new_value\" red=\"" + fgColor.getRed() +"\" green=\"" + fgColor.getGreen() +"\" blue=\"" + fgColor.getBlue() + "\" alpha=\"" + fgColor.getAlpha() + "\"/>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"902372646\"/>\n" +
                "\t\t\t<boolean id=\"is_client_field\" value=\"true\"/>\n" +
                "\t\t</record>" +

                //Division //Todo Test if this is Division or last division
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1130657385\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<large id=\"competition\" value=\"4004816486283868\"/>\n" +
                "\t\t\t\t<integer id=\"DBID\" value=\"2000170401\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"829117994\"/>\n" +
                "\t\t\t<null id=\"odvl\"/>\n" +
                "\t\t</record>\n" +

                //Last Division
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"3554037138238036579\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131177065\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<large id=\"competition\" value=\"4004816486283868\"/>\n" +
                "\t\t\t\t<integer id=\"DBID\" value=\"932444\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"3509\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"891713430\"/>\n" +
                "\t\t\t<null id=\"odvl\"/>\n" +
                "\t\t</record>"
                ;
    }

    public static String startTemplate() {
        return  "<record>\n" +
                "\t<list id=\"verf\"/>\n" +
                "\t<integer id=\"XSvC\" value=\"1\"/>\n" +
                "\t<string id=\"EdBr\" value=\"main\"/>\n" +
                "\t<date id=\"EdDt\" day=\"30\" month=\"4\" year=\"2023\" time=\"1630\"/>\n" +
                "\t<list id=\"db_changes\">\n";
    }

    public static String endTemplate() {
        return  "\t</list>\n" +
                "\t<integer id=\"version\" value=\"" + ClubCreator.FM_XML_ID_VERSION + "\"/>\n" +
                "\t<integer id=\"rule_group_version\" value=\"1503\"/>\n" +
                "\t<boolean id=\"beta\" value=\"false\"/>\n" +
                "\t<string id=\"orvs\" value=\"2340\"/>\n" +
                "\t<string id=\"svvs\" value=\"2340\"/>\n" +
                "</record>";
    }
}
