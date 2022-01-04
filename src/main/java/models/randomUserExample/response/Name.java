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
public class Name{

	@JsonProperty("last")
	private String last;

	@JsonProperty("title")
	private String title;

	@JsonProperty("first")
	private String first;
}