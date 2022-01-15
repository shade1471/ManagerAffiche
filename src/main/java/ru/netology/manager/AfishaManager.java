package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
@AllArgsConstructor

public class AfishaManager {

    private int numberOfFilms = 10;
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(Movie film) {
        repository.save(film);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        int resultLength;
        if (movies.length < numberOfFilms) {
            resultLength = movies.length;
        } else {
            resultLength = numberOfFilms;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
