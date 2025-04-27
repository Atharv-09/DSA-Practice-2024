package LeetCodeContestQue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCoveredBuildings {

    public static int countCoveredBuildings(int n, int[][] buildings) {

        int[][] build = new int[n+1][n+1];
        for (int[] r : build)
            Arrays.fill(r, 0);

        for(int i=0;i<buildings.length;i++){
            build[buildings[i][0]][buildings[i][1]] = 1;
        }

        int count = 0;
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                int top = build[i-1][j];
                int bot = build[i+1][j];
                int left = build[i][j-1];
                int right = build[i][j+1];

                if(build[i][j] == 1 && top == 1 && bot == 1 && left == 1 && right == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static int countCoveredBuildings2(int n, int[][] buildings) {

        Set<String> set = new HashSet<>();
        for(int[] a: buildings){
            set.add(a[0]+","+a[1]);
        }
        int count = 0;

        for(int[] b: buildings){
            int x = b[0];
            int y = b[1];

            if(set.contains((x-1)+","+y) &&
                    set.contains(x+","+(y-1)) &&
                    set.contains((x+1)+","+y) &&
                    set.contains(x+","+(y+1)))
                count++;

        }
        return count;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] buildings = {
                {2, 2},
                {2, 3},
                {2, 4},
                {3, 2},
                {3, 3},
                {3, 4},
                {4, 2},
                {4, 3},
                {4, 4}
        };
        System.out.println(CountCoveredBuildings.countCoveredBuildings2(n,buildings));
    }
}
