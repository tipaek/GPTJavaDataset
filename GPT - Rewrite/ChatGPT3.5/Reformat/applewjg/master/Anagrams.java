import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public List<String> findAnagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> group = new HashMap<>();

        if (strs.length == 0) {
            return result;
        }

        for (int i = 0; i < strs.length; ++i) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);

            if (group.containsKey(sortedString)) {
                group.get(sortedString).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                group.put(sortedString, list);
            }
        }

        Iterator<Map.Entry<String, ArrayList<String>>> iterator = group.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = iterator.next();
            ArrayList<String> value = entry.getValue();

            if (value.size() > 1) {
                result.addAll(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        String[] inputStrings = { "eat", "tea", "tan", "ate", "nat", "bat" };

        Anagrams solution = new Anagrams();
        List<String> anagramGroups = solution.findAnagrams(inputStrings);

        System.out.println("Groups of anagrams: " + anagramGroups);
    }
}
