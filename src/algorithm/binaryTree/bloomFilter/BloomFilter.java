package algorithm.binaryTree.bloomFilter;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class BloomFilter {
    private BitSet bitSet;
    private int bitSetSize;
    private int numHashFunctions;
    private Function<String, Integer>[] hashFunctions;

    public BloomFilter(int bitSetSize, int numHashFunctions) {
        this.bitSetSize = bitSetSize;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(bitSetSize);
        this.hashFunctions = new Function[numHashFunctions];

        Random random = new Random();
        for (int i = 0; i < numHashFunctions; i++) {
            int seed = random.nextInt();
            this.hashFunctions[i] = (key) -> {
                int hash = key.hashCode() ^ seed;
                return Math.abs(hash % bitSetSize);
            };
        }
    }

    public void add(String key) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int position = hashFunction.apply(key);
            bitSet.set(position);
        }
    }

    public boolean contains(String key) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int position = hashFunction.apply(key);
            if (!bitSet.get(position)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(1024, 3);

        String[] itemsToAdd = {"apple", "banana", "cherry"};
        for (String item : itemsToAdd) {
            bloomFilter.add(item);
        }

        System.out.println("Contains 'apple': " + bloomFilter.contains("apple")); // true
        System.out.println("Contains 'grape': " + bloomFilter.contains("grape")); // false
    }
}
