package com.gildedrose;

import com.gildedrose.dto.Item;
import com.gildedrose.itemstrategy.ItemStrategyFactory;

class GildedRose {
    Item[] items;

    // TODO challenge requirements to allow changes in constructor and pass itemStrategyFactory instance
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        if (items == null) {
            throw new RuntimeException("items cannot be null");
        }

        ItemStrategyFactory itemStrategyFactory = new ItemStrategyFactory();

        for (Item item : items) {
            if (item == null) {
                throw new RuntimeException("null item not allowed");
            }

            itemStrategyFactory
                    .newItemStrategy(item.name)
                    .getsOlderByOneDay(item);
        }
    }
}