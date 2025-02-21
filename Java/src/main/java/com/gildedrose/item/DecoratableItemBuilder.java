package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.decorators.*;

public class DecoratableItemBuilder {
    private DecoratableItem item;

    private DecoratableItemBuilder(DecoratableItem item) {
        this.item = item;
    }

    public DecoratableItemBuilder withRegularQualityDecrease() {
        this.item = new RegularQualityDecreaseDecorator(this.item);
        return this;
    }

    public DecoratableItemBuilder withRegularSellInDecrease() {
        this.item = new RegularSellInDecreaseDecorator(this.item);
        return this;
    }

    public DecoratableItemBuilder withQualityToZeroOnSellinDate() {
        this.item = new QualityToZeroOnSellInDateDecorator(this.item);
        return this;
    }

    public DecoratableItemBuilder withAgedBrieQualityIncrease() {
        this.item = new AgedBrieQualityIncreaseDecorator(this.item);
        return this;
    }

    public DecoratableItemBuilder withQualityIncreaseOnSellInDateCondition(int sellInTrigger) {
        this.item = new QualityIncreaseOnSellInDateConditionDecorator(this.item, sellInTrigger);
        return this;
    }

    public static DecoratableItemBuilder from(Item item) {
        return new DecoratableItemBuilder(new ItemWrapper(item));
    }

    public DecoratableItem build() {
        return this.item;
    }
}
