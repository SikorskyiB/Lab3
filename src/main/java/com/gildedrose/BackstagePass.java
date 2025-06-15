package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQualityIfNeeded();
        if (sellIn < 11) {
            increaseQualityIfNeeded();
        }
        if (sellIn < 6) {
            increaseQualityIfNeeded();
        }

        sellIn--;
        if (sellIn < 0) {
            quality = 0;
        }
    }
}

