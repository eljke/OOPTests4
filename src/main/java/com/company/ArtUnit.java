package com.company;

import java.util.Objects;

public abstract class ArtUnit implements InfoPrinting{
    protected String name;
    protected int genre;
    protected int rating;

    public String getName(){
        return name;
    }

    public int getGenre(){
        return genre;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setGenre(int genre){
        this.genre = genre;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public abstract int getInfo();
}