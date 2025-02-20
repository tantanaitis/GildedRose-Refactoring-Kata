package com.gildedrose;

public class QualityToZeroOnSellInDateDecorator extends ItemDecorator {
    public QualityToZeroOnSellInDateDecorator(DecoratableItem item) {
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
