package com.jincou.apollo.leetcode;

/**
 * @author zhouguilong6
 * @date 2025/3/11 10:01
 */
import java.util.*;

public class IntervalUnion {
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        intervals.sort((a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                result.add(currentInterval);
                currentInterval = interval;
            }
        }

        result.add(currentInterval);

        return result;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{8, 10});
        intervals.add(new int[]{15, 18});
        List<int[]> mergedIntervals = mergeIntervals(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
