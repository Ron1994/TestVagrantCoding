package org.example;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class Test1
{
    @Test
    public void foreignPlayerCountValidation() throws IOException, ParseException {
        JSONArray jsonChildObject = JsonParsing();
        int count = 0;
        for(int i=0;i<jsonChildObject.size();i++)
        {
            if(!((JSONObject)jsonChildObject.get(i)).get("country").toString().equals("India"))
            {
                count++;
            }
        }
        Assert.assertEquals(count,4,"The foreign players actual count is "+ count+".");
    }

    @Test
    public void wicketKeeperCountValidation() throws IOException, ParseException {
        JSONArray jsonChildObject = JsonParsing();
        int count = 0;
        for(int i=0;i<jsonChildObject.size();i++)
        {
            if(((JSONObject)jsonChildObject.get(i)).get("role").toString().equals("Wicket-keeper"))
            {
                count++;
            }
        }
        Assert.assertTrue(count>0,"Wicket-Keeper(s) actual count is "+ count+".");
    }
    public JSONArray JsonParsing() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\TeamRCB.json"));
        JSONObject jsonObject =(JSONObject)obj;
        JSONArray jsonChildObject = (JSONArray)jsonObject.get("player");
        return jsonChildObject;
    }


}
