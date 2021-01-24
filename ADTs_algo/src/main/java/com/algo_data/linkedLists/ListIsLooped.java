package com.algo_data.linkedLists;

public class ListIsLooped<T> {

    LinkedList<T> head;

    public ListIsLooped(LinkedList<T> head) {
        this.head = head;
    }

    // time complexity is O(n + nm) or simply O(nm), where n is the loop size and m the mth Node where the loop begins
    public LinkedList<T> getIntersection(){
        // slow and fast pointers to navigate until fast.next is null

        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List built with one node only and is not looped");
            return null;
        }

        LinkedList<T> slow = head;
        LinkedList<T> fast = head.next;

        // potentially O(n) at worst
        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                System.out.println("List is not looped");
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow == fast, both would be somewhere in the loop by now
        // move "slow" ahead one place and keep "fast" in place as a permanent marker within the loop
        slow = slow.next;

        LinkedList<T> outsideLoop = head;

        // move "outsideLoop" while looping "slow" ("fast" stops "slow" looping ad infinitum)
        // this would be O(nm), where n is the loop size and m the mth Node where the loop begins
        while (outsideLoop != fast){
            while (slow != fast){
                if (slow == outsideLoop){
                    System.out.println("Loop starts at value: " + outsideLoop.getData());
                    return outsideLoop;
                }
                slow = slow.next;
            }
            outsideLoop = outsideLoop.next;

            if (outsideLoop == fast){
                break;
            }
            slow = slow.next;
        }

        // when outside loop found "fast" before "slow"
        System.out.println("Loop starts at value: " + outsideLoop.getData());
        return outsideLoop;
    }
}
