package com.gildedrose.item;


import com.gildedrose.Item;

public class ItemFactory {
    private ItemFactory() {}

    public static NonDecoratableItem getInvetoryItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
               return DecoratableItemBuilder.from(item)
                    .withAgedBrieQualityIncrease()
                    .withRegularSellInDecrease()
                    .build();
            case "Backstage passes to a TAFKAL80ETC concert":
                return DecoratableItemBuilder.from(item)
                    .withAgedBrieQualityIncrease()
                    .withQualityIncreaseOnSellInDateCondition(10)
                    .withQualityIncreaseOnSellInDateCondition(5)
                    .withQualityToZeroOnSellinDate()
                    .withRegularSellInDecrease()
                    .build();
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItemWrapper(item);
            case "Conjured":
                return DecoratableItemBuilder.from(item)
                    .withRegularQualityDecrease()
                    .withRegularQualityDecrease()
                    .withRegularSellInDecrease()
                    .build();
            default:
               return DecoratableItemBuilder.from(item)
                    .withRegularQualityDecrease()
                    .withRegularSellInDecrease()
                    .build();
        }
    }
}
