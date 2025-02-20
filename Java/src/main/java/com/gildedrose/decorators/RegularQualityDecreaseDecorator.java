package com.gildedrose.decorators;

import com.gildedrose.item.DecoratableItem;

public class RegularQualityDecreaseDecorator extends ItemDecorator {
    public RegularQualityDecreaseDecorator(DecoratableItem item) {
        super(item);
    }

    @Override
    public int getQuality() {
        if (super.getQuality() < 0) {
            return super.getQuality();
        }
        if (super.getSellIn() > 0) {
            return Math.max(super.getQuality() - 1, 0);
        }
        return Math.max(super.getQuality() - 2, 0);
    }
}
