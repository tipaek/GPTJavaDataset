public class CandyDistribution {

    public int candy(int[] ratings) {
        return candyApproach1(ratings);
    }

    // Approach 1: O(n) space
    public int candyApproach1(int[] ratings) {
        int N = ratings.length;
        if (N == 0) {
            return 0;
        }

        int[] candies = new int[N];
        int totalCandies = 0;

        // Left to right pass
        candies[0] = 1;
        for (int i = 1; i < N; ++i) {
            candies[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = N - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Count total candies
        for (int i = 0; i < N; ++i) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    // Approach 2: Traverse only once with O(1) space
    public int candyApproach2(int[] ratings) {
        int N = ratings.length;
        if (N == 0) {
            return 0;
        }

        int candies = 1, totalCandies = 1;
        int maxVal = 1, maxIdx = 0;

        for (int i = 1; i < N; ++i) {
            if (ratings[i] >= ratings[i - 1]) {
                candies = ratings[i] == ratings[i - 1] ? 1 : candies + 1;
                maxVal = candies;
                maxIdx = i;
            } else {
                if (candies == 1) {
                    if (maxVal <= i - maxIdx) {
                        ++maxVal;
                        ++totalCandies;
                    }
                    totalCandies += i - maxIdx - 1;
                }
                candies = 1;
            }
            totalCandies += candies;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] ratings = { 1, 0, 2 };

        CandyDistribution solution = new CandyDistribution();
        int totalCandies = solution.candyApproach1(ratings);

        System.out.println("The minimum candies required: " + totalCandies);
    }
}
