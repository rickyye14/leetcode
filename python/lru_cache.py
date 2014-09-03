#!/usr/bin/env python3

class CacheNode:
    def __init__(self, key, val):
        self.key    = key
        self.val    = val
        self.prev   = None
        self.post   = None

class CacheList:
    def __init__(self):
        self.head       = CacheNode(0, 0)
        self.tail       = CacheNode(0, 0)
        self.head.post  = self.tail
        self.tail.prev  = self.head
        self.num_nodes  = 0

    def add_first(self, node):
        temp = self.head.post
        node.prev = self.head
        node.post = temp
        self.head.post = node
        temp.prev = node
        self.num_nodes += 1

    def delete(self, node):
        node.prev.post = node.post
        node.post.prev = node.prev
        self.num_nodes -= 1

    def delete_last(self):
        node = self.tail.prev
        self.delete(node)
        return node

    def size(self):
        return self.num_nodes

    def empty(self):
        return self.num_nodes == 0

class LRUCache:
    def __init__(self, capacity):
        self.capacity   = capacity
        self.cache_list = CacheList()
        self.track      = {}

    def get(self, key):
        if self.cache_list.empty() or key not in self.track:
            return -1
        node = self.track[key]
        self.cache_list.delete(node)
        self.cache_list.add_first(node)
        return node.val

    def set(self, key, val):
        if self.capacity < 1:
            return
        node = None
        if key not in self.track:
            node = CacheNode(key, val)
            self.track[key] = node
        else:
            node = self.track[key]
            node.val = val
            self.cache_list.delete(node)
        if self.cache_list.size() == self.capacity:
            removed = self.cache_list.delete_last()
            del self.track[removed.key]
        self.cache_list.add_first(node)

def main():
    lru_cache = LRUCache(3)
    lru_cache.set(1, 1)
    lru_cache.set(2, 2)
    lru_cache.set(3, 3)
    lru_cache.set(4, 4)
    print(lru_cache.get(4))
    print(lru_cache.get(3))
    print(lru_cache.get(2))
    print(lru_cache.get(1))
    lru_cache.set(5, 5)
    print(lru_cache.get(1))
    print(lru_cache.get(2))
    print(lru_cache.get(3))
    print(lru_cache.get(4))
    print(lru_cache.get(5))

if __name__ == '__main__':
    main()
