package com.gildedrose;

public class RegularSellInDecreaseDecorator extends ItemDecorator {
    public RegularSellInDecreaseDecorator(DecoratableItem item) {
        super(item);
    }

    @Override
    public int getSellIn() {
        return super.getSellIn()-1;
    }
}
