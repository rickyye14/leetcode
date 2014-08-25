#!/usr/bin/env python3

class CacheNode:
    def __init__(self, key, val):
        self.key    = key
        self.val    = val
        self.prev   = None
        self.next   = None

class CacheList:
    def __init__(self):
        self.head =

class LRUCache:
    def __init__(self, capacity):
        self.capacity   = capacity
        self.nums       = 0
        self.
