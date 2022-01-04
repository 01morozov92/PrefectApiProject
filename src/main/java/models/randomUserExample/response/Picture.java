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
public class Picture{

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("large")
	private String large;

	@JsonProperty("medium")
	private String medium;
}