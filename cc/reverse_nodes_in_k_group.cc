#include "base_include.h"
#include "list_node.h"

class ReverseNodesInKGroup {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        ListNode *token = new ListNode(0);
        token->next = head;
        head = token;
<<<<<<< HEAD
        ListNode *tail = head;
        for ( ; ; ) {
=======
        for ( ; ; ) {
            ListNode *tail = head;
>>>>>>> cee0291085b1fc5c266c9f29c21db92032414aa3
            for (int i = 0; i < k && tail != NULL; ++i) {
                tail = tail->next;
            }
            if (NULL == tail) {
                break;
            }
<<<<<<< HEAD
            ListNode *prev = head;
            head = head->next;
            ListNode *post = tail->next;
            ListNode *rev_node = NULL;
            for (ListNode *ptr = head; ptr != post; ) {
            }
        }
    }
};
=======
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
>>>>>>> cee0291085b1fc5c266c9f29c21db92032414aa3
