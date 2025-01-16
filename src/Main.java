import java.util.ArrayList;
import java.util.List;

public class Main {

    // Метод filter
    //Не безопасен!!!
    //Вариант использовать в анонимных классах или лямбда - контроль на совести разработчика (@SuppressWarnings("unchecked"))
    //P.S. Если бы, допустим, метод удалял каждый чётный элемент массива - тогда бы можно было
    //не опосаться неправильного приведения (пример: применение фильтра String на Integer),


    public static <T> List<T> filter(T[] array, Filter filter) {
        if (array == null || filter == null) {
            throw new IllegalArgumentException("Массив и фильтр не могут быть null");
        }

        List<T> result = new ArrayList<>();
        for (T element : array) {
            @SuppressWarnings("unchecked")
            T filteredElement = (T) filter.apply(element);
            result.add(filteredElement);
        }
        return result;
    }

    public static void main(String[] args) {

        // Пример использования для String(Лямбда+Анонимный класс)
        List<String> upperCaseStrings = filter(
                new String[]{"apple", "banana", "cherry"},
                o -> ((String) o).toUpperCase()
        );

        System.out.println("Строки в верхнем регистре: " + upperCaseStrings);
        // Вывод: [APPLE, BANANA, CHERRY]

        // Пример использования для Integer (Анонимный класс)
        Integer[] intArray = {1, 2, 3, 4, 5};

        Filter multiplyByTwo = new Filter() {
            @Override
            public Integer apply(Object o) {
                return (Integer) o * 2;
            }
        };

        List<Integer> doubledIntegers = filter(intArray, multiplyByTwo);
        System.out.println("Удвоенные числа: " + doubledIntegers);
        // Вывод: [2, 4, 6, 8, 10]
    }
}