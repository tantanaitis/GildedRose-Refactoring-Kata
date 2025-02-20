package com.gildedrose;

public class QualityToZeroDecoratorOnSellInDate extends ItemDecorator {
    public QualityToZeroDecoratorOnSellInDate(DecoratableItem item) {
        super(item);
    }

    @Override
    public int getQuality() {
        if (super.getSellIn() <= 0) {
            return 0;
        }
        return super.getQuality();
    }
}
