package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task7Test {
    @Test
    void check() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
