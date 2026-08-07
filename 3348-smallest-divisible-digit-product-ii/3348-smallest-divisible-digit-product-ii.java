import java.util.*;

class Solution {
    private static final Map<Integer, Map<Integer, Integer>> FACTOR_COUNTS = Map.of(
        0, Map.of(),
        1, Map.of(),
        2, Map.of(2, 1),
        3, Map.of(3, 1),
        4, Map.of(2, 2),
        5, Map.of(5, 1),
        6, Map.of(2, 1, 3, 1),
        7, Map.of(7, 1),
        8, Map.of(2, 3),
        9, Map.of(3, 2)
    );

    public String smallestNumber(String num, long t) {
        Map<Integer, Integer> primeCount = new HashMap<>();
        for (int p : new int[]{2, 3, 5, 7}) {
            while (t % p == 0) {
                t /= p;
                primeCount.put(p, primeCount.getOrDefault(p, 0) + 1);
            }
        }
        if (t > 1) return "-1"; // Contains prime factors other than 2, 3, 5, 7

        Map<Integer, Integer> factorCount = getFactorCount(primeCount);
        if (sumValues(factorCount) > num.length()) {
            return construct(factorCount);
        }

        Map<Integer, Integer> primeCountPrefix = getPrimeCount(num);
        int firstZeroIndex = num.indexOf('0');
        if (firstZeroIndex == -1) {
            firstZeroIndex = num.length();
            if (isSubset(primeCount, primeCountPrefix)) {
                return num;
            }
        }

        for (int i = num.length() - 1; i >= 0; --i) {
            int d = num.charAt(i) - '0';
            primeCountPrefix = subtract(primeCountPrefix, FACTOR_COUNTS.get(d));
            int spaceAfterThisDigit = num.length() - 1 - i;
            if (i > firstZeroIndex) continue;

            for (int biggerDigit = d + 1; biggerDigit < 10; ++biggerDigit) {
                Map<Integer, Integer> factorsAfterReplacement = getFactorCount(
                    subtract(subtract(primeCount, primeCountPrefix), FACTOR_COUNTS.get(biggerDigit))
                );

                if (sumValues(factorsAfterReplacement) <= spaceAfterThisDigit) {
                    int fillOnes = spaceAfterThisDigit - sumValues(factorsAfterReplacement);
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(biggerDigit);
                    sb.append("1".repeat(fillOnes));
                    sb.append(construct(factorsAfterReplacement));
                    return sb.toString();
                }
            }
        }

        Map<Integer, Integer> factorsAfterExtension = getFactorCount(primeCount);
        int totalLen = Math.max(num.length() + 1, sumValues(factorsAfterExtension));
        return "1".repeat(totalLen - sumValues(factorsAfterExtension)) + construct(factorsAfterExtension);
    }

    private Map<Integer, Integer> getPrimeCount(String s) {
        Map<Integer, Integer> count = new HashMap<>(Map.of(2, 0, 3, 0, 5, 0, 7, 0));
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d == 0) continue;
            Map<Integer, Integer> factors = FACTOR_COUNTS.get(d);
            for (var entry : factors.entrySet()) {
                count.put(entry.getKey(), count.get(entry.getKey()) + entry.getValue());
            }
        }
        return count;
    }

    private Map<Integer, Integer> getFactorCount(Map<Integer, Integer> count) {
        int c2 = count.getOrDefault(2, 0);
        int c3 = count.getOrDefault(3, 0);
        int c5 = count.getOrDefault(5, 0);
        int c7 = count.getOrDefault(7, 0);

        int count8 = c2 / 3;
        int remaining2 = c2 % 3;
        int count9 = c3 / 2;
        int count3 = c3 % 2;
        int count4 = remaining2 / 2;
        int count2 = remaining2 % 2;

        int count6 = 0;
        if (count2 == 1 && count3 == 1) {
            count2 = 0;
            count3 = 0;
            count6 = 1;
        }
        if (count3 == 1 && count4 == 1) {
            count2 = 1;
            count6 = 1;
            count3 = 0;
            count4 = 0;
        }

        Map<Integer, Integer> res = new HashMap<>();
        if (count2 > 0) res.put(2, count2);
        if (count3 > 0) res.put(3, count3);
        if (count4 > 0) res.put(4, count4);
        if (c5 > 0) res.put(5, c5);
        if (count6 > 0) res.put(6, count6);
        if (c7 > 0) res.put(7, c7);
        if (count8 > 0) res.put(8, count8);
        if (count9 > 0) res.put(9, count9);
        return res;
    }

    private boolean isSubset(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        for (var entry : a.entrySet()) {
            if (b.getOrDefault(entry.getKey(), 0) < entry.getValue()) return false;
        }
        return true;
    }

    private Map<Integer, Integer> subtract(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> res = new HashMap<>(a);
        for (var entry : b.entrySet()) {
            res.put(entry.getKey(), Math.max(0, res.getOrDefault(entry.getKey(), 0) - entry.getValue()));
        }
        return res;
    }

    private int sumValues(Map<Integer, Integer> count) {
        return count.values().stream().mapToInt(Integer::intValue).sum();
    }

    private String construct(Map<Integer, Integer> factors) {
        StringBuilder sb = new StringBuilder();
        for (int digit = 2; digit <= 9; digit++) {
            sb.append(String.valueOf(digit).repeat(factors.getOrDefault(digit, 0)));
        }
        return sb.toString();
    }
}