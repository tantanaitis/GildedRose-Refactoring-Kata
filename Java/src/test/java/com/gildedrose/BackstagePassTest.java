package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassTest {
    @Test
    void sellInOver10QualityIncreasesBy1Test() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void sellInBetween10And5QualityIncreasesBy2Test() {
        int initialSellIn = 10;
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, 0)};
        GildedRose app = new GildedRose(items);
        for (int i = 1; i <= 5; i++) {
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(initialSellIn-i, app.items[0].sellIn);
            assertEquals(i*2, app.items[0].quality);
        }
    }

    @Test
    void sellInBetween5AndZeroQualityIncreasesBy3Test() {
        int initialSellIn = 5;
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, 0)};
        GildedRose app = new GildedRose(items);
        for (int i = 1; i <= 5; i++) {
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(initialSellIn-i, app.items[0].sellIn);
            assertEquals(i*3, app.items[0].quality);
        }
    }

    @Test
    void sellInMinus1QualityDecreasesToZeroTest() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellInMinus1AndQualityMinus5QualityIncreasesToZeroTest() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, -5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
