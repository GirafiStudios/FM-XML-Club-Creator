package com.girafi.clubcreator;

import com.girafi.clubcreator.helper.Templates;
import com.girafi.clubcreator.typebuilder.ClubBuilder;
import com.girafi.clubcreator.typebuilder.CompBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClubCreator {
    public static final String EXCEL_INPUT = "./clubs.xlsx";
    public static final int FM_XML_ID_VERSION = 3509;
    public static final int START_CLUB_UNIQUE_ID = 2000247394;
    public static final int START_COMP_UNIQUE_ID = 2000239372;

    public static void main(String[] args) {
        try {
            Workbook workbook = WorkbookFactory.create(new File(EXCEL_INPUT));

            FileWriter fileWriter = new FileWriter("xmlOutput.xml");
            fileWriter.write(Templates.startTemplate());;
            CompBuilder.run(fileWriter, workbook); //Needs to run first, so clubs can reference the comps
            ClubBuilder.run(fileWriter, workbook);
            fileWriter.write(Templates.endTemplate());
            fileWriter.close();

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}