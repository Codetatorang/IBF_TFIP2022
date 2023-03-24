package ibf2022.tfip.ssf.day16JSONPIntroduction;

/* import java.io.Reader;
import java.io.StringReader; */

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader; */

@SpringBootApplication
public class Day16JsonPIntroductionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day16JsonPIntroductionApplication.class, args);
	}

	@Override
	public void run(String... args) {

		/* 
		// json-p object creation with json object builder
		JsonObject jsonObj = Json.createObjectBuilder()
				.add("name", "fred")
				.add("email", "fred@gmail.com")
				.build();
		System.out.printf(">>>> jsonObject: %s\n", jsonObj.toString());

		// json-p array creation with json array builder
		JsonArray jsonArray = Json.createArrayBuilder()
				.add(jsonObj)
				.add(jsonObj)
				.add(jsonObj)
				.build();
		System.out.printf(">>>> jsonArray: %s\n", jsonArray.toString());

		// create a json format string then convert to json object
		String jsonStr = """
					{
						"orderId": 1234, "address": "10 bedrock ave",
						"lineItems":[
							{ "name" : "orange", "quantity": 10 },
							{ "name" : "apple", "quantity": 20 }
							]
					}

				""";

		System.out.printf(">>>> jsonStr: %s\n", jsonStr);

		//converts string json to json using json reader
		Reader reader = new StringReader(jsonStr);
		JsonReader jsonReader = Json.createReader(reader);
		jsonObj = jsonReader.readObject();

		System.out.printf("order:Id: %d\n", jsonObj.getInt("orderId"));
		System.out.printf("address:Id: %s\n", jsonObj.getString("address"));

		//retrieve the array values in the lineItems key
		jsonArray = jsonObj.getJsonArray("lineItems");

		for (int i = 0; i < jsonArray.size(); i++) {
		jsonObj = jsonArray.getJsonObject(i);
		System.out.printf("\tname: %s, quantity: %d\n", jsonObj.getString("name"),
		jsonObj.getInt("quantity"));
		}
		
		*/
	}
}
