package com.gildedrose.decorators;

import com.gildedrose.item.DecoratableItem;

public class RegularSellInDecreaseDecorator extends ItemDecorator {
    public RegularSellInDecreaseDecorator(DecoratableItem item) {
        super(item);
    }

    @Override
    public int getSellIn() {
        return super.getSellIn()-1;
    }
}
