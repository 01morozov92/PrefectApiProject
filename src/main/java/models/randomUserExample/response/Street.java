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
public class Street{

	@JsonProperty("number")
	private Integer number;

	@JsonProperty("name")
	private String name;
}