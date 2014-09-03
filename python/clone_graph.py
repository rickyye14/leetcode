#/usr/bin/env python3

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if node is None:
            return None
        track = dict()
        track[node] = UndirectedGraphNode(node.label)
        queue = list()
        queue.append(node)
        while queue:
            curr = queue.pop(0)
            for neighbor in curr.neighbors:
                if neighbor not in track:
                    track[neighbor] = UndirectedGraphNode(neighbor.label)
                    queue.append(neighbor)
            for neighbor in curr.neighbors:
                track[curr].neighbors.append(track[neighbor])
        return track[node]

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
