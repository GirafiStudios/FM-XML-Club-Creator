package com.girafi.clubcreator.helper;

import com.girafi.clubcreator.ClubCreator;

public class RegionalDivisionHelper {

    public static String selectRegionalDivision(int dbUniqueID, String comp) {
        int fmxmlIDVersion = ClubCreator.FM_XML_ID_VERSION;

        if (comp.contains("Bornholm")) {
            return bornholm(dbUniqueID, fmxmlIDVersion);
        } else if (comp.contains("Copenhagen")) {
            return copenhagen(dbUniqueID, fmxmlIDVersion);
        } else if (comp.contains("Zealand")) {
            return zealand(dbUniqueID, fmxmlIDVersion);
        } else if (comp.contains("Lolland-Falster")) {
            return lollandFalster(dbUniqueID, fmxmlIDVersion);
        } else if (comp.contains("Funen")) {
            return funen(dbUniqueID, fmxmlIDVersion);
        } else if (comp.contains("Jutland")) {
            return jutland(dbUniqueID, fmxmlIDVersion);
        }
        return "";
    }

    public static String copenhagen(int dbUniqueID, int fmxmlIDVersion) {
        return copenhagenBase(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Copenhagen, Series 1 Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"7\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Copenhagen, Series 1
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<integer id=\"competition\" value=\"" + Templates.divIDMap.get("Copenhagen, Series 1") + "\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"7\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>"
                ;
    }

    public static String bornholm(int dbUniqueID, int fmxmlIDVersion) {
        return copenhagenBase(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Bornholmsserien Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"7\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Bornholmsserien
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<integer id=\"competition\" value=\"" + Templates.divIDMap.get("Bornholmsserien") + "\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"7\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>"
                ;
    }

    public static String zealand(int dbUniqueID, int fmxmlIDVersion) {
        return zealandBase(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Zealand, Series 1 Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"7\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Zealand, Series 1
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<integer id=\"competition\" value=\"" + Templates.divIDMap.get("Zealand, Series 1") + "\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"7\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>"
                ;
    }

    public static String lollandFalster(int dbUniqueID, int fmxmlIDVersion) {
        return zealandBase(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Lolland-Falsterserien Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"7\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Lolland-Falsterserien
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<integer id=\"competition\" value=\"" + Templates.divIDMap.get("Lolland-Falsterserien") + "\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"7\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>"
                ;
    }

    public static String funen(int dbUniqueID, int fmxmlIDVersion) {
        return ds3Ds4(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Funen Series level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"6\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Funen Series
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<large id=\"competition\" value=\"8590666465017343394\"/>\n" +
                "\t\t\t\t\t<integer id=\"DBID\" value=\"2000170402\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"6\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>" +

                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Funen, Series 1 Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"7\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Funen, Series 1
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<integer id=\"competition\" value=\"" + Templates.divIDMap.get("Funen, Series 1") + "\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"7\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>";
    }

    public static String jutland(int dbUniqueID, int fmxmlIDVersion) {
        return ds4Ds3(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Jutland Series level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"6\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Jutland Series
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<large id=\"competition\" value=\"8590666469312310691\"/>\n" +
                "\t\t\t\t\t<integer id=\"DBID\" value=\"2000170403\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"6\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>" +

                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Jutland, Series 1 Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"7\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Jutland, Series 1
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<integer id=\"competition\" value=\"" + Templates.divIDMap.get("Jutland, Series 1") + "\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"7\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>";
    }

    public static String copenhagenBase(int dbUniqueID, int fmxmlIDVersion) {
        return ds1Ds2(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add        
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Copenhagen Series Level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"6\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Copenhagen Series
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<large id=\"competition\" value=\"8590666456427408800\"/>\n" +
                "\t\t\t\t\t<integer id=\"DBID\" value=\"2000170400\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"6\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>";
    }

    public static String zealandBase(int dbUniqueID, int fmxmlIDVersion) {
        return ds1Ds2(dbUniqueID, fmxmlIDVersion) +
                //Regional Division add
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Zealand Series level
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                "\t\t\t\t<integer id=\"value\" value=\"6\"/>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>\n" +

                //Zealand Series
                "\t\t<record>\n" +
                "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                "\t\t\t<record id=\"new_value\">\n" +
                "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                "\t\t\t\t<record id=\"value\">\n" +
                "\t\t\t\t\t<large id=\"competition\" value=\"8590666460722376097\"/>\n" +
                "\t\t\t\t\t<integer id=\"DBID\" value=\"2000170401\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                "\t\t\t\t<record id=\"olvl\">\n" +
                "\t\t\t\t\t<null id=\"competition\"/>\n" +
                "\t\t\t\t\t<integer id=\"leve\" value=\"6\"/>\n" +
                "\t\t\t\t\t<null id=\"year\"/>\n" +
                "\t\t\t\t</record>\n" +
                "\t\t\t</record>\n" +
                "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                "\t\t</record>"
                ;
    }

    public static String ds1Ds2(int dbUniqueID, int fmxmlIDVersion) {
        return                 //Regional Division Add
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS Level
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS1
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                        "\t\t\t\t<record id=\"value\">\n" +
                        "\t\t\t\t\t<large id=\"competition\" value=\"115970383376286323\"/>\n" +
                        "\t\t\t\t\t<integer id=\"DBID\" value=\"27001459\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Regional Division add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"596855755\"/>\n" +
                        "\t\t</record>\n" +
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS2
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                        "\t\t\t\t<record id=\"value\">\n" +
                        "\t\t\t\t\t<large id=\"competition\" value=\"115970469275632263\"/>\n" +
                        "\t\t\t\t\t<integer id=\"DBID\" value=\"27001479\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n";
    }

    public static String ds3Ds4(int dbUniqueID, int fmxmlIDVersion) {
        return
                //Regional Division add
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS3 level
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS3
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                        "\t\t\t\t<record id=\"value\">\n" +
                        "\t\t\t\t\t<large id=\"competition\" value=\"115970542290076312\"/>\n" +
                        "\t\t\t\t\t<integer id=\"DBID\" value=\"27001496\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //Regional Division add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS4 level
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS4
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                        "\t\t\t\t<record id=\"value\">\n" +
                        "\t\t\t\t\t<large id=\"competition\" value=\"116247524731059842\"/>\n" +
                        "\t\t\t\t\t<integer id=\"DBID\" value=\"27065986\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>";
    }

    public static String ds4Ds3(int dbUniqueID, int fmxmlIDVersion) {
        return                 //Regional Division add
                "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS 4 level
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS4
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                        "\t\t\t\t<record id=\"value\">\n" +
                        "\t\t\t\t\t<large id=\"competition\" value=\"116247524731059842\"/>\n" +
                        "\t\t\t\t\t<integer id=\"DBID\" value=\"27065986\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>" +
                        //Regional Division add
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"0\"/>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS3 level
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1818588773\"/>\n" +
                        "\t\t\t\t<integer id=\"value\" value=\"5\"/>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"0\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n" +

                        //DS3
                        "\t\t<record>\n" +
                        "\t\t\t<integer id=\"database_table_type\" value=\"3\"/>\n" +
                        "\t\t\t<large id=\"db_unique_id\" value=\"" + dbUniqueID + "\"/>\n" +
                        "\t\t\t<unsigned id=\"property\" value=\"1131570284\"/>\n" +
                        "\t\t\t<record id=\"new_value\">\n" +
                        "\t\t\t\t<unsigned id=\"id\" value=\"1668246896\"/>\n" +
                        "\t\t\t\t<record id=\"value\">\n" +
                        "\t\t\t\t\t<large id=\"competition\" value=\"115970542290076312\"/>\n" +
                        "\t\t\t\t\t<integer id=\"DBID\" value=\"27001496\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t\t<integer id=\"lsop\" value=\"1\"/>\n" +
                        "\t\t\t\t<record id=\"olvl\">\n" +
                        "\t\t\t\t\t<null id=\"competition\"/>\n" +
                        "\t\t\t\t\t<integer id=\"leve\" value=\"5\"/>\n" +
                        "\t\t\t\t\t<null id=\"year\"/>\n" +
                        "\t\t\t\t</record>\n" +
                        "\t\t\t</record>\n" +
                        "\t\t\t<integer id=\"version\" value=\"" + fmxmlIDVersion + "\"/>\n" +
                        "\t\t\t<integer id=\"db_random_id\" value=\"" + UtilityHelper.getRandomID() + "\"/>\n" +
                        "\t\t</record>\n";
    }
}