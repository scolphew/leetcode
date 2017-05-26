package lsf._355_DesignTwitter;

import java.util.*;

public class Twitter {

    class Tweet {
        int userID;
        int tweetId;
        int time;

        public Tweet(int userId, int tweetId) {
            this.userID = userId;
            this.tweetId = tweetId;
            this.time = id++;
        }
    }

    class User {
        int id;
        Set<Tweet> tweets;
        Set<User> followees;

        public User(int id) {
            this.id = id;
            tweets = new HashSet<>();
            followees = new HashSet<>();
        }
    }

    private static int id = 0;
    HashMap<Integer, User> map;


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        map = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        User user = getUset(userId);

        user.tweets.add(new Tweet(userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new LinkedList<>();
        User u = map.get(userId);
        if (u == null)
            return ans;
        PriorityQueue<Tweet> q = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.time - o1.time;
            }
        });
        q.addAll(u.tweets);
        for (User followee : u.followees) {
            if (followee.tweets != null)
                q.addAll(followee.tweets);
        }

        for (int i = 0; i < 10 && !q.isEmpty(); i++) {
            ans.add(q.poll().tweetId);
        }
        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        User u1 = getUset(followerId);
        User u2 = getUset(followeeId);
        u1.followees.add(u2);
    }

    private User getUset(int userId) {

        User user;
        if (map.containsKey(userId)) {
            user = map.get(userId);
        } else {
            user = new User(userId);
            map.put(userId, user);
        }
        return user;
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        User u1 = getUset(followerId);
        User u2 = getUset(followeeId);
        u1.followees.remove(u2);
    }

    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));
    }
}
