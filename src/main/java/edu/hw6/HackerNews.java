package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"hideutilityclassconstructor", "regexpsinglelinejava", "uncommentedmain", "magicnumber"})
public class HackerNews {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public static long[] hackerNewsTopStories() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(TOP_STORIES_URL))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            String[] stringArray = json.replace("[", "").replace("]", "").split(",");

            return Arrays.stream(stringArray)
                .mapToLong(Long::parseLong)
                .toArray();
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
    }

    public static String news(long id) {
        String itemUrl = String.format(ITEM_URL, id);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(itemUrl))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Pattern pattern = Pattern.compile("\"title\"\\s*:\\s*\"(.*?)\"");
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "Название новости не найдено";
            }
        } catch (IOException | InterruptedException e) {
            return "Ошибка при получении названия новости";
        }
    }

    public static void main(String[] args) {
        long[] topStories = hackerNewsTopStories();
        System.out.println(Arrays.toString(topStories));

        String newsTitle = news(37570037);
        System.out.println(newsTitle);
    }
}
