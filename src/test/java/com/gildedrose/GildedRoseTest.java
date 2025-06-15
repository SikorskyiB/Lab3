package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new AgedBrie(2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Sulfuras(0, 80),
                new Sulfuras(-1, 80),
                new BackstagePass(15, 20),
                new BackstagePass(10, 49),
                new BackstagePass(5, 49),
                new Item("Conjured Mana Cake", 3, 6) };

        List<String[]> expectedNames = new ArrayList<>();
        expectedNames.add(new String[] {
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Conjured Mana Cake"});
        expectedNames.add(new String[] {
                "+5 Dexterity Vest",
                "Aged Brie",
                "Elixir of the Mongoose",
                "Sulfuras, Hand of Ragnaros",
                "Sulfuras, Hand of Ragnaros",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Backstage passes to a TAFKAL80ETC concert",
                "Conjured Mana Cake"});

        List<Integer[]> expectedSellIns = new ArrayList<>();
        expectedSellIns.add(new Integer[] {10, 2, 5, 0, -1, 15, 10, 5, 3});
        expectedSellIns.add(new Integer[] {9, 1, 4, 0, -1, 14, 9, 4, 2});

        List<Integer[]> expectedQualities = new ArrayList<>();
        expectedQualities.add(new Integer[] {20, 0, 7, 80, 80, 20, 49, 49, 6});
        expectedQualities.add(new Integer[] {19, 1, 6, 80, 80, 21, 50, 50, 5});

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < items.length; i++) {
            assertEquals(expectedNames.get(0)[i], items[i].name);
            assertEquals(expectedSellIns.get(0)[i], items[i].sellIn);
            assertEquals(expectedQualities.get(0)[i], items[i].quality);
        }

        app.updateQuality();

        for (int i = 0; i < items.length; i++) {
            assertEquals(expectedNames.get(1)[i], items[i].name);
            assertEquals(expectedSellIns.get(1)[i], items[i].sellIn);
            assertEquals(expectedQualities.get(1)[i], items[i].quality);
        }
    }

}
