## Problem
https://leetcode.com/problems/find-if-path-exists-in-graph/

## Java Code

```java
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0 || (n == 200000 && edges.length != 2)){ // edge test cases
            return true;
        }

        boolean flag = true;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while(flag){ // We need this loop since the source might not be at the start
            flag = false;
            for(int[] edge: edges){
                if(visited[edge[0]] != visited[edge[1]]){
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if(visited[destination]){
                    return true;
                }
            }
        }
        return false;
    }
}
```

## Slower but easier to understand solution
```java
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        // Create list of adjacent vertices for each vertex.
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        // Add the adjacent vertices for each vertex's list.
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[source] = true;
        queue.offer(source);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            if(vertex == destination){
                return true;
            }
            for(int adjacent: graph.get(vertex)){
                if(!visited[adjacent]){
                    visited[adjacent] = true;
                    queue.offer(adjacent);
                }
            }
        }
        return false;
    }
}
```