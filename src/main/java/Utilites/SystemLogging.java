package Utilites;



import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemLogging {
private static final Logger logger = Logger.getLogger(Logger.class.getName());

static FileHandler framewokrHandler = null;
static String fileName = "default.log";
static Boolean append = Boolean.TRUE;

public static void loggerInit (){

    try {
        framewokrHandler = new FileHandler(fileName ,append);

        logger.addHandler(framewokrHandler);
        logger.info("Start of a Test");
    } catch (IOException e) {
        e.printStackTrace();
    }

}

public static void loggerAddInfo (String info){

    logger.info(info);


}

public static void loggerAddWarning (String warning){

        logger.warning(warning);


    }

    public static void loggerAddSevere  (String severe , Exception e ){

        logger.log(Level.SEVERE , severe ,e);
    }

}
