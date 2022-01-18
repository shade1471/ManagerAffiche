package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class AfishaManagerTest {
    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);
    private AfishaManager manager = new AfishaManager(repository);

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
    void shouldGetAll() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] returned = {one, two, three, four, five};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = {five, four, three, two, one};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void shouldAddMovie() {
        manager.add(nine);

        Movie[] returned = {nine};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = {nine};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void getAfficheWithManualSettingLessThanValuesOfArray() {
        AfishaManager manager = new AfishaManager(3, repository);

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] returned = {one, two, three, four, five};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = {five, four, three};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void getAfficheWithManualSettingMoreThanValuesOfArray() {
        AfishaManager manager = new AfishaManager(8, repository);

        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);

        Movie[] returned = {eight, nine, ten, eleven, twelve};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = {twelve, eleven, ten, nine, eight};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
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

        Movie[] returned = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = {twelve, eleven, ten, nine, eight, seven, six, five, four, three};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
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

        Movie[] returned = {one, two, three, four, five, six, seven, eight, nine, ten};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = {ten, nine, eight, seven, six, five, four, three, two, one};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }
}