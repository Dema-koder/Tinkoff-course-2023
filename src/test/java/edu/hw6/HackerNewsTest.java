package edu.hw6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HackerNewsTest {
    @Test
    public void testHackerNewsTopStories() {
        long[] topStories = HackerNews.hackerNewsTopStories();
        assertNotNull(topStories);
        assertNotEquals(0, topStories.length);
    }

    @Test
    public void testNews() {
        String newsTitle = HackerNews.news(37570037);
        assertNotNull(newsTitle);
        assertNotEquals("", newsTitle);
    }
}
