package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie film) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        movies = tmp;
    }

    public Movie[] findById(String id) {
        Movie[] tmp = new Movie[1];
        int index = 0;
        for (Movie film : movies) {
            if (film.getId().equals(id)) {
                tmp[index] = film;
            }
        }
        return tmp;
    }

    public void removeById(String id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie film : movies) {
            if (!film.getId().equals(id)) {
                tmp[index] = film;
                index++;
            }
        }
        movies = tmp;
    }

    public Movie[] removeAll() {
        this.movies = new Movie[0];
        return movies;
    }
}
