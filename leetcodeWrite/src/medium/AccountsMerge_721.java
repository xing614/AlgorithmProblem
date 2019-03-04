package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

/**
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。

现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。

合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。

例子 1:

Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], 
			["John", "johnnybravo@mail.com"], 
			["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
			["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
		 ["John", "johnnybravo@mail.com"], 
		 ["Mary", "mary@mail.com"]]
Explanation: 
  第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。 
  第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
  我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
  ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。

注意：

accounts的长度将在[1，1000]的范围内。
accounts[i]的长度将在[1，10]的范围内。
accounts[i][j]的长度将在[1，30]的范围内。
 * @author liang
 *
 */
public class AccountsMerge_721 {

	/**
	 * 设置它的根节点是他自己；让每一组邮箱的第二个邮箱开始后所有邮箱 都指向第一个邮箱为root；将每个邮箱放入它根节点带领的并查集中；将并查集与邮箱集合整合，返回结果
	 * @param accounts
	 * @return
	 */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String,String> root = new HashMap<>();//key为某个邮箱，value为这个邮箱所指向根邮箱root
        HashMap<String,String> owner = new HashMap<>();//key为某个邮箱，value为邮箱的拥有者
        HashMap<String,HashSet<String>> m = new HashMap<String,HashSet<String>>();//并查集，根邮箱对应它的子节点
        //第一步，设置它的根节点是他自己
        for(List<String> account:accounts) {
        	for(int i=1;i<account.size();i++) {
        		root.put(account.get(i), account.get(i));//第一步，设置它的根节点是他自己
        		owner.put(account.get(i), account.get(0));//设置它的拥有者 是第一个元素
        	}
        }
        //第二步，让每一组邮箱的第二个邮箱开始后所有邮箱 都指向第一个邮箱为root
        for(List<String> account:accounts) {
        	String sRoot = find(account.get(1),root);
        	for(int i=2;i<account.size();i++) {
        		root.put(find(account.get(i),root),sRoot);//设置当前邮箱的根节点为sRoot
        	}
        }
        //第三步，将每个邮箱放入它根节点带领的并查集中
        for(List<String> account:accounts) {
        	for(int i=1;i<account.size();i++) {
        		String ro = find(account.get(i),root);
        		if(!m.containsKey(ro)) {
        			m.put(ro, new HashSet<String>());
        		}
        		m.get(ro).add(account.get(i));
        		//m.getOrDefault(find(account.get(i),root), new HashSet<String>()).add(account.get(i));
        	}
        }
        //第四步，将并查集与邮箱集合整合，返回结果
        for(java.util.Map.Entry<String,HashSet<String>> a:m.entrySet()) {
        	List<String> ress = new ArrayList<String>();
        	String own = owner.get(a.getKey());
        	ress.add(own);
        	ress.addAll(a.getValue());
        	res.add(ress);//这句居然忘了写
        }
        return res;
    }
    
    //根据邮箱找到它的根节点
	private String find(String account, HashMap<String, String> root) {
		// TODO Auto-generated method stub
		return root.get(account) == account?account:find(root.get(account),root);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		List<String> a1= new ArrayList<>();
		a1.add("John");
		a1.add("johnsmith@mail.com");
		a1.add("john_newyork@mail.com");
		List<String> a2= new ArrayList<>();
		a2.add("John");
		a2.add("johnsmith@mail.com");
		a2.add("john00@mail.com");
		List<String> a3= new ArrayList<>();
		a3.add("Mary");
		a3.add("mary@mail.com");
		List<String> a4= new ArrayList<>();
		a4.add("John");
		a4.add("johnnybravo@mail.com");
		List<List<String>>  a = new ArrayList<List<String>>();
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		AccountsMerge_721 aa = new AccountsMerge_721();
		aa.accountsMerge(a);
	}

}
