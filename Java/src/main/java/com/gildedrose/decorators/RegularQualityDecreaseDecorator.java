package com.gildedrose.decorators;

import com.gildedrose.item.DecoratableItem;

public class RegularQualityDecreaseDecorator extends ItemDecorator {
    public RegularQualityDecreaseDecorator(DecoratableItem item) {
        super(item);
    }

    @Override
    public int getQuality() {
        int quality = super.getQuality();
        if (quality < 0) {
            return quality;
        }
        if (super.getSellIn() > 0) {
            return Math.max(quality - 1, 0);
        }
        return Math.max(quality - 2, 0);
    }
}
