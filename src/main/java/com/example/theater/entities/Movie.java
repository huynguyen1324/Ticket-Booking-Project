package com.example.theater.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String posterUrl;
    private String description;
    private String releaseDate;
    private boolean nowShowing;
    private String trailerUrl;
    private String genre;
    private String director;
    private String actors;
    private int duration;
    private String language;
    private String rated;
    private String bannerUrl;
    private String keywords; // Chuỗi các từ khoá phục vụ chức năng tìm kiếm phim
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments; // Một Movie có nhiều Comment

    public Movie(String title, String posterUrl, String description, String releaseDate, String nowShowing, String trailerUrl, String genre, String director, String actors, String duration, String language, String rated, String bannerUrl, String keywords) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.description = description;
        this.releaseDate = releaseDate;
        this.nowShowing = Boolean.parseBoolean(nowShowing);
        this.trailerUrl = trailerUrl;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.duration = Integer.parseInt(duration);
        this.language = language;
        this.rated = rated;
        this.bannerUrl = bannerUrl;
        this.keywords = keywords;
    }
}
