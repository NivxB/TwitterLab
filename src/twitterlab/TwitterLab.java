/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import twitter4j.IDs;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author kbarahona
 */
public class TwitterLab {

    private static ArrayList<ArrayList<User>> Users;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Users = new ArrayList();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("yBSAPlE6wiAQU6CyIiXHSapwN");
        cb.setOAuthConsumerSecret("3CjbEkYyIZvNZ07KYpC55v9vpqxoNmMs1IkC48Wqr5tKXjUnZk");
        cb.setOAuthAccessToken("858371720-0RASIMJeaMbWr2YPmCPyh5OgCP6Kesgz0WvdsLz7");
        cb.setOAuthAccessTokenSecret("cfi5JDGLTUOKHNj7yFIdivg0Hr1bCml3VlQXj5XCOyoFr");

        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter tw = tf.getInstance();
            IDs ids = tw.getFriendsIDs(-1);
            long[] ID;
            if (ids.getIDs().length > 10) {
                ID = new long[10];
                System.arraycopy(ids.getIDs(), 0, ID, 0, 10);
            } else {
                ID = ids.getIDs();
            }
            ResponseList<User> Friends = tw.lookupUsers(ID);
            User[] A = new User[10];
            if (Friends.toArray().length > 0) {
                Users.add(new ArrayList(Arrays.asList(Friends.toArray(A))));
            }
            for (int i = 0; i < ID.length; i++) {
                IDs idsFriend = tw.getFriendsIDs(ID[i], -1);
                long[] IDfriend;
                if (idsFriend.getIDs().length > 10) {
                    IDfriend = new long[10];
                    System.arraycopy(idsFriend.getIDs(), 0, IDfriend, 0, 10);
                } else {
                    IDfriend = idsFriend.getIDs();
                }
                ResponseList<User> FriendsFriend = tw.lookupUsers(IDfriend);
                A = new User[10];
                if (FriendsFriend.toArray().length > 0) {
                    Users.add(new ArrayList(Arrays.asList(FriendsFriend.toArray(A))));
                }
                //System.out.println("Sleep?");
                TimeUnit.SECONDS.sleep(60);
            }

            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < Users.get(0).size(); j++) {
                    System.out.println(Users.get(i).get(j).getScreenName());
                }
            }

        } catch (Exception e) {
            // Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

}
