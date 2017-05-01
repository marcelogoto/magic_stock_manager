package com.marcelo.gt.magicstockmanager;

/**
 * Created by Avell on 01/05/2017.
 */

public class Card {
    private final String imageUrl;

    public Card(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
