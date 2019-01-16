package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 638. 大礼包
 * 在LeetCode商店中， 有许多在售的物品。

然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。

现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。

每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。

任意大礼包可无限次购买。

示例 1:

输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
输出: 14
解释: 
有A和B两种物品，价格分别为¥2和¥5。
大礼包1，你可以以¥5的价格购买3A和0B。
大礼包2， 你可以以¥10的价格购买1A和2B。
你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
示例 2:

输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
输出: 11
解释: 
A，B，C的价格分别为¥2，¥3，¥4.
你可以用¥4购买1A和2B，也可以用¥9购买2A，2B和1C。
你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
说明:

最多6种物品， 100种大礼包。
每种物品，你最多只需要购买6个。
你不可以购买超出待购清单的物品，即使更便宜。
 * @author liang
 *
 */
public class ShoppingOffers_638 {

	/**
	 * 循环判断special里的组合是否符合needs里的数量，符合就dfs接着遍历special，用一个新的List<Integer> 存储needs-special后的各个数量，用一个map保存每次dfs后的（组合，最小价格）组合
	 * @param price 每个商品的价格
	 * @param special  商品组合的价格
	 * @param needs	需要的每个商品数量
	 * @return
	 */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>,Integer>();
        return helper(price,special,needs,needs.size(),map);
    }
    
	private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int size,
			HashMap<List<Integer>, Integer> map) {
		// TODO Auto-generated method stub
		if(map.containsKey(needs))
			return map.get(needs);
		int minPrice = 0;
		//不用套餐价格
		for(int i=0;i<size;i++) {
			minPrice+=needs.get(i)*price.get(i);
		}
		//用套餐
		for(List<Integer> meal:special) {
			boolean canUseMeal = true;
			int thisPrice =  0;//用套餐的这一组的价格
			for(int i=0;i<size;i++) {
				if(needs.get(i)<meal.get(i)) {//套餐内容超过需要的数目
					canUseMeal = false;
					break;
				}
			}
			if(canUseMeal) {//找到了当前符合的meal
				ArrayList<Integer> closeNeeds = new ArrayList<>(needs);
				for(int i=0;i<size;i++) {
					closeNeeds.set(i, needs.get(i) - meal.get(i));//删去一组meal的数
				}
				// meal.get(size)是这个套餐的价格
				thisPrice = meal.get(size)+helper(price,special,closeNeeds,size,map);
				if(thisPrice<minPrice){
					minPrice=thisPrice;
				}
			}
		}
		map.put(needs, minPrice);//存储当前dfs的needs剩余数量的最小价格组合
		return minPrice;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
