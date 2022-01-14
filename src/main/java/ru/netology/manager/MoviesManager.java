package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor

public class MoviesManager {

    private int numberOfFilms = 10;
    private Movie[] movies = new Movie[0];

    public MoviesManager(int numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }

    public void add(Movie film) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        movies = tmp;
    }

    public Movie[] getAll() {
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
