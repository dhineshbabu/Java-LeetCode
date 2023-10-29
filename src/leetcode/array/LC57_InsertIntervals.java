package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57_InsertIntervals {
    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        // Create result list
        List<int[]> resultList = new ArrayList<>();
        int i=0;
        int n = intervals.length;

        while(i<n && intervals[i][1] < newInterval[0]) {
            resultList.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the expanded interval to the result
        resultList.add(newInterval);

        while(i<n) {
            resultList.add(intervals[i]);
            i++;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        Arrays.stream(insertIntervals(intervals, newInterval)).map(row -> Arrays.toString(row)).forEach(System.out::print);
    }
}
