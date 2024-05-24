package algorithm.binaryTree.bloomFilter;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

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

    /**
     * When it's say false, it's 100%, but the true is not accurate.
     * @param key
     * @return
     */
    public boolean contains(String key) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int position = hashFunction.apply(key);
            if (!bitSet.get(position)) {
                // If the slot is empty.
                return false;
            }
        }
        // If the slot is occupied.
        return true;
    }



    public static void filterTest(int numberOfItems, int sizeOfBitSet, int numberOfHashFunc) {
        BloomFilter bloomFilter = new BloomFilter(sizeOfBitSet, numberOfHashFunc);
        // Generate given numbers of word.
        String[] randomStrings = IntStream.range(0, numberOfItems)
                .mapToObj(i -> RandomStringUtils.randomAlphanumeric(20))
                .toArray(String[]::new);
        // Insert it into the filter.
        for (String str : randomStrings) {
            bloomFilter.add(str);
        }
        // Call contain and print the success rate.
        int count = 0;
        for (String str : randomStrings) {
            if (bloomFilter.contains(str)) {
                count++;
            }
        }
        double rate = count/(double)randomStrings.length;

        System.out.println("Items: " + numberOfItems +
                " sizeOfBitSet: " + sizeOfBitSet +
                " numberOfHashFunc: " + numberOfHashFunc +
                " Rate: " + rate);

    }

    public static void main(String[] args) {
        filterTest(10240, 1024, 3);
    }
}
