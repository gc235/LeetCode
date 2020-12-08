package space.worldhu.streams;

import java.util.Comparator;
import space.worldhu.util.Const;

/**
 * @author hushicheng
 * @date 2020/11/12
 */
public class SortedComparator {

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fileToWordsRegexp = new FileToWordsRegexp(Const.defFilePath);
        fileToWordsRegexp.stream()
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
