package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void regularItemSellInNotZeroSellInDecreasesBy1AndQualityDecreasesBy1Test() {
        Item[] items = new Item[] { new Item("regular", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void regularItemSellInZeroSellInDecreasesBy1AndQualityDecreasesBy2Test() {
        Item[] items = new Item[] { new Item("regular", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void regularItemSellInZeroSellInDecreasesBy1AndQualityDecreasesBy2ButNotBelowZeroTest() {
        Item[] items = new Item[] { new Item("regular", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieSellInNotZeroSellInDecreasesQualityIncreasesTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void agedBrieSellInNotZeroQuality50QualityDoesNotIncreaseOver50Test() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurSellInNotZeroSellInAndQualityDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurSellInZeroSellInAndQualityDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePassSellInOver10QualityIncreasesBy1Test() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }


    @Test
    void backstagePassSellInBetween10And5QualityIncreasesBy2Test() {
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
    void backstagePassSellInBetween5AndZeroQualityIncreasesBy3Test() {
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
    void backstagePassSellInMinus1QualityDecreasesToZeroTest() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void backstagePassSellInMinus1AndQualityMinus1QualityIncreasesToZeroTest() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
