package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private List<Animal> animalList = List.of(
        new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 5, 120, 35, true),
        new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 4, 115, 32, false),
        new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 3, 125, 37, false)
    );

    private List<Animal> animalList2 = List.of(
        new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 50, 7, true),
        new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 50, 7, true),
        new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 2, 50, 7, false),
        new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.F, 2, 50, 7, true),
        new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 50, 7, true),
        new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 2, 50, 8, true)
    );

    private List<Animal> animalList3 = List.of(
        new Animal("Cat", null, null, -4, -5, -6, true)
    );

    @Test
    @DisplayName("Task 1 Test")
    void sortByHeightTest() {
        animalList = Main.sortByHeight(animalList);
        assertEquals("Dog1", animalList.get(0).name());
        assertEquals("Dog", animalList.get(1).name());
        assertEquals("Dog2", animalList.get(2).name());
    }

    @Test
    @DisplayName("Task 2 Test")
    void sortByWeightTest() {
        animalList = Main.sortByWeight(animalList, 2);
        assertEquals("Dog2", animalList.get(0).name());
        assertEquals("Dog", animalList.get(1).name());
    }

    @Test
    @DisplayName("Task 3 Test")
    void counterOfEachTypeTest() {
        Map<Animal.Type, Integer> map = Main.counterOfEachType(animalList);
        assertEquals(3, map.get(Animal.Type.DOG));
    }

    @Test
    @DisplayName("Task 4 Test")
    void maxLengthName() {
        Animal animal = Main.animalWithLongestName(animalList);
        assertEquals("Dog1", animal.name());
    }

    @Test
    @DisplayName("Task 5 Test")
    void whoIsMoreTest() {
        var ans = Main.whoIsMore(animalList2);
        assertEquals(Animal.Sex.F, ans);
    }

    @Test
    @DisplayName("Task 6 Test")
    void heaviestAnimalTest() {
        Map<Animal.Type, Animal> map = Main.heaviestAnimal(animalList);
        assertEquals("Dog2", map.get(Animal.Type.DOG).name());
    }

    @Test
    @DisplayName("Task 7 Test")
    void kthOldestAnimalTest() {
        Animal animal = Main.kthOldestAnimal(animalList, 2);
        assertEquals(4, animal.age());
    }

    @Test
    @DisplayName("Task 8 Test")
    void heaviestAnimalBelowHeight() {
        Optional<Animal> ans = Main.heaviestAnimalBelowHeight(animalList, 119);
        assertEquals("Dog1", ans.get().name());
    }

    @Test
    @DisplayName("Task 9 Test")
    void pawsCounterTest() {
        Integer ans = Main.pawsCounter(animalList);
        assertEquals(ans, 12);
    }

    @Test
    @DisplayName("Task 10 Test")
    void ageNotEqualPawsTest() {
        List<Animal> ans = Main.ageNotEqualPaws(animalList);
        assertEquals(2, ans.size());
    }

    @Test
    @DisplayName("Task 11 Test")
    void canByteAndTallTest() {
        List<Animal> ans = Main.canByteAndTall(animalList);
        assertEquals(1, ans.size());
        assertEquals("Dog", ans.get(0).name());
    }

    @Test
    @DisplayName("Task 12 Test")
    void weightMoreThanHeightTest() {
        Integer ans = Main.weightMoreThanHeight(animalList);
        assertEquals(0, ans);
    }

    @Test
    @DisplayName("Task 13 Test")
    void moreThanTwoWordsTest() {
        List<Animal> ans = Main.moreThanTwoWords(animalList);
        assertEquals(0, ans.size());
    }

    @Test
    @DisplayName("Task 14 Test")
    void haveDogHigherThanTest() {
        Boolean ans = Main.haveDogHigherThan(animalList, 124);
        Boolean ans1 = Main.haveDogHigherThan(animalList, 125);
        assertTrue(ans);
        assertFalse(ans1);
    }

    @Test
    @DisplayName("Task 15 Test")
    void sumWeightFromKToLAgesTest() {
        var ans = Main.sumWeightFromKToLAges(animalList, 4, 6);
        assertEquals(67, ans.get(Animal.Type.DOG));
    }

    @Test
    @DisplayName("Task 16 Test")
    void sortTest() {
        var ans = Main.sort(animalList2);
        assertEquals("Dog", ans.get(2).name());
    }

    @Test
    @DisplayName("Task 17 Test")
    void spiderVSDogsTest() {
        var ans = Main.spiderVSDogs(animalList2);
        assertTrue(ans);
    }

    @Test
    @DisplayName("Task 18 Test")
    void heaviestFishTest() {
        var ans = Main.heaviestFish(List.of(animalList, animalList2));
        assertEquals("Fish2", ans.name());
    }

    @Test
    @DisplayName("Task 19 Test")
    void errorAnimalTest() {
        var ans = Main.errorAnimal(animalList3);
        System.out.println(ans.get("Cat"));
    }

    @Test
    @DisplayName("Task 20 Test")
    void animalErrorsTest() {
        var ans = Main.animalErrors(animalList3);
        System.out.println(ans);
    }
}
