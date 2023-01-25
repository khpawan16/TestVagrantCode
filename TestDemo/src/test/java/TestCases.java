import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.testVagrant.Player;
import com.testVagrant.TeamDetail;

public class TestCases {
	public TeamDetail teamDetail;

	@BeforeTest
	public void readInputFile() throws IOException, ParseException {
		JSONParser jsonPraser = new JSONParser();
		FileReader reader = new FileReader("../TestDemo/src/main/resources/testDataResources/Example.json");
		JSONObject obj = (JSONObject) jsonPraser.parse(reader);

		Gson gson = new Gson();
		teamDetail = gson.fromJson(obj.toString(), TeamDetail.class);
	}

	@Test
	public void validateNumberOfForigenPlayers() {
		int countryCount = 0;
		for (Player player : teamDetail.getPlayer()) {
			if (!player.getCountry().equals("India")) {
				countryCount = countryCount + 1;
			}
		}
		if (countryCount == 4) {
			System.out.println("Team has only 4 foreign Player");
		} else if (countryCount > 4) {
			System.out.println("Team has more than 4 foreign Player");
		} else {
			System.out.println("Team has less than 4 foreign Player");
		}
	}

	@Test
	public void validateNumberOfWicketKeepers() {
		int wkCount = 0;
		for (Player player : teamDetail.getPlayer()) {
			if (player.getRole().equals("Wicket-keeper")) {
				wkCount = wkCount + 1;
			}
		}
		if (wkCount >= 1) {
			System.out.println("Team has atleast one wicket keeper");

		} else {
			System.out.println("Team has no wicket keeper");
		}

	}

}
