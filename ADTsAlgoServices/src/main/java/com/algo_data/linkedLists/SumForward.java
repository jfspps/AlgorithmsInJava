package com.algo_data.linkedLists;

/**
 * The overall process:
 * 1. Deduce the length of list. If the length is odd then the first operand will be assigned as longer.
 * 2. Advance the firstOperand and secondOperand pointers:
 *   (a) If odd length, advance secondOperand length/2 + 1 places forward and build multiplier 10^(length/2)
 *   (b) If even length, advance secondOperand length/2 places and build multiplier 10^(length/2)
 *   (c) In both cases, set firstOperand to head node
 * 3. Deduce the sum:
 *   (a) If odd length, sum = firstOperand.getData() * multiplier; then divide multiplier by ten and advance firstOperand.
 *   The proceed with 3(b)
 *   (b) If even length, sum = firstOperand.getData() * multiplier + secondOperand.getData() * multiplier; divide multiplier
 *   by ten and advance both references.
 *   Continue (a) or (b) while multiplier > 0
 * 4. Build a linked list of digits of the sum:
 *   (a) First digit is sum % 10; then take sum / multiplier; then multiplier / 10
 *   (b) Repeat step 4(a) while multiplier > 0
 * */

public class SumForward {

    private LinkedList<Integer> head;

    public SumForward(LinkedList<Integer> list) {
        this.head = list;
    }

    // time complexity is O(n)
    public LinkedList<Integer> sumForward(){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains only one node");
            return head;
        }

        // length() is O(n); avoid re-evaluating this and set to a variable
        int listLength = head.length();

        // integer division returns truncated values
        int largestNumberOfDigits = listLength - listLength/2;
        boolean isOddLength = (listLength % 2 != 0);

        System.out.println("Max. no. of digits per operand: " + largestNumberOfDigits);

        LinkedList<Integer> firstOperand = head;
        LinkedList<Integer> secondOperand = head;

        // advance secondOperand ref
        while (largestNumberOfDigits > 0){
            secondOperand = secondOperand.next;
            largestNumberOfDigits--;
        }

        // setup multiplier, a value which is "count" orders of magnitude greater than 1
        int count = listLength/2;
        int multiplier = 1;

        while (count > 0){
            multiplier *= 10;
            count--;
        }

        if (!isOddLength){
            multiplier /= 10;
        }

        // this is O(n)
        int sum = sumOperands(firstOperand, secondOperand, isOddLength, multiplier);

        // this is O(n)
        return printIntToList_forward(sum, multiplier);
    }

    // assume that the first operand is at most one digit longer than the second operand
    // time complexity is O(n)
    private int sumOperands(LinkedList<Integer> firstOperand, LinkedList<Integer> secondOperand,
                                             boolean isOddLength, int multiplier) {
        int sum = 0;

        // handle the larger operand, if applicable
        if (isOddLength){
            sum = firstOperand.getData()*multiplier;
            multiplier /= 10;
            firstOperand = firstOperand.next;
        }

        // process both operands at the same time
        while (multiplier > 0){
            sum += firstOperand.getData()*multiplier + secondOperand.getData()*multiplier;
            multiplier /= 10;
            firstOperand = firstOperand.next;
            secondOperand = secondOperand.next;
        }

        return sum;
    }

    // print sum in a linked list in forward direction
    // overall printing is O(n)
    private LinkedList<Integer> printIntToList_forward(int sum, int divisor) {

        if (divisor == 0){
            return new LinkedList<>(0);
        }

        // remove any leading zeros
        while (sum / divisor == 0){
            divisor /= 10;
            if (divisor == 0){
                return new LinkedList<>(0);
            }
        }

        LinkedList<Integer> sumList = new LinkedList<>(sum / divisor);
        int temp = (sum / divisor) * divisor;
        sum -= temp;
        divisor /= 10;

        while(divisor > 0){
            sumList.append(sum / divisor);
            temp = (sum / divisor) * divisor;
            sum -= temp;
            divisor /= 10;
        }

        return sumList;
    }
}