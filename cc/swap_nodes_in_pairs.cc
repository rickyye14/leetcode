#include "base_include.h"

class SwapNodesInPairs {
public:
    ListNode *swapPairs(ListNode *head) {
        ListNode *token = new ListNode(0);
        token->next = head;
        head = token;
        ListNode *curr = head;
        ListNode *post = head->next;
        ListNode *temp = NULL;
        while (post != NULL && post->next != NULL) {
            temp = post->next->next;
            curr->next = post->next;
            post->next = temp;
            curr->next->next = post;
            curr = post;
            post = post->next;
        }
        head = head->next;
        delete token;
        return head;
    }
};
