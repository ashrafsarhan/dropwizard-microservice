package com.dropwiz.ws;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizApplication extends Application<DropwizConfiguration> {

	public static void main(final String[] args) throws Exception {
		new DropwizApplication().run(args);
	}

	@Override
	public String getName() {
		return "dropwiz ws";
	}

	@Override
	public void initialize(final Bootstrap<DropwizConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final DropwizConfiguration configuration, final Environment environment) {
		// TODO: implement application
		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(),
				configuration.getDefaultName());
		environment.jersey().register(resource);

		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
	}

}
