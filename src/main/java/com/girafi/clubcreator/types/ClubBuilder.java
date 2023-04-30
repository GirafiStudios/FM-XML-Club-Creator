package com.girafi.clubcreator.types;

import com.girafi.clubcreator.helper.Templates;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import static com.girafi.clubcreator.helper.PrintHelper.print;
import static com.girafi.clubcreator.helper.SheetHelper.cell;

public class ClubBuilder {

    public static void run(Workbook workbook) throws IOException {
        Sheet sheet = workbook.getSheetAt(0);

        AtomicLong dbUniqueIDStart = new AtomicLong(4100000000000000000L); //TODO Test?

        //Clubs
        sheet.forEach(row -> {
            dbUniqueIDStart.getAndIncrement();
            if (row.getRowNum() > 0) { //Ignore headers
                print(Templates.clubDetails(dbUniqueIDStart.get(), cell(row.getCell(0)), cell(row.getCell(1)), cell(row.getCell(2)), cell(row.getCell(3)), cell(row.getCell(4)), cell(row.getCell(5)), cell(row.getCell(6)), cell(row.getCell(7)), cell(row.getCell(8)), cell(row.getCell(9))));
            }
        });
    }
}