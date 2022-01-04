package models.createUser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CompaniesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private Integer id;
}