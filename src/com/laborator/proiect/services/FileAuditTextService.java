package com.laborator.proiect.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileAuditTextService {
    private static FileAuditTextService ourInstance = new FileAuditTextService();

    public static FileAuditTextService getInstance() {
        return ourInstance;
    }

    private FileAuditTextService() {
    }

    public void writeTextToAudit(String textToWrite, String fileNamePath) {

        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(fileNamePath, true)
            );
            printWriter.println(textToWrite);

            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
