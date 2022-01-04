package models.randomUserExample.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResultsItem{

	@JsonProperty("nat")
	private String nat;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("dob")
	private Dob dob;

	@JsonProperty("name")
	private Name name;

	@JsonProperty("registered")
	private Registered registered;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("id")
	private Id id;

	@JsonProperty("login")
	private Login login;

	@JsonProperty("cell")
	private String cell;

	@JsonProperty("email")
	private String email;

	@JsonProperty("picture")
	private Picture picture;
}