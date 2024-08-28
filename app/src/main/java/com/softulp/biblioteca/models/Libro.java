package com.softulp.biblioteca.models;

import java.io.Serializable;

public class Libro implements Serializable {

    private String title;
    private String summary;
    private String authors;
    private String genres;
    private int ageRelease;
    private int pages;
    private int cover;

    public Libro(String title, String summary, String authors, int ageRelease, String genres, int pages, int cover) {
        this.title = title;
        this.summary = summary;
        this.authors = authors;
        this.ageRelease = ageRelease;
        this.genres = genres;
        this.pages = pages;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getAuthors() {
        return authors;
    }

    public String getGenres() {
        return genres;
    }

    public int getAgeRelease() {
        return ageRelease;
    }

    public int getPages() {
        return pages;
    }

    public int getCover() {return cover;}
}
