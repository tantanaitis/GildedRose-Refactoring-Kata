package com.gildedrose;

import com.gildedrose.item.DecoratableItemBuilder;
import com.gildedrose.item.LegendaryItemWrapper;
import com.gildedrose.item.NonDecoratableItem;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;
    private static final List<String> SPECIAL_ITEM_NAMES = Arrays.asList("Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Aged Brie");
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            if (!SPECIAL_ITEM_NAMES.contains(items[i].name)) {
                NonDecoratableItem item = DecoratableItemBuilder.from(items[i])
                    .withRegularQualityDecrease()
                    .withRegularSellInDecrease()
                    .build();
                items[i].sellIn = item.getSellIn();
                items[i].quality  = item.getQuality();
                continue;
            }

            if ("Aged Brie".equals(items[i].name)) {
                NonDecoratableItem item = DecoratableItemBuilder.from(items[i])
                    .withAgedBrieQualityIncrease()
                    .withRegularSellInDecrease()
                    .build();
                items[i].sellIn = item.getSellIn();
                items[i].quality  = item.getQuality();
                continue;
            }
            if ("Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                NonDecoratableItem item = new LegendaryItemWrapper(items[i]);
                items[i].sellIn = item.getSellIn();
                items[i].quality  = item.getQuality();
                continue;
            }
            if ("Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                NonDecoratableItem item = DecoratableItemBuilder.from(items[i])
                    .withAgedBrieQualityIncrease()
                    .withQualityIncreaseOnSellInDateCondition(10)
                    .withQualityIncreaseOnSellInDateCondition(5)
                    .withQualityToZeroOnSellinDate()
                    .withRegularSellInDecrease()
                    .build();
                int newSellIn = item.getSellIn();
                int newQuality = item.getQuality();
                items[i].quality = newQuality;
                items[i].sellIn = newSellIn;
            }
        }
    }
}
