#include "base_include.h"
#include "list_node.h"

class ReverseNodesInKGroup {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        ListNode *token = new ListNode(0);
        token->next = head;
        head = token;
        for ( ; ; ) {
            ListNode *tail = head;
            for (int i = 0; i < k && tail != NULL; ++i) {
                tail = tail->next;
            }
            if (NULL == tail) {
                break;
            }
            ListNode *post = tail->next;
            ListNode *prev = NULL;
            for (ListNode *ptr = head->next; ptr != post; ) {
                ListNode *temp = ptr->next;
                ptr->next = prev;
                prev = ptr;
                ptr = temp;
            }
            ListNode *next_head = head->next;
            head->next->next = post;
            head->next = tail;
            head = next_head;
        }
        head = token->next;
        delete token;
        return head;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
