import java.util.*;

class demo {
    private int V;
    private LinkedList<Integer>[] adjList;

    //Konstruktor
    demo(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList();
        }
    }

    // Menambahkan edge pada graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    //Metode rekursif untuk DFS
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = adjList[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Metode DFS
    void DFS(int v) {
        boolean[] visited = new boolean[V];

        DFSUtil(v, visited);
    }

    //Metode BFS
    void BFS(int v) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> it = adjList[v].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String args[]) {
        demo graph = new demo(18);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2,1);
        graph.addEdge(2, 5);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5,9);
        graph.addEdge(9,5);
        graph.addEdge(5,7);
        graph.addEdge(9,8);
        graph.addEdge(8,9);
        graph.addEdge(8,11);
        graph.addEdge(4,6);
        graph.addEdge(6,7);
        graph.addEdge(7,6);
        graph.addEdge(7,11);
        graph.addEdge(11,7);
        graph.addEdge(11,10);

        System.out.println("\nBreadth First Search (BFS) Traversal :");
        graph.BFS(1);

        System.out.println("\nDepth Firsh Search (DFS) Traversal: ");
        graph.DFS(1);

    }
}