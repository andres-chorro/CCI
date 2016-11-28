import java.util.*;

class BuildOrder {

    /**
    * Brute Force Solution: Go through, adding everything you can, then keep
    * going until you nothing can be added. If you make a pass without adding
    * something, return an error.
    */
    public static LinkedList<Character>
    buildOrder(HashMap<Character, HashSet<Character>> dependencies) {
        LinkedList<Character> result = new LinkedList<>();
        Set<Character> keys = dependencies.keySet();
        while (!keys.isEmpty()) {
            Iterator<Character> iter = keys.iterator();
            boolean changeMade = false;
            while (iter.hasNext()) {
                Character curr = iter.next();
                if (result.containsAll(dependencies.get(curr))) {
                    result.addLast(curr);
                    iter.remove();
                    changeMade = true;
                }
            }
            if (!changeMade) {
                System.out.println("No valid path!");
                return null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<Character, HashSet<Character>> dependencies = new HashMap<>();
        dependencies.put('a', new HashSet<Character>());
        dependencies.put('b', new HashSet<Character>());
        dependencies.put('c', new HashSet<Character>());
        dependencies.put('d', new HashSet<Character>());
        dependencies.put('e', new HashSet<Character>());
        dependencies.put('f', new HashSet<Character>());
        dependencies.get('d').add('a');
        dependencies.get('b').add('f');
        dependencies.get('d').add('b');
        dependencies.get('a').add('f');
        dependencies.get('c').add('d');
        // dependencies.get('d').add('c');
        System.out.println(buildOrder(dependencies));
        System.out.println(dependencies);
    }
}