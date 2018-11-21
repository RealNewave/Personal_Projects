package Poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hans
 */
public class HandRanking {

    private ArrayList<String> completeHand;
    private ArrayList<Integer> compareValuesRightSide;
    private ArrayList<Integer> compareValuesLeftSide;

    public String evaluate(String[] hand, ArrayList<String> cards) {
        
        completeHand = (ArrayList<String>) cards.clone();
        completeHand.add(hand[0]);
        completeHand.add(hand[1]);
        splitCards();
        if (straightFlush()) {
            return "Straight Flush";
        }
        if (fourOfAKind()) {
            return "Four Of A Kind";
        }
        if (fullHouse()) {
            return "FullHouse";
        }
        if (flush()) {
            return "Flush";
        }
        if (straight()) {
            return "Straight";
        }
        if (threeOfAKind()) {
            return "Three Of A Kind";
        }
        if (twoPair()) {
            return "Two Pair";
        }
        if (onePair()) {
            return "One Pair";
        }

        return "High Card";
    }

    private boolean onePair() {

        for (int i = 0; i < compareValuesRightSide.size(); i++) {
            for (int j = i + 1; j < compareValuesRightSide.size() - 1; j++) {
                if (compareValuesRightSide.get(i).equals(compareValuesRightSide.get(j))) {
                    return true;
                }
            }

        }
        return false;

    }

    private boolean twoPair() {

        int amountOfPairs = 0, previousNumber = 0;

        for (int i = 0; i < compareValuesRightSide.size(); i++) {
            for (int j = i + 1; j < compareValuesRightSide.size(); j++) {
                if (compareValuesRightSide.get(i).equals(compareValuesRightSide.get(j)) && compareValuesRightSide.get(i) != previousNumber) {
                    amountOfPairs++;
                    previousNumber = compareValuesRightSide.get(i);
                    break;
                }
            }

        }
        return amountOfPairs >= 2;
    }

    private boolean threeOfAKind() {

        int amountEquals = 0;
        for (int i = 0; i < compareValuesRightSide.size(); i++) {
            for (int j = i + 1; j < compareValuesRightSide.size(); j++) {
                if (compareValuesRightSide.get(i).equals(compareValuesRightSide.get(j))) {
                    amountEquals++;

                }
            }
            if (amountEquals >= 2) {
                return true;
            } else {
                amountEquals = 0;
            }
        }
        return false;
    }

    private boolean straight() {

        for (int i = 0; i < compareValuesRightSide.size() - 5; i++) {
            if (compareValuesRightSide.get(i + 1).equals(compareValuesRightSide.get(i) + 1)
                    && compareValuesRightSide.get(i + 2).equals(compareValuesRightSide.get(i + 1) + 1)
                    && compareValuesRightSide.get(i + 3).equals(compareValuesRightSide.get(i + 2) + 1)
                    && compareValuesRightSide.get(i + 4).equals(compareValuesRightSide.get(i + 3) + 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean flush() {
        for (int i = 0; i < compareValuesLeftSide.size() - 5; i++) {
            if (compareValuesLeftSide.get(i + 1).equals(compareValuesLeftSide.get(i))
                    && compareValuesLeftSide.get(i + 2).equals(compareValuesLeftSide.get(i + 1))
                    && compareValuesLeftSide.get(i + 3).equals(compareValuesLeftSide.get(i + 2))
                    && compareValuesLeftSide.get(i + 4).equals(compareValuesLeftSide.get(i + 3))) {
                return true;
            }
        }

        return false;

    }

    private boolean fullHouse() {
        return threeOfAKind() && twoPair();
    }

    private boolean fourOfAKind() {
        int amountEquals = 0;
        for (int i = 0; i < compareValuesRightSide.size(); i++) {
            for (int j = i + 1; j < compareValuesRightSide.size() - 1; j++) {
                if (compareValuesRightSide.get(i).equals(compareValuesRightSide.get(j))) {
                    amountEquals++;

                }
            }
            if (amountEquals >= 3) {
                return true;
            } else {
                amountEquals = 0;
            }

        }
        return false;

    }

    private boolean straightFlush() {
        if (flush() && straight()) {
            Collections.sort(completeHand);
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            completeHand.forEach((card) -> {
                String[] splitValue = card.split(",");
                left.add(Integer.parseInt(splitValue[0]));
                right.add(Integer.parseInt(splitValue[1]));

            });
            int flushNumber = 0;
            for (int i = 0; i < left.size() - 5; i++) {
                if (left.get(i + 1).equals(left.get(i))
                        && left.get(i + 2).equals(left.get(i + 1))
                        && left.get(i + 3).equals(left.get(i + 2))
                        && left.get(i + 4).equals(left.get(i + 3))) {
                    flushNumber = i;
                }
            }
            for (int i = flushNumber; i < right.size() - 5; i++) {
                if (right.get(i + 1).equals(right.get(i) + 1)
                        && right.get(i + 2).equals(right.get(i + 1) + 1)
                        && right.get(i + 3).equals(right.get(i + 2) + 1)
                        && right.get(i + 4).equals(right.get(i + 3) + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    private void splitCards() {
        compareValuesRightSide = new ArrayList<>();
        compareValuesLeftSide = new ArrayList<>();
        completeHand.forEach((card) -> {
            String[] splitValue = card.split(",");
            compareValuesLeftSide.add(Integer.parseInt(splitValue[0]));
            compareValuesRightSide.add(Integer.parseInt(splitValue[1]));
        });
        Collections.sort(compareValuesLeftSide);
        Collections.sort(compareValuesRightSide);
    }

}
