package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

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
    void shouldSaveMovie() {
        repository.save(one);

        Movie[] actual = repository.findAll();
        Movie[] expected = {one};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);

        Movie[] actual = repository.findById("matrix3");
        Movie[] expected = {three};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFinByIdNotExist() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);

        Movie[] actual = repository.findById("astral");
        Movie[] expected = {null};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);

        repository.removeAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);

        repository.removeById("matrix4");

        Movie[] actual = repository.findAll();
        Movie[] expected = {one, two, three, five};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExist() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);

        repository.removeById("astral");

        Movie[] actual = repository.findAll();
        Movie[] expected = {one, two, three, four, five};

        assertArrayEquals(expected, actual);
    }
}