package LeetCodeContestQue;

import java.util.*;
/*3528. Unit Conversion I
Solved
Medium
Companies
Hint
There are n types of units indexed from 0 to n - 1. You are given a 2D integer array conversions of length n - 1, where conversions[i] = [sourceUniti, targetUniti, conversionFactori]. This indicates that a single unit of type sourceUniti is equivalent to conversionFactori units of type targetUniti.

Return an array baseUnitConversion of length n, where baseUnitConversion[i] is the number of units of type i equivalent to a single unit of type 0. Since the answer may be large, return each baseUnitConversion[i] modulo 109 + 7.



Example 1:

Input: conversions = [[0,1,2],[1,2,3]]

Output: [1,2,6]

Explanation:

Convert a single unit of type 0 into 2 units of type 1 using conversions[0].
Convert a single unit of type 0 into 6 units of type 2 using conversions[0], then conversions[1].

Example 2:

Input: conversions = [[0,1,2],[0,2,3],[1,3,4],[1,4,5],[2,5,2],[4,6,3],[5,7,4]]

Output: [1,2,3,8,10,6,30,24]

Explanation:

Convert a single unit of type 0 into 2 units of type 1 using conversions[0].
Convert a single unit of type 0 into 3 units of type 2 using conversions[1].
Convert a single unit of type 0 into 8 units of type 3 using conversions[0], then conversions[2].
Convert a single unit of type 0 into 10 units of type 4 using conversions[0], then conversions[3].
Convert a single unit of type 0 into 6 units of type 5 using conversions[1], then conversions[4].
Convert a single unit of type 0 into 30 units of type 6 using conversions[0], conversions[3], then conversions[5].
Convert a single unit of type 0 into 24 units of type 7 using conversions[1], conversions[4], then conversions[6].*/
public class UnitConversion_26Apr {
        private static final int MOD = 1_000_000_007;
        /*class Edge {
            int start;
            int end;
            int data;

            Edge(int start,int end,int data){
                this.start = start;
                this.end = end;
                this.data = data;
            }
        }
        public int[] baseUnitConversions(int[][] conversions) {
            List<Edge> edges = new ArrayList<>();
            for (int[] conv : conversions) {
                edges.add(new Edge(conv[0], conv[1], conv[2]));
            }
            int n = conversions.length + 1;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            res[0] = 1;

            Queue<Integer> qu = new LinkedList<>();
            qu.offer(0);

            while (!qu.isEmpty()) {

                int curr = qu.poll();
                for (Edge e : edges) {
                    if (e.start == curr && res[e.end] == -1) {
                        res[e.end] = (int) ((1L * res[curr] * e.data) % MOD);
                        qu.offer(e.end);
                    }
                }
            }
            return res;
        }*/ // above geetting TLE for some of the cases

    class Edge {
        int dst;
        int data;

        Edge(int dst,int data){
            this.dst = dst;
            this.data = data;
        }
    }
    public int[] baseUnitConversions(int[][] conversions) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] conv: conversions){
            int src = conv[0],dst = conv[1],data = conv[2];
            graph.computeIfAbsent(src,k -> new ArrayList<>()).add(new Edge(dst,data));
        }
        int n = conversions.length + 1;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        res[0] = 1;

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);

        while(!qu.isEmpty()){

            int curr = qu.poll();
            if (!graph.containsKey(curr)) continue; // no outgoing edges

            for(Edge e:graph.get(curr)){
                if(res[e.dst] == -1){ // // not visited yet
                    res[e.dst] = (int)((1L * res[curr] * e.data) % MOD);
                    qu.offer(e.dst);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
            int[][] arr = new int[2][3];
            arr[0] = new int[]{0,1,2};
            arr[1] = new int[]{1,2,3};

        int[] ans = new UnitConversion_26Apr().baseUnitConversions(arr);
        System.out.println(Arrays.toString(ans));
        }
}
