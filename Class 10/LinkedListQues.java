class Main {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr;
            curr = forw;
        }

        return prev;
    }
    public int length(ListNode head) {
        if (head == null)
            return 0;

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    // Codes of this Class : 
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode slow = head, fast = head;
        while (n-- > 0)
            fast = fast.next;

        if (fast == null) {
            ListNode rn = head;
            head = head.next;
            rn.next = null;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rn = slow.next;
        slow.next = rn.next;
        rn.next = null;
        return head;
    }

    public void removeNthFromEnd_followUp(ListNode head, int n) {
        if (head == null)
            return;

        ListNode slow = head, fast = head;
        while (n-- > 0)
            fast = fast.next;

        if (fast == null) {
            head.val = head.next.val;
            ListNode rn = slow.next;
            slow.next = rn.next;
            rn.next = null;
            return;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rn = slow.next;
        slow.next = rn.next;
        rn.next = null;
    }

    // 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;

        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);

            prev = prev.next;
            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = dummy.next;
        dummy.next = null;

        head = reverseList(head);
        return head;
    }

    // pepcoding

    public int isBiggerList(ListNode l1, ListNode l2) {
        int len1 = length(l1), len2 = length(l2);
        if (len1 == len2) {
            ListNode c1 = l1, c2 = l2;
            while (c1 != null) {
                if (c1.val != c2.val)
                    return c1.val - c2.val;
                c1 = c1.next;
                c2 = c2.next;
            }
        }

        return len1 - len2;
    }

    // My Approach : in Subtraction, which is greater can be determined, if in the end borrow is still -1
    public ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (isBiggerList(l1, l2) < 0) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;

        int borrow = 0;
        while (c1 != null || c2 != null) {
            int val = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
            if (val < 0) {
                val += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            prev.next = new ListNode(val);

            prev = prev.next;
            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = dummy.next;
        dummy.next = null;

        head = reverseList(head);
        c1 = head;

        while (c1.next != null) {
            if (c1.val != 0) {
                break;
            }
            c1 = c1.next;
        }

        return c1;
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head, curr = head.next;

        while (curr != null) {
            if (prev.val != curr.val) {
                prev.next = curr;
                prev = prev.next;
            }

            curr = curr.next;
        }
        prev.next = curr;

        return head;
    }

    public ListNode removeDuplicates_02(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1), prev = dummy, curr = head.next;
        prev.next = head;

        while (curr != null) {
            boolean isSequence = false;
            while (curr != null && prev.next.val == curr.val) {
                isSequence = true;
                curr = curr.next;
            }

            if (isSequence) {
                prev.next = curr;
            } else {
                prev = prev.next;
            }

            if (curr != null)
                curr = curr.next;
        }

        return dummy.next;
    }
}