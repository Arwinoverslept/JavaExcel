import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class writeJSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject student1 = new JSONObject();
		student1.put("studentName","Arwin");
		student1.put("Grade Level","4th Year");
		student1.put("university","Mariano Marcos State University");
		
		JSONObject student2 = new JSONObject();
		student2.put("studentName","CK");
		student2.put("Grade Level","4th Year");
		student2.put("university","Mariano Marcos State University");
		
		
		System.out.println(student1.toJSONString());
		System.out.println(student2.toJSONString());
		
		
		JSONArray studentDetails= new JSONArray();
		studentDetails.add(student1);
		studentDetails.add(student2);
		
		System.out.println(studentDetails.toJSONString());
		
		JSONObject details = new JSONObject();
		details.put("Student Details", studentDetails);
		System.out.println(details);		
	}

}
