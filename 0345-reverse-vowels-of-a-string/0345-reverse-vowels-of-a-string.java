class Solution {
    public static void reverse(ArrayList<Character> list, int start, int end) {
        while (start < end) {
            char temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public String reverseVowels(String s) {
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                list.add(ch);
                list1.add(i);
            }
        }

        reverse(list, 0, list.size() - 1);

        char[] arr = s.toCharArray();

        for (int i = 0; i < list1.size(); i++) {
            arr[list1.get(i)] = list.get(i);
        }

        return new String(arr);
    }
}