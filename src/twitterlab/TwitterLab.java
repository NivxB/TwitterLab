/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterlab;

import javax.security.auth.login.Configuration;
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
    }
    
}
