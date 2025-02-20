package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    @Test
    void sellInNotZeroQualityMaximumSellInAndQualityDoesNotChangeTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sellInZeroQualityMaximumSellInAndQualityDoesNotChangeTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sellInMinusAndQualityMinusSellInAndQualityDoesNotChangeTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(-1, app.items[0].quality);
    }
}
