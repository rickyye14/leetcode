#include "base_include.h"

class LRUCache {
private:
    struct CacheNode {
        int key;
        int value;
        CacheNode *prev;
        CacheNode *next;

        CacheNode():
            key(-1), value(-1), prev(nullptr), next(nullptr) {}

        CacheNode(int key, int value):
            key(key), value(value), prev(nullptr), next(nullptr) {}
    };
    CacheNode *head;
    CacheNode *tail;
    int num_nodes;
    int capacity;
    unordered_map<int, CacheNode *> hash;

public:
    LRUCache(int capacity) {
        head = new CacheNode();
        tail = new CacheNode();
        head->next = tail;
        tail->prev = head;
        num_nodes = 0;
        this->capacity = capacity;
    }

    int get(int key) {
        if (0 == num_nodes) {
            return -1;
        }
        CacheNode *ptr = hash[key];
        if (nullptr == ptr) {
            return -1;
        }
        ptr->prev->next = ptr->next;
        ptr->next->prev = ptr->prev;
        ptr->prev = head;
        ptr->next = head->next;
        ptr->prev->next = ptr;
        ptr->next->prev = ptr;
        return ptr->value;
    }

    void set(int key, int value) {
        if (capacity < 1) {
            return;
        }
        CacheNode *ptr = hash[key];
        if (nullptr == ptr) {
            ptr = new CacheNode(key, value);
            hash[key] = ptr;
        } else {
            ptr->value = value;
            ptr->prev->next = ptr->next;
            ptr->next->prev = ptr->prev;
            --num_nodes;
        }
        if (num_nodes == capacity) {
            CacheNode *ptr_rm = tail->prev;
            hash[ptr_rm->key] = nullptr;
            ptr_rm->prev->next = ptr_rm->next;
            ptr_rm->next->prev = ptr_rm->prev;
            delete ptr_rm;
            --num_nodes;
        }
        ptr->next = head->next;
        ptr->prev = head;
        ptr->next->prev = ptr;
        ptr->prev->next = ptr;
        ++num_nodes;
    }
};

int main(int argc, char *argv[]) {
    LRUCache solver(1);
    solver.set(2, 1);
    cout << solver.get(2) << endl;
    return 0;
}
