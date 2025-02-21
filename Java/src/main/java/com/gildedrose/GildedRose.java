package com.gildedrose;

import com.gildedrose.item.ItemFactory;
import com.gildedrose.item.NonDecoratableItem;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            NonDecoratableItem nonDecoratableItem = ItemFactory.getInvetoryItem(item);
            int newSellIn = nonDecoratableItem.getSellIn();
            int newQuality = nonDecoratableItem.getQuality();
            item.quality = newQuality;
            item.sellIn = newSellIn;
        });
    }
}
