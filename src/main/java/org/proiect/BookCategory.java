package org.proiect;

public enum BookCategory {

    MODERNI_CONTEMPORANI("Moderni, contemporani"),
    CLASICI("Clasici"),
    ACTIUNE_AVENTURA("Actiune, aventura"),
    CRIME_THRILLER_MISTER("Crime, thriller, mister"),
    FANTASY("Fantasy"),
    ISTORICA("Istorica"),
    SCIENCE_FICTION("Science fiction"),
    ROMANCE("Romance"),
    YOUNG_ADULT("Young adult"),
    ALTELE("Altele");
    private final String label;

    BookCategory(String label) {
        this.label = label;
    }
}
