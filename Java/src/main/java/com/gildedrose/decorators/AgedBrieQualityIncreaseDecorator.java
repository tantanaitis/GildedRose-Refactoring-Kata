package com.gildedrose.decorators;

import com.gildedrose.item.DecoratableItem;

public class AgedBrieQualityIncreaseDecorator extends ItemDecorator {
    public AgedBrieQualityIncreaseDecorator(DecoratableItem item) {
        super(item);
    }

    @Override
    public int getQuality() {
        if (super.getSellIn() < 0) {
            return Math.min(super.getQuality()+2, 50);
        }
        return Math.min(super.getQuality()+1, 50);
    }
}
