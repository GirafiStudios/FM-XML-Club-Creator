package com.girafi.clubcreator;

import com.girafi.clubcreator.helper.Templates;
import com.girafi.clubcreator.typebuilder.CityBuilder;
import com.girafi.clubcreator.typebuilder.ClubBuilder;
import com.girafi.clubcreator.typebuilder.CompBuilder;
import com.girafi.clubcreator.typebuilder.StadiumBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//TODO Implement way to add existing teams to Divisions (Danish Lower Division only)
public class ClubCreator {
    public static final String EXCEL_INPUT = "./clubs.xlsx";
    public static final String XML_OUTPUT = "xmlOutput.xml";
    public static final int FM_XML_ID_VERSION = 3509;
    public static final int START_CLUB_UNIQUE_ID = 2000247394;
    public static final int START_COMP_UNIQUE_ID = 2000239372;
    public static final int START_STADIUM_UNIQUE_ID = 2000248723;
    public static final int START_CITY_UNIQUE_ID = 2000247169;

    public static void main(String[] args) {
        try {
            Workbook workbook = WorkbookFactory.create(new File(EXCEL_INPUT));

            FileWriter fileWriter = new FileWriter(XML_OUTPUT);
            fileWriter.write(Templates.startTemplate());;
            CompBuilder.run(fileWriter, workbook);
            CityBuilder.run(fileWriter, workbook);
            StadiumBuilder.run(fileWriter, workbook);
            ClubBuilder.run(fileWriter, workbook);
            ExcistingTeamsHandler.run(fileWriter, workbook);
            fileWriter.write(Templates.endTemplate());
            fileWriter.close();

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}