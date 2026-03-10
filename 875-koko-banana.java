class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // the greatest number in the pile is guaranteed to be an answer. But not the "minimum" answer.
        // the minimum in any case is equal to 1. i.e koko can eat 1 banana every hour...
        // the minimum answer must lie somewhere between this range of maxOfArr and the minimum of 1.
        // we can use binary search for O(Log n) and we do need to initialise another arr so space complex-
        // would be O(n).

        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid; //to check for earlier occurences where she can also finish bananas
            } else {
                left = mid + 1; //discard left half
            }
        }
        return left;

    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed-1)/speed;
        }
        return hours <= h;
    }
}
