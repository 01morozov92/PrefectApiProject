package models.doRegister.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DoRegisterRequest{

	@JsonProperty("password")
	private String password;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;
}