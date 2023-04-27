package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    MovieObject movie1 = new MovieObject("Бладшот", "боевик");
    MovieObject movie2 = new MovieObject("Вперёд", "мультфильм");
    MovieObject movie3 = new MovieObject("Отель Белград", "комедия");
    MovieObject movie4 = new MovieObject("Джентльмены", "боевик");
    MovieObject movie5 = new MovieObject("Человек-невидимка", "ужасы");
    MovieObject movie6 = new MovieObject("Номер один", "комедия");

    @Test
    public void shouldAdd() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        MovieObject[] expected = {movie1, movie2, movie3, movie4, movie5, movie6};
        MovieObject[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfDefaultLimit() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        MovieObject[] expected = {movie5, movie4, movie3, movie2, movie1};
        MovieObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfOverLimit() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        MovieObject[] expected = {movie6, movie5, movie4, movie3, movie2};
        MovieObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfBelowLimit() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        MovieObject[] expected = {movie3, movie2, movie1};
        MovieObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfSetLimit() {
        PosterManager manager = new PosterManager(4);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        MovieObject[] expected = {movie6, movie5, movie4, movie3};
        MovieObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
