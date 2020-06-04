package com.launch.servlet;

import java.nio.charset.StandardCharsets;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class TestHandler implements HttpHandler {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter out = resp.getWriter();
//		resp.setContentType("application/json");
//		resp.setCharacterEncoding("UTF-8");
//		out.print();
//		out.flush();
//	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
		exchange.getResponseSender().send("{\"message\":\"Tom from test handler :D\"}", StandardCharsets.UTF_8);
	}

}