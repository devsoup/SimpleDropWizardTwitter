package uk.co.devsoup.simpledropwizardtwitter;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import uk.co.devsoup.simpledropwizardtwitter.configuration.SimpleDropWizardTwitterConfiguration;
import uk.co.devsoup.simpledropwizardtwitter.resources.SimpleDropWizardTwitterResource;

public class SimpleDropWizardTwitterApplication extends Application<SimpleDropWizardTwitterConfiguration> {
    public static void main(String[] args) throws Exception {
        new SimpleDropWizardTwitterApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SimpleDropWizardTwitterConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(SimpleDropWizardTwitterConfiguration configuration,
                    Environment environment) {
        final SimpleDropWizardTwitterResource resource = new SimpleDropWizardTwitterResource();
        environment.jersey().register(resource);
    }
}
