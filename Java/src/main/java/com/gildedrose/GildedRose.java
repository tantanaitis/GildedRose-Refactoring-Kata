package com.gildedrose;

import com.gildedrose.item.DecoratableItemBuilder;
import com.gildedrose.item.ItemFactory;
import com.gildedrose.item.LegendaryItemWrapper;
import com.gildedrose.item.NonDecoratableItem;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;
    private static final List<String> SPECIAL_ITEM_NAMES = Arrays.asList("Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Aged Brie");
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            NonDecoratableItem item = ItemFactory.getInvetoryItem(items[i]);
            int newSellIn = item.getSellIn();
            int newQuality = item.getQuality();
            items[i].quality = newQuality;
            items[i].sellIn = newSellIn;
        }
    }
}
