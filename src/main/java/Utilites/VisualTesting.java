package Utilites;

import com.applitools.eyes.selenium.Eyes;

public class VisualTesting {
   private Eyes eyes ;

    public Eyes eyesInit (String apiKey){
        eyes = new Eyes();
        eyes.setApiKey(apiKey);

        return eyes;
    }




}
