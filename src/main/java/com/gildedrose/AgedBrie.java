package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQualityIfNeeded();

        sellIn--;
        if (sellIn < 0) {
            increaseQualityIfNeeded();
        }
    }
}

