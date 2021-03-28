import java.util.*;

public class AlienDictionary2 {
    public void constructRelation(String w1, String w2, Map<Character, List<Character>> relation) {
        for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            Character parent = w1.charAt(i);
            Character child = w2.charAt(i);

            if ( parent != child) {
                List<Character> children = relation.getOrDefault(parent, new ArrayList<>());
                if ( !children.contains(child) ) {
                    children.add(child);
                    relation.put(parent, children);
                }
            }
        }
    }
    public String alienDictionary(String[] words) {
        int[] lexOrder = new int[26];
        Map<Character, List<Character>> relation = new HashMap<Character, List<Character>>();

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            constructRelation(word1, word2, relation);
        }

        Character[] characters = relation.keySet().toArray(new Character[0]);

        Arrays.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return relation.get(c1).size() - relation.get(c2).size();
            }
        });

        StringBuilder order = new StringBuilder();

        for (Character c: characters) {
            order.append(c);
        }

        return order.toString();
    }

    public void main(String[] args) {

    }
}
