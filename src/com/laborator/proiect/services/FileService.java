package com.laborator.proiect.services;

import com.laborator.proiect.model.Medicine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static FileService ourInstance = new FileService();

    public static FileService getInstance() {
        return ourInstance;
    }

    private FileService() {
    }

    public void writeObjectToFile(Object object, String fileNamePath) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(fileNamePath));

            objectOutputStream.writeObject(object);

            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object readObjectFromFile(String fileNamePath) {
        Object object = null;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileNamePath));

            object = objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }


}
