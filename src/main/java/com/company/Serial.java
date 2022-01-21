package com.company;

import java.util.Objects;

public class Serial extends ArtUnit implements InfoPrinting{

    @Override
    public int getInfo(){
        return getRating();
    }

    @Override
    public String getFullInfo(){
        return ("Сериал: " + getName() + ", рейтинг: " + getInfo() + ", жанр: " + getGenre() + "\n");
    }

    @Override
    public String getPartialInfo(){
        return ("Сериал: " + getName() + ", рейтинг: " + getRating() + "\n");
    };

    public Serial(String name, int rating, int genre) {
        setName(name);
        setGenre(genre);
        setRating(rating);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtUnit artUnit = (ArtUnit) o;
        return genre == artUnit.genre && rating == artUnit.rating && Objects.equals(name, artUnit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, rating);
    }
}