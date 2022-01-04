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
public class Login{

	@JsonProperty("sha1")
	private String sha1;

	@JsonProperty("password")
	private String password;

	@JsonProperty("salt")
	private String salt;

	@JsonProperty("sha256")
	private String sha256;

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("username")
	private String username;

	@JsonProperty("md5")
	private String md5;
}