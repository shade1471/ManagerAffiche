package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {
    MoviesManager manager = new MoviesManager();

    Movie one = new Movie("matrix1", "Матрица 1", "fantastic", "none", false);
    Movie two = new Movie("matrix2", "Матрица 2: Перезагрузка", "fantastic", "none", false);
    Movie three = new Movie("matrix3", "Матрица 3: Воскрешение", "fantastic", "none", false);
    Movie four = new Movie("matrix4", "Матрица 4: Воскрешение", "fantastic", "none", true);
    Movie five = new Movie("bloodshot", "Бладшот", "action", "none", false);
    Movie six = new Movie("forward", "Вперёд", "cartoon", "none", false);
    Movie seven = new Movie("hotel-belgrade", "Отель Белград", "comedy", "none", false);
    Movie eight = new Movie("gentlemen", "Джентльмены", "action", "none", false);
    Movie nine = new Movie("invisible-man", "Человек-невидимка", "scary", "none", false);
    Movie ten = new Movie("trolls-world-tour", "Тролли.Мировой тур", "cartoon", "none", true);
    Movie eleven = new Movie("number-one", "Номер Один", "comedy", "none", true);
    Movie twelve = new Movie("astral", "Астрал", "scary", "none", false);

    @Test
    void add() {
        manager.add(nine);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{nine};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAfficheWithManualSetting() {
        MoviesManager manager = new MoviesManager(3);

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, four, three};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAfficheWithManualSettingMoreThanValuesOfArray() {
        MoviesManager manager = new MoviesManager(8);

        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAfficheWithDefaultSetting() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, three};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAfficheWithDefaultSettingBoundaryValues() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{ten, nine, eight, seven, six, five, four, three, two, one};

        assertArrayEquals(expected, actual);
    }
}