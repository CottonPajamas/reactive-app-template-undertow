package com.launch;

import static io.undertow.Handlers.path;

import com.launch.servlet.TestHandler;

import io.undertow.Undertow;
import io.undertow.util.Headers;

/**
 * References: 
 * <br>
 * https://www.baeldung.com/jboss-undertow
 * <br>
 * https://dzone.com/articles/microservices-with-undertow-introduction
 * <br>
 * http://undertow.io/undertow-docs/undertow-docs-1.4.0/index.html
 * 
 * @author CottonPajamas
 *
 */
public class ReactiveWebApplication {

	public static void main(String[] args) {
		System.out.println(">>> Starting JavaEE application...");
		Undertow.Builder builder = Undertow.builder();
		builder.setIoThreads(2);
		builder.setWorkerThreads(10);
		builder.addHttpListener(8080, "0.0.0.0");
		builder.setHandler(path()
				.addPrefixPath("/", exchange -> {
					exchange.getResponseSender().send("Hello World");
				})
				.addExactPath("hi1", new TestHandler())
				.addExactPath("hi2", new TestHandler())
				.addExactPath("hi3",exchange -> {
					exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
					exchange.getResponseSender().send("{\"message\":\"Final API\"}");
				})
		);
		Undertow server = builder.build();
		server.start();
	}

}
