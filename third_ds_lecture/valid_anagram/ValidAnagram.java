package tasks.third_ds_lecture.valid_anagram;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (counter[c - 'a'] == 0)
                return false;
            counter[c - 'a']--;
        }
        return true;
    }
}
