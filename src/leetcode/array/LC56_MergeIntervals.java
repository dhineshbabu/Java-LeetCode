package leetcode.array;

import java.util.*;

public class LC56_MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval: intervals) {
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval =  interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals ={{1,3},{2,6},{8,10},{15,18}};
        Arrays.stream(mergeIntervals(intervals)).map(i -> Arrays.toString(i)).forEach(System.out::print);
    }
}
