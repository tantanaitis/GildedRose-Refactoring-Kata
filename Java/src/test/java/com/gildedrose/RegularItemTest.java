package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularItemTest {
    @Test
    void sellInNotZeroQualityNotZeroSellInDecreasesBy1AndQualityDecreasesBy1Test() {
        Item[] items = new Item[] { new Item("regular", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellInZeroQuality2SellInDecreasesBy1AndQualityDecreasesBy2Test() {
        Item[] items = new Item[] { new Item("regular", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellInZeroQuality1SellInDecreasesBy1AndQualityDecreasesBy2ButNotBelowZeroTest() {
        Item[] items = new Item[] { new Item("regular", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellInZeroQualityMinus1QualityDoesNotChangeTest() {
        Item[] items = new Item[] { new Item("regular", 0, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(-1, app.items[0].quality);
    }
}
