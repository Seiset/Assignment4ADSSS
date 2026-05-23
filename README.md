1)How graph size affects BFS and DFS performance?

As the graph size increases both BFS and DFS take longer to run.

2)Which traversal is faster in your experiments?
DFS was faster than BFS.

3)Do results match the expected complexity $O(V + E)$

Yes the results are follow the time complexity rule how you can see in the table below

4)How does graph structure affect traversal order?
BFS goes to the neighbors creating a queue which spread like an area DFS goes to the end of one line and spreas like a line 

5)When is BFS preferred over DFS?

when we need to find the shortest path  because bfs will eventually find it due to its mechanic 
but dfs might circle around the entire graph before hitting a node that was right next to the starting point.
6)What are the limitations of DFS?

DFS with big values might have a stack overflow because of recursive call
also It travels blindly down one track

Screenshots ![output](C:\Users\Alan\Pictures\Screenshots\Screenshot 2026-05-17 214246.png)
## A. Project Overview

### Description of Graph Structure
A graph is a fundamental non-linear data structure used to model relationships between pairs of objects. In this project, the graph structure is implemented as an **undirected graph**. This means that any relationship or link established between two points is inherently bidirectional—if point A connects to point B, then point B automatically connects back to point A.

### Explanation of Vertices and Edges
* **Vertices (Nodes):** These represent the standalone entities within the system. In this implementation, each vertex is uniquely identified by an integer ID ($0, 1, 2, \dots, V-1$).
* **Edges (Links):** These represent the connections between vertices. Because the network is undirected, an edge functions as a two-way street connecting a source vertex directly to a destination vertex.

### Overview of BFS and DFS
To analyze or look up information inside a graph, we must traverse it. This project focuses on the two primary strategies for graph traversal:
* **Breadth-First Search (BFS):** An algorithm that explores the graph level-by-level, moving outward from a starting point in concentric waves.
* **Depth-First Search (DFS):** An algorithm that plunges down a single path as deeply as possible, exploring branches to their absolute end before backtracking to find alternative routes.

---
## B. Class Descriptions

### Explanation of Vertex, Edge, and Graph Classes
* **`Vertex` Class:** Encapsulates a singular node. It contains a private integer field `id` to uniquely identify the vertex, a constructor to initialize this identifier, an essential getter method to retrieve it, and an overridden `toString()` method to assist with debugging and clean terminal printing.
* **`Edge` Class:** Models a connection between two discrete nodes. It holds private references to two `Vertex` objects—the `source` and the `destination`. It provides constructor mapping, accessor getters, and a formatted `toString()` representation.
* **`Graph` Class:** The core controller that ties the entire structure together. It dynamically maintains tracking vectors (`vertices[]` array and an array of `LinkedList` chains) and provides methods to systematically construct the graph (`addVertex`, `addEdge`), print its current map state (`printGraph`), and execute both search operations (`bfs`, `dfs`).

### Explanation of Adjacency List Representation
To store graph structures efficiently, this project utilizes an **Adjacency List** built via an array of linked lists (`LinkedList<Edge>[] adj`).

Instead of deploying a massive, mostly empty grid matrix (Adjacency Matrix), the index of the array itself maps directly to a vertex ID. Each slot in the array contains a lightweight `LinkedList` holding only the explicit `Edge` connections connected to that specific vertex. This optimization drastically saves system memory when handling sparse or randomly generated data networks.

---

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)

#### Step-by-step Explanation
1. Initialize a boolean tracking array (`visited[]`) to all `false` and create an empty FIFO (First-In, First-Out) `Queue`.
2. Mark the specified starting vertex as `true` in the `visited` array and add its ID to the queue.
3. While the queue is not empty, remove (poll) the item at the front of the queue and print it. This node is labeled as the current node $u$.
4. Loop through every `Edge` attached to $u$ inside `adj[u]` to fetch its neighbor IDs.
5. If a neighbor vertex has not yet been visited, immediately flip its status to `visited = true` and append it to the back of the queue.
6. Repeat steps 3–5 until the queue runs completely dry.

#### Use Cases
* Finding the absolute shortest path between two points on an unweighted layout (e.g., GPS navigation routing or finding the fewest degrees of separation in social networks).
* Web crawling peer networks to map out localized servers.

#### Time Complexity
* **Time Complexity:** $\mathcal{O}(V + E)$, where $V$ represents the total vertices initialized and $E$ represents the total edges processed. Every reachable vertex is pulled from the queue exactly once, and its adjacent edge list is scanned exactly once.

---

### 2. Depth-First Search (DFS)

#### Step-by-step Explanation
1. Instantiate a fresh boolean tracking array (`visited[]`) set entirely to `false`.
2. Run an outer sequential loop from $0$ to $V-1$. For any node encountered that evaluates to `false` in our tracking mask, invoke the recursive helper function `visitVertex(v, visited)`. This outer wrapper loop guarantees that disconnected graph segments are completely captured.
3. Inside `visitVertex(v)`: Immediately register the incoming node $v$ as `visited = true` and print its ID to the console.
4. Look up `adj[v]` and loop sequentially through all connected edge elements.
5. Extract the target neighbor's ID. If the neighbor has not been flagged as visited yet, recursively call `visitVertex` on that specific neighbor ID right away.
6. The program execution naturally dives all the way down the current branch until it hits a node whose neighbors are all flagged as `true`. It then backtracks upwards automatically via the system call stack to evaluate alternative paths.

#### Use Cases
* Solving maze layouts or puzzles that require exploring paths to their conclusion.
* Detecting cycles within topological sorting flows or dependency checking pipelines (e.g., build systems processing asset compiling orders).

#### Time Complexity
* **Time Complexity:** $\mathcal{O}(V + E)$. The recursive routine touches every node exactly once through the tracking array bounds, and walks through every edge allocation exactly once across the adjacency list structure.

---

## D. Experimental Results & Analysis

### Traversal Order Verification (Small Graph: 10 Vertices)

| Algorithm | Traversal Path Order Output |
| :--- | :--- |
| **BFS** | `0 9 6 2 5 3 1 7 8 4` |
| **DFS** | `0 9 2 1 3 7 8 4 5 6` |

### Performance Evaluation Matrix

| Graph Size ($V$) | BFS Execution Time (ns) | DFS Execution Time (ns) | Faster Algorithm |
| :---: | :---: | :---: | :---: |
| **10 Vertices** | 462,900 ns | 362,400 ns | **DFS** |
| **30 Vertices** | 86,000 ns | 990,700 ns | **BFS** *(JVM Spike)* |
| **100 Vertices** | 2,728,900 ns | 2,363,700 ns | **DFS** |



## E. Project "Bonus"
 Firstly edges now have weight i did it through adding new int inside edge class also changed constructor in the graph class 
I also added new method so my code wouldn't crush if i had wrong values like doubles   (AddEdge) 
I integrated dijkstra method It creates two tracking arrays (dist and visited) uses a simple loop to find the closest unvisited node updates the neighboring distances and prints the result block you verified earlier
