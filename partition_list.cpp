#include <iostream>
using namespace std;

//  Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// SOLUTION 1 --------------------------------------------------

class Solution
{
public:
    ListNode *partition(ListNode *head, int x)
    {
        if (!head)
            return head;

        ListNode *head1 = NULL;
        ListNode *head2 = NULL;
        ListNode *tail1 = NULL;
        ListNode *tail2 = NULL;

        while (head)
        {
            if (head->val < x)
            {
                if (!head1)
                {
                    head1 = new ListNode(head->val);
                    tail1 = head1;
                }
                else
                {
                    tail1->next = new ListNode(head->val);
                    tail1 = tail1->next;
                }
            }
            else
            {
                if (!head2)
                {
                    head2 = new ListNode(head->val);
                    tail2 = head2;
                }
                else
                {
                    tail2->next = new ListNode(head->val);
                    tail2 = tail2->next;
                }
            }

            head = head->next;
        }

        if (head1)
        {
            tail1->next = head2;

            return head1;
        }

        return head2;
    }
};

// SOLUTION 2 --------------------------------------------------

class Solution
{
public:
    ListNode *partition(ListNode *head, int x)
    {
        if (!head || !head->next)
            return head;

        ListNode *temp = head;
        ListNode *tail = head;
        ListNode *prev = NULL;
        int len = 1;

        while (tail->next)
        {
            tail = tail->next;
            len++;
        }

        while (temp && len && temp != tail)
        {
            if (temp->val >= x)
            {
                if (prev)
                {
                    prev->next = temp->next;
                }
                else
                {
                    head = temp->next;
                }
                tail->next = temp;
                tail = temp;
            }
            else
            {
                prev = temp;
            }

            len--;
            temp = temp->next;
        }

        if (tail)
            tail->next = NULL;

        return head;
    }
};