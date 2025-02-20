package com.gildedrose.item;

import com.gildedrose.Item;

public final class LegendaryItemWrapper implements NonDecoratableItem {
    private final Item item;
    public LegendaryItemWrapper(Item item) {
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
