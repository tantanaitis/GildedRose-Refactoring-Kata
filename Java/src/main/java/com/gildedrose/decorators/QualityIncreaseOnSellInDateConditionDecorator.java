package com.gildedrose.decorators;

import com.gildedrose.item.DecoratableItem;

public class QualityIncreaseOnSellInDateConditionDecorator extends ItemDecorator {
    private final int sellInTrigger;

    public QualityIncreaseOnSellInDateConditionDecorator(DecoratableItem item, int sellInTrigger) {
        super(item);
        this.sellInTrigger = sellInTrigger;
    }

    @Override
    public int getQuality() {
        if (super.getSellIn() <= sellInTrigger) {
           return super.getQuality() + 1;
        }
        return super.getQuality();
    }
}
