package com.gildedrose;

public class DecoratableItemBuilder {
    private DecoratableItem item;
    public DecoratableItemBuilder(DecoratableItem item) {
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

    public DecoratableItemBuilder witAgedBrieQualityIncrease() {
        this.item = new AgedBrieQualityIncreaseDecorator(this.item);
        return this;
    }

    public DecoratableItemBuilder withQualityIncreaseOnSellInDateCondition(int sellInTrigger) {
        this.item = new QualityIncreaseOnSellInDateConditionDecorator(this.item, sellInTrigger);
        return this;
    }
}
