package models.randomUserExample.response;

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
public class RandomUserResponse{

	@JsonProperty("results")
	private List<ResultsItem> results;

	@JsonProperty("info")
	private Info info;
}