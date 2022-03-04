package web.user.controller;

import java.time.LocalDateTime;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

import io.javalin.http.Context;
import web.user.vo.UserVO;

public class UserController {

	public static void userInfo(@NotNull Context ctx) throws Exception {

		UserVO vo = new UserVO();
		String randomName = randomString(10);
		vo.setName(randomName);
		vo.setTime(LocalDateTime.now());

		ctx.json(vo);
	}

	public static void getUser(@NotNull Context ctx) throws Exception {

		String id = ctx.pathParam("id");
		UserVO vo = new UserVO();
		vo.setName(id);
		vo.setTime(LocalDateTime.now());

		ctx.json(vo);
	}

	/**
	 * 指定某个位置是a-z、A-Z或是0-9;<br>
	 * 可以指定字符串的某个位置是什么范围的值
	 * 
	 * @param size
	 * @return
	 */
	public static String randomString(int size) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			case 0:
				// a-z
				result = Math.round(Math.random() * 25 + 65);
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				// A-Z
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				// 0-9
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}

		}
		return sb.toString();
	}
}
