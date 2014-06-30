package uk.co.devsoup.simpledropwizardtwitter.resources;

import com.codahale.metrics.annotation.Timed;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import uk.co.devsoup.simpledropwizardtwitter.interfaces.Response;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/tweet")
@Produces(MediaType.APPLICATION_JSON)
public class SimpleDropWizardTwitterResource {
    public SimpleDropWizardTwitterResource() {

    }

    @POST
    @Timed
    public Response tweetMessage(@QueryParam("tweet") String tweet) {
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);

        // Can't export environment variables with dots in the key, so name munging happens here
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(Boolean.parseBoolean(System.getenv("twitter4j_debug")))
                .setOAuthConsumerKey(System.getenv("twitter4j_oauth_consumerKey"))
                .setOAuthConsumerSecret(System.getenv("twitter4j_oauth_consumerSecret"))
                .setOAuthAccessToken(System.getenv("twitter4j_oauth_accessToken"))
                .setOAuthAccessTokenSecret(System.getenv("twitter4j_oauth_accessTokenSecret"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            Status status = twitter.updateStatus(tweet);
            result.setMessage("Successfully updated the status to [" + status.getText() + "].");
            result.setSuccess(Boolean.TRUE);
        } catch (TwitterException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
