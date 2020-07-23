package space.worldhu.practice;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hushicheng
 * @date 2020/5/25
 */
public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int dayx = (int) Math.ceil((double) costs[1] / (double) costs[0]);
        int dayy = (int) Math.ceil((double) costs[2] / (double) costs[0]);
        //从days0开始算7天内有几天旅行日，大于等于dayx，买七天通行证
        //从上一次买的通行证结束日的第二天开始新一轮计算
        int count = 0;


        return 0;
    }

    public int minCost(int start, int count, int[] days, int dayx, int dayy, int[] costs) {
        if (start > days.length) {
            return count;
        }
        int endDay = days[start] + 7;
        int day7 = 0;
        int day30 = 0;
        for (int i = start; i < 7; i++) {
            if (days[i] >= days[start] && days[i] < endDay) {
                day7++;
            }
        }
        if (day7 >= dayx) {
            count += costs[1];
            start += day7;
        }
        for (int i = start; i < 30; i++) {
            if (days[i] >= days[start] && days[i] < endDay) {
                day30++;
            }
        }
        if (day30 >= dayy) {
            count += costs[2];
            start += day30;
        }
        return 0;
    }
}
