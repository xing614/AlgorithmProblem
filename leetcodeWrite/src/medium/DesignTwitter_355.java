package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 355.设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户
示例:

Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);

// 用户1关注了用户2.
twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);
 * @author liang
 *
 */
public class DesignTwitter_355 {

	/**
	 * 需要在类中有一个保存userId和他发送的所有twitter的关系的Map，
	 * 以及userId和他所关注的其他userid的关系的Map。
	 * 浏览twitter时只要找到用户自己发的twitter，和通过自己所关注的人所发的twitter，并从中选取出10条最近发送的即可。
	 */
	
	private static int order = 0;
	private Map<Integer,Set<Message>> messages;//user和它发送的twitter关系
	private Map<Integer,Set<Integer>> followers;//user和它关注的userid关系
	
    public DesignTwitter_355() {
        messages = new HashMap<Integer,Set<Message>>();
        followers = new HashMap<Integer,Set<Integer>>();
    }
    
    /** 
     * Compose a new tweet. 
     * 用户Userid发送了一条推特
     * */
    public void postTweet(int userId, int tweetId) {
        Message m = new Message(userId,tweetId,order++);
        Set<Message> set = messages.getOrDefault(userId, new HashSet<Message>());//如果map中没有userid，就使用new HashSet<Message>()，有就不使用
        set.add(m);
        messages.put(userId, set);
    }
    
    /** 
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. 
     * 返回userId和它关注用户的推特列表
     * */
    public List<Integer> getNewsFeed(int userId) {
        List<Message> sets = new ArrayList<Message>();
        //获取userid发送的信息
        Set<Message> set = messages.getOrDefault(userId, new HashSet<Message>());
        sets.addAll(set);
        //获取它关注人的信息
        Set<Integer> follow = followers.get(userId);
        if(follow!=null) {
        	for(int i:follow) {
        		set = messages.getOrDefault(i, new HashSet<Message>());
        		sets.addAll(set);
        	}
        }
        //对信息进行排序，并找出最近的十条
        List<Integer> result = new ArrayList<>();
        Compare c = new Compare();
        sets.sort(c);
        for(int i = 0;i<sets.size() && i<10;i++) {
        	Message m = sets.get(i);
        	result.add(m.twitterId);
        }
        return result;
    }
    
    /** 
     * Follower follows a followee. If the operation is invalid, it should be a no-op. 
     * 设置followerId关注了followeeId
     * */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) {
        	return;
        }
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet<Integer>());
        set.add(followeeId);
        followers.put(followerId, set);
    }
    
    /** 
     * 取消关注
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(followeeId == followerId) {
        	return;
        }
    	if(!followers.containsKey(followerId)) {
    		return;
    	}else {
    		Set<Integer> set = followers.get(followerId);
    		set.remove(followeeId);	
    		if(set.size() == 0) {//没关注了就删除
    			followers.remove(followerId);
    		}else {
    			followers.put(followerId, set);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignTwitter_355 twitter = new DesignTwitter_355();

		// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
		twitter.postTweet(1, 5);

		// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
		System.out.println(twitter.getNewsFeed(1));

		// 用户1关注了用户2.
		twitter.follow(1, 2);

		// 用户2发送了一个新推文 (推文id = 6).
		twitter.postTweet(2, 6);

		// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
		// 推文id6应当在推文id5之前，因为它是在5之后发送的.
		System.out.println(twitter.getNewsFeed(1));

		// 用户1取消关注了用户2.
		twitter.unfollow(1, 2);

		// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
		// 因为用户1已经不再关注用户2.
		twitter.getNewsFeed(1);
	}

	//推特信息数据
	class Message{
		int useId;
		int twitterId;
		int order;//当前信息位于发送的第几条，数越大表示越晚生成，则返回时先返回
		
		public Message(int userId,int twitterId,int order) {
			super();
			this.useId = useId;
			this.twitterId = twitterId;
			this.order = order;
		}
	}
	
	//信息比较器
	class Compare implements Comparator<Message>{

		@Override
		public int compare(Message o1, Message o2) {
			// TODO Auto-generated method stub
			if(o1.order>o2.order)
				return -1;
			else if(o1.order<o2.order)
				return 1;
			else
				return 0;
		}
		
	}
}
