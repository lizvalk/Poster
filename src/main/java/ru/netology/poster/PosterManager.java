package ru.netology.poster;

public class PosterManager {
    private MovieObject[] poster = new MovieObject[0];
    private int limit;
    public PosterManager() {
        limit = 5;
    }
    public PosterManager(int limit) {
        this.limit = limit;
    }
    public void add(MovieObject movie) {
        MovieObject[] tmp = new MovieObject[poster.length + 1];
        for (int i = 0; i < poster.length; i++) {
            tmp[i] = poster[i];
        }
        tmp[tmp.length - 1] = movie;
        poster = tmp;
    }
    public MovieObject[] findAll() {
        return poster;
    }
    public MovieObject[] findLast() {
        int resultLength;
        if (poster.length < limit) {
            resultLength = poster.length;
        } else {
            resultLength = limit;
        }
        MovieObject[] reversed = new MovieObject[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = poster[poster.length - 1 - i];
        }
        return reversed;
    }
}
