package com.gildedrose;

public abstract class ItemDecorator implements DecoratableItem {
    private DecoratableItem item;

    public ItemDecorator(DecoratableItem item) {
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public int getSellIn() {
        return item.getSellIn();
    }

    public int getQuality() {
        return item.getQuality();
    }
}
