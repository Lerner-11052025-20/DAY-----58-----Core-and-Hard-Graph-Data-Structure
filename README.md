# DAY-----58-----Core-and-Hard-Graph-Data-Structure

📂 Repository Structure:
📂 DSA-Java-Core-Graph
 ┣ 📂 Day-54-Heaps
 ┃ ┗ 📄 PriorityQueueExample.java
 ┣ 📂 Day-58-Graphs
 ┃ ┣ 📄 DFS.java
 ┃ ┣ 📄 BFS.java
 ┃ ┣ 📄 Dijkstra.java
 ┃ ┣ 📄 KruskalMST.java
 ┃ ┣ 📄 UnionFind.java
 ┃ ┣ 📄 TopoSort.java
 ┣ 📄 README.md
 ┗ 📄 .gitignore
🔑 What You Will Get Inside This Repo:
🚩 Core Java Graph Techniques
Adjacency List / Matrix

DFS / BFS (Recursive & Iterative)

Union-Find (Disjoint Set)

Topological Sorting (Kahn’s + DFS)

Minimum Spanning Tree (Kruskal / Prim)

Shortest Path (Dijkstra / Bellman-Ford)

Bipartite, Bridges, Cycles, Islands

💡 Deep Explanations
Code is highly commented 📝

Every problem has intuition + approach

Interview-safe patterns

🔥 Sample Problem Roadmap:
🗓️ Day	🔥 Topic	🚩 Problem
54	Heaps	PriorityQueue, Kth Largest
58	Graph Core	BFS, DFS, Dijkstra, MST, TopoSort
59+	Graph Advanced	Bipartite, Bridges, Union-Find

📊 Why This Repo?
pgsql
Copy
Edit
🔔 Systematic Folder-Wise
🚩 Beginner to Pro Level
🚀 100% Interview Focused
💪 Clean Java Solutions
💪 Power Message for You:
"Graph DSA is not hard. It's just misunderstood. Once mastered, it opens 30% of the interview gates."
– ⚡ Consistent Coders Rulebook ⚡

🏁 Let’s Conquer Graphs in Java, Together. 🏁
#GraphMaster #DSAWithJava #ConsistentCoding #DSA58

🔥 DAY-58 — Core & Hard Graph Data Structure (In-Depth with Java) 🔥
#DSA #Graph #LevelUp #Java #CoreConcepts

📚 What is a Graph?
A graph is a collection of nodes (vertices) and edges that connect pairs of nodes.
Graphs can model networks like social media, maps, internet routing, etc.

✅ Types of Graphs:
Type	Description
Directed Graph (DG)	Edge has direction (A ➔ B)
Undirected Graph (UG)	Edge has no direction (A — B)
Weighted Graph	Edges have weights (distance, cost)
Unweighted Graph	Edges have no weights
Cyclic / Acyclic	Presence or absence of cycles
Connected / Disconnected	Graph is fully or partially connected

🔥 Graph Representations in Java:
1️⃣ Adjacency List (Most Common)
java
Copy
Edit
ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

// Example: Creating list for 5 vertices
for (int i = 0; i < 5; i++) {
    graph.add(new ArrayList<>());
}

// Adding edge from 0 to 1
graph.get(0).add(1);
graph.get(1).add(0);  // If undirected
2️⃣ Adjacency Matrix
java
Copy
Edit
int[][] graph = new int[5][5];  // 5 vertices
graph[0][1] = 1;
graph[1][0] = 1;  // If undirected
🛠 Core Algorithms You MUST Know:
Algorithm	Purpose	Complexity
BFS (Breadth-First Search)	Shortest path (Unweighted)	O(V + E)
DFS (Depth-First Search)	Traversal, Cycle detection	O(V + E)
Dijkstra	Shortest path (Weighted, +ve)	O(V log V + E)
Bellman-Ford	Shortest path (Negatives allowed)	O(VE)
Floyd-Warshall	All-pairs shortest path	O(V³)
Kruskal	Minimum Spanning Tree (MST)	O(E log E)
Prim's	Minimum Spanning Tree (MST)	O(V²) or O(E log V)
Topo Sort	Ordering (DAG)	O(V + E)
Union Find	Connected Components / Cycle Detection	O(α(N))

💡 Why Graphs are Hard?
Multiple representations

Edge cases (Disconnected, Cycles, Negative weights)

Many variants (DFS vs BFS, Directed vs Undirected, Weighted vs Unweighted)

🚀 Important Interview Patterns:
Problem Type	Common Approach
Shortest Path (Unweighted)	BFS
Shortest Path (Weighted)	Dijkstra / Bellman
Detect Cycles (Undirected)	DFS / Union Find
Detect Cycles (Directed)	DFS with recursion stack
Number of Islands / Connected Comp.	BFS / DFS / Union Find
Topological Sort	Kahn’s Algo / DFS
MST	Kruskal / Prim

📌 Core Java Implementations (Examples):
✅ DFS (Recursive):
java
Copy
Edit
void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited, graph);
        }
    }
}
✅ BFS (Queue based):
java
Copy
Edit
Queue<Integer> queue = new LinkedList<>();
boolean[] visited = new boolean[V];

queue.add(0);
visited[0] = true;

while (!queue.isEmpty()) {
    int node = queue.poll();
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.add(neighbor);
        }
    }
}
🏆 Hard-Level Problems You MUST Solve (Java, Leetcode/GFG):
Problem	Concept
Detect Cycle in Directed / Undirected	DFS / Union Find
Number of Islands	BFS / DFS / Union Find
Word Ladder	BFS
Alien Dictionary (Topo Sort)	Graph + Kahn’s Algo
Minimum Spanning Tree	Kruskal / Prim
Course Schedule I / II (Topo Sort)	DAG Cycle / Ordering
Dijkstra’s Shortest Path	Priority Queue
Bellman-Ford	Negative Cycle
Bipartite Graph	BFS / Coloring
Bridges in Graph (Tarjan's Algo)	DFS

🔥 Day-58 Summary Checklist:
☑ Graph Theory Basics
☑ Java Implementations
☑ BFS, DFS
☑ Union Find, Dijkstra
☑ MST Algorithms
☑ Topological Sort
☑ Practice Hard Problems

💪 Final Motivation:
"Graph master kar liya? Interview me 30% confidence boost ho gaya!"
– DSA Rulebook for Warriors 📜
