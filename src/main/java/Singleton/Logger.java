package Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    //Private static logger to hold the single logger instance
    private static Logger instance;

    //File handling variables
    private FileWriter fileWriter;
    private String fileName;


    //private construction to prevent instantiation from outside
    private Logger(){
        //initialize with a default file name
        setFileName("default_test_nmr1");
    }

    //Static getInstance method : to provide global access to the single logger instance
    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger(); //Create the single instance if it doesn't exit
        }
        return instance;
    }

    //Method to set filename dynaamisesti
    public void setFileName(String newFileName){
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Open new file name with specified name
        fileName = newFileName;
        try {
            fileWriter = new FileWriter(fileName, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to write log messages to file
    public void write(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to close the logger and the file
    public void close() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
