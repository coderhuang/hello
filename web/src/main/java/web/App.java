package web;

import java.time.LocalDateTime;

import commons.TimeVO;
import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {

		Javalin app = Javalin.create().start(7071);

		app.get("/", ctx -> ctx.result("hello"));

		app.get("/oHo", ctx -> {

			TimeVO vo = new TimeVO();
			vo.setTime(LocalDateTime.now());
			vo.setMessage("oHo");

			ctx.json(vo);
		});
	}

}
