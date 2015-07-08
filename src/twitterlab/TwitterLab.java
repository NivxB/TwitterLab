/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterlab;

import javax.security.auth.login.Configuration;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author kbarahona
 */
public class TwitterLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("yBSAPlE6wiAQU6CyIiXHSapwN");
        cb.setOAuthConsumerSecret("3CjbEkYyIZvNZ07KYpC55v9vpqxoNmMs1IkC48Wqr5tKXjUnZk");

        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            System.out.println("-----");

            // get request token.
            // this will throw IllegalStateException if access token is already available
            // this is oob, desktop client version
            RequestToken requestToken = twitter.getOAuthRequestToken();

            System.out.println("Got request token.");
            System.out.println("Request token: " + requestToken.getToken());
            System.out.println("Request token secret: " + requestToken.getTokenSecret());

            
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

}
