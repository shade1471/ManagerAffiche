package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Movie {

    private String id;
    private String name;
    private String genre;
    private String imageUrl;
    private boolean premiereTomorrow;

}
