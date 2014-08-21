#include "base_include.h"
#include "random_list_node.h"

class CopyListWithRandomPointer {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode *token = new RandomListNode(0);
        token->next = head;
        head = token;
        for (RandomListNode *curr = head->next; curr != nullptr; ) {
            RandomListNode *post = curr->next;
            curr->next = new RandomListNode(curr->label);
            curr->next->next = post;
            curr = post;
        }
        for (RandomListNode *curr = head->next; curr != nullptr; curr = curr->next->next) {
            if (curr->random != nullptr) {
                curr->next->random = curr->random->next;
            } else {
                curr->next->random = nullptr;
            }
        }
        RandomListNode *copy_head = new RandomListNode(0);
        RandomListNode *copy_tail = copy_head;
        for (RandomListNode *curr = head->next; curr != nullptr; curr = curr->next) {
            RandomListNode *post = curr->next->next;
            copy_tail->next = curr->next;
            copy_tail = copy_tail->next;
            curr->next = post;
        }
        head = head->next;
        delete token;
        token = copy_head;
        copy_head = copy_head->next;
        delete token;
        return copy_head;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
