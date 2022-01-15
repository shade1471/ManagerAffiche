package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class AfishaManagerTest {

    private AfishaRepository repository = new AfishaRepository();
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
    void getAll() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(repository);

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] returned = {one, two, three, four, five};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, four, three, two, one};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void deleteById() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(repository);

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        repository.removeById("matrix4");

        Movie[] returned = {one, two, three, five};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, three, two, one};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void add() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(repository);

        manager.add(nine);

        Movie[] returned = {nine};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{nine};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void finById() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] actual = repository.findById("matrix3");
        Movie[] expected = new Movie[]{three};

        assertArrayEquals(expected, actual);
    }

    @Test
    void finByIdNotExist() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] actual = repository.findById("astral");
        Movie[] expected = new Movie[]{null};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(repository);

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        repository.removeAll();

        Movie[] returned = {};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }


    @Test
    void deleteByIdNotExist() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        repository.removeById("astral");

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, four, three, two, one};

        assertArrayEquals(expected, actual);
    }


    @Test
    void getAfficheWithManualSetting() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(3, repository);

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        Movie[] returned = {one, two, three, four, five};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, four, three};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void getAfficheWithManualSettingMoreThanValuesOfArray() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(8, repository);

        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);

        Movie[] returned = {eight, nine, ten, eleven, twelve};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void getAfficheWithDefaultSetting() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(repository);

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
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, three};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }

    @Test
    void getAfficheWithDefaultSettingBoundaryValues() {
        //@Mock, для тестирования логики менеджера
        AfishaRepository repository = Mockito.mock(AfishaRepository.class);
        AfishaManager manager = new AfishaManager(repository);

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
        Movie[] expected = new Movie[]{ten, nine, eight, seven, six, five, four, three, two, one};

        assertArrayEquals(expected, actual);

        //Проверка вызова заглушки
        verify(repository).findAll();
    }
}