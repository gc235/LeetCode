package space.worldhu.practice;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hushicheng
 * @date 2020/7/29
 */
public class MinimalSteps {

    /**
     * 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
     *
     * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
     *
     * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
     *
     * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
     *
     * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
     *
     * 示例 1：
     *
     * 输入： ["S#O", "M..", "M.T"]
     *       S#O
     *       M..
     *       M.T
     * 输出：16
     *
     * 解释：最优路线为： S->O, cost = 4, 去搬石头 O->第二行的M, cost = 3, M机关触发 第二行的M->O, cost = 3, 我们需要继续回去 O 搬石头。 O->第三行的M, cost = 4, 此时所有机关均触发 第三行的M->T, cost = 2，去T点拿宝藏。 总步数为16。
     *
     * 示例 2：
     *
     * 输入： ["S#O", "M.#", "M.T"]
     *      S#O
     *      M.#
     *      M.T
     * 输出：-1
     *
     * 解释：我们无法搬到石头触发机关
     *
     * 示例 3：
     *
     * 输入： ["S#O", "M.T", "M.."]
     *     S#O
     *     M1.T
     *     M2..
     *     T -> M2 -> O -> M1 -> O -> S
     * 输出：17
     *
     * 解释：注意终点也是可以通行的。
     *
     * 限制：
     *
     * 1 <= maze.length <= 100
     * 1 <= maze[i].length <= 100
     * maze[i].length == maze[j].length
     * S 和 T 有且只有一个
     * 0 <= M的数量 <= 16
     * 0 <= O的数量 <= 40，题目保证当迷宫中存在 M 时，一定存在至少一个 O 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xun-bao
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minimalSteps(String[] maze) {
        int[] sIndex = new int[2];
        List<int[]> mIndexList = new ArrayList<>();
        List<int[]> oIndexList = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if ('S' == maze[i].charAt(j)) {
                    sIndex[0] = i;
                    sIndex[1] = j;
                } else if ('M' == maze[i].charAt(j)) {
                    mIndexList.add(new int[]{i, j});
                } else if ('O' == maze[i].charAt(j)) {
                    oIndexList.add(new int[]{i, j});
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        JSONArray array = JSONUtil.readJSONArray(new File("C:\\Users\\Hu\\Desktop\\x.json"), Charset.defaultCharset());
        JSONObject jsonObject = array.getJSONObject(0);
        Map<String, String> params = new HashMap<>();

        System.out.println("Map<String, String> params = new HashMap<>();");
        for (String key :
                jsonObject.keySet()) {
            System.out.println("params.put(\"" + key + "\",\"" + jsonObject.getStr(key) + "\");");
        }
    }
}
