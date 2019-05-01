package com.laborator.proiect.services;

import java.io.*;

public class FileService {
    private static FileService ourInstance = new FileService();

    public static FileService getInstance() {
        return ourInstance;
    }

    private FileService() {
    }

    /**
     * @param object
     * @param fileNamePath
     */
    public void writeObjectToFile(Object object, String fileNamePath) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(fileNamePath));

            objectOutputStream.writeObject(object);

            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * read an object from a file
     *
     * @param fileNamePath
     * @return
     */
    public Object readObjectFromFile(String fileNamePath) {
        Object object = null;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileNamePath));

            object = objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }


}
