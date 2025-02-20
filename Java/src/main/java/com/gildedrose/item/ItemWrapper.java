package com.gildedrose.item;

import com.gildedrose.Item;

public class ItemWrapper implements DecoratableItem {
    private final Item item;
    public ItemWrapper(Item item) {
        this.item = item;
    }
    @Override
    public String getName() {
        return item.name;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public int getQuality() {
        return item.quality;
    }
}
