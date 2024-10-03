package Singleton;

public class Main {
    public static void main(String[] args) {

        //Get the singleton instance of logger
        Logger logger = Logger.getInstance();

        //Write messages
        logger.write("Application started");
        logger.write("Some text...");

        logger.setFileName("new_log.txt");
        logger.write("This is thes new file");
        logger.write("zlalal started");


        logger.close();


    }
}
