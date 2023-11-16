/*
Problem: 682. Baseball Game

You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is
one of the following:

- An integer x.
    - Record a new score of x.
- '+'.
    - Record a new score that is the sum of the previous two scores.
- 'D'.
    - Record a new score that is the double of the previous score.
- 'C'.
    - Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer
and that all operations are valid.

Example
Input: ops = ["5","2","C","D","+"]
Output: 30
Debug:
- "5" -> Add 5 -> record = [5]
- "2" -> Add 2 -> record = [5, 2]
- "C" -> Remove 2 -> record = [5]
- "D" -> Add 5*2 -> record = [5, 10]
- "+" -> Add 5+10 -> record = [5, 10, 15]

 */

import java.util.LinkedList;

public class BaseballGame {
    public static void sumOp(LinkedList<Integer> records) {
        if(records.size() >= 2) {
            int last = records.removeLast();
            int secondLast = records.removeLast();
            int sum = last + secondLast;
            records.addLast(secondLast);
            records.addLast(last);
            records.addLast(sum);
        } else if(records.size() == 1) {
            records.addLast(records.get(0));
        }
    }

    public static void doubleOp(LinkedList<Integer> records) {
        if(!records.isEmpty()) {
            records.addLast(records.getLast() * 2);
        }
    }

    public static void removeOp(LinkedList<Integer> records) {
        if(!records.isEmpty()) {
            records.removeLast();
        }
    }

    public static void addOp(LinkedList<Integer> records, String value) {
        records.addLast(Integer.parseInt(value));
    }

    public int calPoints(String[] operations) {
        LinkedList<Integer> records = new LinkedList<>();

        for(String operation : operations) {
//            char op = operation.charAt(0);
            switch (operation) {
                case "+":
                    sumOp(records);
                    break;

                case "D":
                    doubleOp(records);
                    break;

                case "C":
                    removeOp(records);
                    break;

                default:
                    addOp(records, operation);
                    break;
            }
        }

        int score = 0;
        for(int value : records) {
            score += value;
        }

        return score;
    }
}
