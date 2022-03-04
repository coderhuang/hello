package web.user.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserVO {

	private String name;

	private LocalDateTime time;
}
