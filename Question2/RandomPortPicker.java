package Question2;

import java.util.*;

public class RandomPortPicker {
    Random random;
    int k;
    Set<Integer> blacklistedPorts;
    int numBlacklistedPorts;

    public RandomPortPicker(int k, int[] blacklistedPorts) {
        this.random = new Random();
        this.k = k;
        this.blacklistedPorts = new HashSet<>();
        for (int port : blacklistedPorts) {
            this.blacklistedPorts.add(port);
        }
        this.numBlacklistedPorts = this.blacklistedPorts.size();
    }

    public int get() {
        int randomPort = random.nextInt(k - numBlacklistedPorts);
        if (blacklistedPorts.contains(randomPort)) {
            randomPort = k - numBlacklistedPorts; // Increment the randomPort to a valid whitelisted port
        }
        return randomPort;
    }

    public static void main(String[] args) {
        int[] blacklistedPorts = {2, 3, 5};
        RandomPortPicker picker = new RandomPortPicker(7, blacklistedPorts);

        System.out.println(picker.get()); // Output: Any number from [0, 1, 4, 6] should be ok.
        System.out.println(picker.get());
    }
}
