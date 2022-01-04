package models.createUser.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateUserRequest{

	@JsonProperty("birthday")
	private String birthday;

	@JsonProperty("fathername1")
	private String fathername1;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("hamster")
	private String hamster;

	@JsonProperty("inn")
	private String inn;

	@JsonProperty("cavy")
	private String cavy;

	@JsonProperty("companies")
	private List<Integer> companies;

	@JsonProperty("surname1")
	private String surname1;

	@JsonProperty("squirrel")
	private String squirrel;

	@JsonProperty("date_start")
	private String dateStart;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("cat")
	private String cat;

	@JsonProperty("name")
	private String name;

	@JsonProperty("adres")
	private String adres;

	@JsonProperty("name1")
	private String name1;

	@JsonProperty("dog")
	private String dog;

	@JsonProperty("parrot")
	private String parrot;

	@JsonProperty("email")
	private String email;

	@JsonProperty("tasks")
	private List<Integer> tasks;

	@JsonProperty("hobby")
	private String hobby;
}