package commons;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TimeVO {

	private LocalDateTime time;

	private String message;
}
