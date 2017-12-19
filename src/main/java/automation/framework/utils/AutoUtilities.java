package automation.framework.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import automation.framework.common.BaseTest;

public class AutoUtilities extends BaseTest{
	
	

    /**
     * The static variable to hold test data from file as json object
     */
    public JSONObject obj = null;

    /**
     * Method to load test data from a json file into json object "obj" once at the starting of test
     * suite ideally in @BeforeSuite method
     * 
     * @param fileName
     */
    public void loadTestData(String fileName) {
        JSONParser parser = new JSONParser();
        try {
        
            obj = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") +fileName));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Method that takes any no of parameters in relation to the depth of json data structure to
     * read And return the value of the respective key. for example:
     * readTestData("userInfo","passion","code");
     * 
     * @param args
     * @return
     */
    public String readTestData(String... args) {
        JSONObject temp = obj;
        if (args.length == 1) {
            return (String) obj.get(args[0]);
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                temp = (JSONObject) temp.get(args[i]);
            }
            return (String) temp.get(args[args.length - 1]);
        }
    }
    
    public List<Object> readTestDataList(String... args) {
        JSONObject temp = obj;
        if (args.length == 1) {
            return (List) obj.get(args[0]);
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                temp = (JSONObject) temp.get(args[i]);
            }
            return (List<Object>) temp.get(args[args.length - 1]);
        }
    }

    /**
     * This method is invoked from the Assertion failures to take a screenshot automatically when an
     * assert fails
     * 
     * @param timeStamp
     */
     void takeScreenShot(String timeStamp) {
        String filePath = System.getProperty("user.dir") + "/Screenshots/";
       
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // The below method will save the screen shot in the specified drive with current time stamp
        try {
            FileUtils.copyFile(scrFile, new File(filePath + timeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String absfileName = filePath + timeStamp + ".png";
        Reporter.log("<a href='" + absfileName + "'> <img src='" + absfileName
                + "' height='100' width='100'/> </a>");
    }

    /**
     * This method is used to get the current timeStamp which will be used to name the screenshot
     * files
     * 
     * @return current time as timeStamp String
     */
     String timeStamp() {
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM_dd_yyyy_HH:mm:ss");
        Date timeStamp = new Date(yourmilliseconds);
        return sdf.format(timeStamp);
    }

}
