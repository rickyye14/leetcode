#include "base_include.h"
#include "list_node.h"

class ReverseNodesInKGroup {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        ListNode *token = new ListNode(0);
        token->next = head;
        head = token;
        ListNode *tail = head;
        for ( ; ; ) {
            for (int i = 0; i < k && tail != NULL; ++i) {
                tail = tail->next;
            }
            if (NULL == tail) {
                break;
            }
            ListNode *prev = head;
            head = head->next;
            ListNode *post = tail->next;
            ListNode *rev_node = NULL;
            for (ListNode *ptr = head; ptr != post; ) {
            }
        }
    }
};
