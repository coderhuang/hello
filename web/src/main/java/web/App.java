package web;

import java.time.LocalDateTime;
import java.util.Objects;

import commons.TimeVO;
import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class App {

	private static final String PREVIOUS_TIME = "previous_time";

	public static void main(String[] args) {

		Javalin app = Javalin.create().start(7071);

		app.before("/*", ctx -> {
			LocalDateTime now = ctx.cookieStore(PREVIOUS_TIME);
			if (Objects.isNull(now)) {
				ctx.cookieStore(PREVIOUS_TIME, LocalDateTime.now());
			}
			System.err.println("all request before handler: "+now);
		});
		app.get("/", ctx -> ctx.result("hello"));
		app.after("/*", ctx -> {
			LocalDateTime now = LocalDateTime.now();
			System.err.println("all request after handler: "+now);
			ctx.cookieStore(PREVIOUS_TIME, now);
		});

		app.get("/oHo", ctx -> {

			TimeVO vo = new TimeVO();
			vo.setTime(LocalDateTime.now());
			vo.setMessage("oHo");

			ctx.json(vo);
		});
		app.post("/oHo", ctx -> ctx.status(HttpCode.NO_CONTENT));
		app.get("/hello/{message}", ctx -> ctx.result("hello " + ctx.pathParam("message")));
		app.get("/hello/<message>", ctx -> ctx.result("hello " + ctx.pathParam("message")));
	}

}
