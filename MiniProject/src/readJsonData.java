import java.io.FileNotFoundException; // To handle cases where the specified file is not found
import java.io.FileReader; // To read the contents of a file
import java.io.IOException; // To handle input/output exceptions

import org.json.simple.JSONArray; // To work with JSON arrays
import org.json.simple.JSONObject; // To work with JSON objects
import org.json.simple.parser.JSONParser; // To parse JSON data from files
import org.json.simple.parser.ParseException; // To handle parsing exceptions when reading JSON

public class readJsonData {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        // Define the file path for the JSON file (TestData.json)
        String filePath = System.getProperty("user.dir") + "//TestData.json";

        // Create a FileReader object to read the JSON file
        FileReader file = new FileReader(filePath);

        // Create a JSONParser object to parse the JSON content
        JSONParser parser = new JSONParser();

        // Parse the JSON file into a JSONObject
        JSONObject json = (JSONObject) parser.parse(file);

        // Print the entire JSON content as a string
        System.out.println(json.toJSONString());

        // Extract the "testdata" array from the JSON object
        JSONArray TestData = (JSONArray) json.get("testdata");
        System.out.println(TestData.toJSONString());

        // Extract the second object in the "testdata" array (index 1)
        JSONObject loginTest = (JSONObject) TestData.get(1);
        System.out.println(loginTest.toJSONString());
        
        // Print the value of the "testname" key in the second object
        System.out.println(loginTest.get("testname"));

        // Extract the "data" array from the second object
        JSONArray LoginTestSet = (JSONArray) loginTest.get("data");

        // Extract the first object in the "data" array (index 0)
        JSONObject secondData = (JSONObject) LoginTestSet.get(0);

        // Print the value of the "browser" key in the first object
        System.out.println(secondData.get("browser"));
        
    }
}
