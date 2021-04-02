package com.gildedrose.itemstrategy;

import java.util.HashMap;
import java.util.Map;

import static com.gildedrose.GlidedRoseConstants.ItemNames.AGED_BRIE;
import static com.gildedrose.GlidedRoseConstants.ItemNames.BACKSTAGE_PASSES_TAFKAL80ETC;
import static com.gildedrose.GlidedRoseConstants.ItemNames.SULFURAS;

public class ItemStrategyFactory {

    private static final Map<String, ItemStrategy> itemsMap = new HashMap<String, ItemStrategy>() {{
        put(AGED_BRIE, ItemStrategy.WellAgingStrategy());
        put(SULFURAS, ItemStrategy.LegendaryStrategy());
        put(BACKSTAGE_PASSES_TAFKAL80ETC, ItemStrategy.BackStagePasseCustomStrategy());
    }};

    public ItemStrategy newItemStrategy(final String itemName) {
        return itemsMap.getOrDefault(itemName, ItemStrategy.DefaultStrategy());
    }
}