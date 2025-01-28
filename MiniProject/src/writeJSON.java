import org.json.simple.JSONArray; // Represents a JSON array
import org.json.simple.JSONObject; // Represents a JSON object

public class writeJSON {

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings for generic types
    public static void main(String[] args) {
        // Create a JSON object to represent the first student
        JSONObject student1 = new JSONObject();
        student1.put("studentName", "Arwin"); // Add the student's name
        student1.put("Grade Level", "4th Year"); // Add the student's grade level
        student1.put("university", "Mariano Marcos State University"); // Add the university name

        // Create a JSON object to represent the second student
        JSONObject student2 = new JSONObject();
        student2.put("studentName", "CK");
        student2.put("Grade Level", "4th Year");
        student2.put("university", "Mariano Marcos State University");

        // Print the JSON representation of both students
        System.out.println(student1.toJSONString()); // Print student1's JSON data
        System.out.println(student2.toJSONString()); // Print student2's JSON data

        // Create a JSON array to hold the student objects
        JSONArray studentDetails = new JSONArray();
        studentDetails.add(student1); // Add student1 to the array
        studentDetails.add(student2); // Add student2 to the array

        // Print the JSON array containing student details
        System.out.println(studentDetails.toJSONString());

        // Create a JSON object to hold the entire data structure
        JSONObject details = new JSONObject();
        details.put("Student Details", studentDetails); // Add the array to the object
        System.out.println(details); // Print the final JSON structure
    }
}
