package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings({"hideutilityclassconstructor", "magicnumber"})
public class Main {
    public static void main(String[] args) {
        List<Animal> animalList = List.of(
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 120, 35, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 3, 115, 32, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 3, 125, 37, false)
        );
        animalList = sortByWeight(animalList, 2);
        print(animalList);
    }

    // print function
    public static void print(List<Animal> animals) {
        animals.stream()
            .forEach(System.out::println);
    }

    // Task 1
    public static List<Animal> sortByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::height))
            .collect(Collectors.toList());
    }

    // Task 2
    public static List<Animal> sortByWeight(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    //Task 3
    public static Map<Animal.Type, Integer> counterOfEachType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    //Task 4
    public static Animal animalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    // Task 5
    public static Animal.Sex whoIsMore(List<Animal> animals) {
        Map<Animal.Sex, Long> map = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::sex,
                Collectors.counting()
            ));
        if (map.get(Animal.Sex.F) > map.get(Animal.Sex.M)) {
            return Animal.Sex.F;
        }
        return Animal.Sex.M;
    }

    // Task 6
    public static Map<Animal.Type, Animal> heaviestAnimal(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingInt(Animal::weight)),
                    Optional::orElseThrow
                )
            ));
    }

    // Task 7
    public static Animal kthOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age))
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Task 8
    public static Optional<Animal> heaviestAnimalBelowHeight(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Task 9
    public static Integer pawsCounter(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // Task 10
    public static List<Animal> ageNotEqualPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .collect(Collectors.toList());
    }

    // Task 11
    public static List<Animal> canByteAndTall(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .collect(Collectors.toList());
    }

    // Task 12
    public static Integer weightMoreThanHeight(List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.height() < animal.weight())
            .count());
    }

    // Task 13
    public static List<Animal> moreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length >= 2)
            .collect(Collectors.toList());
    }

    // Task 14
    public static Boolean haveDogHigherThan(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .anyMatch(animal -> animal.height() > k);
    }

    // Task 15
    public static Map<Animal.Type, Integer> sumWeightFromKToLAges(List<Animal> animals, int k, int l) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.filtering(
                    animal -> (animal.age() >= k && animal.age() <= l),
                    Collectors.summingInt(animal -> animal.weight())
                )
            ));
    }

    // Task 16
    public static List<Animal> sort(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    // Task 17
    public static Boolean spiderVSDogs(List<Animal> animals) {
        var map = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.filtering(
                    animal -> animal.bites(),
                    Collectors.counting()
                )
            ));
        return map.get(Animal.Type.SPIDER) > map.get(Animal.Type.DOG);
    }

    // Task 18
    public static Animal heaviestFish(List<List<Animal>> animals) {
        List<Animal> s = animals.stream()
            .flatMap(List::stream)
            .toList();
        return s.stream()
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    // Task 19

    public static Map<String, Set<ValidationError>> errorAnimal(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> getErrors(animal).size() != 0)
            .collect(Collectors.toMap(
                Animal::name,
                animal -> getErrors(animal),
                (existingErrors, newErrors) -> {
                    existingErrors.addAll(newErrors);
                    return existingErrors;
                }
            ));
    }

    private static Set<ValidationError> getErrors(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.type() == null) {
            errors.add(ValidationError.MISSING_TYPE);
        }
        if (animal.age() < 0) {
            errors.add(ValidationError.INVALID_AGE);
        }
        if (animal.weight() < 0) {
            errors.add(ValidationError.INVALID_WEIGHT);
        }
        if (animal.height() < 0) {
            errors.add(ValidationError.INVALID_HEIGHT);
        }
        if (animal.sex() == null) {
            errors.add(ValidationError.INVALID_SEX);
        }
        return errors;
    }

    // Task 20

    public static Map<String, String> animalErrors(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> !getErrorsField(animal).isEmpty())
            .collect(Collectors.toMap(
                Animal::name,
                animal -> getErrorsField(animal),
                (existingFields, newFields) -> existingFields + ", " + newFields
            ));
    }

    private static String getErrorsField(Animal animal) {
        List<String> errors = new ArrayList<>();
        if (animal.type() == null) {
            errors.add("type");
        }
        if (animal.age() < 0) {
            errors.add("age");
        }
        if (animal.weight() < 0) {
            errors.add("weight");
        }
        if (animal.height() < 0) {
            errors.add("height");
        }
        if (animal.sex() == null) {
            errors.add("sex");
        }
        return String.join(", ", errors);
    }

    private record ValidationError(String message) {
        public static final ValidationError MISSING_TYPE = new ValidationError("Отсутствует тип");
        public static final ValidationError INVALID_AGE = new ValidationError("Некорректный возраст");
        public static final ValidationError INVALID_WEIGHT = new ValidationError("Некорректный вес");
        public static final ValidationError INVALID_HEIGHT = new ValidationError("Некорректный рост");
        public static final ValidationError INVALID_SEX = new ValidationError("Некорректный пол");
    }
}
