package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    @Test
    void sellInNotZeroQualityNotZeroSellInDecreasesBy1AndQualityDoesNotDropBelowZeroTest() {
        Item[] items = new Item[] { new Item("Conjured", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellIn1Quality2SellInDecreasesBy1AndQualityDecreasesBy2Test() {
        Item[] items = new Item[] { new Item("Conjured", 1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellInZeroQualityMinus1QualityDoesNotChangeTest() {
        Item[] items = new Item[] { new Item("Conjured", 0, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(-1, app.items[0].quality);
    }

}
