package GreedyStrategy;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }

            }
        }
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {

                if (candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }
        int res = 0;
        for (Integer num : candies) {
            res += num;
        }

        return res;
    }

    public int candyTemplate(int[] ratings){
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 1; i < ratings.length;i++){
            if(ratings[i]>ratings[i-1] && candies[i] <= candies[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        for(int i = ratings.length-1; i >0;i++){
            if(ratings[i] < ratings[i-1] && candies[i] >= candies[i-1] ){
                candies[i-1] = candies[i]+1;
            }
        }
        return Arrays.stream(candies).sum();
    }
}
