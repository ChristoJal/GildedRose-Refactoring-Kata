package com.gildedrose.itemstrategy;

import com.gildedrose.dto.Item;

import static com.gildedrose.GlidedRoseConstants.ItemDetails.BACKSTAGE_PASSES_10DAYS_INCREASE_AMOUNT;
import static com.gildedrose.GlidedRoseConstants.ItemDetails.BACKSTAGE_PASSES_5DAYS_INCREASE_AMOUNT;
import static com.gildedrose.GlidedRoseConstants.ItemDetails.MIN_QUALITY;
import static com.gildedrose.utils.ItemUtils.decreaseQuality;
import static com.gildedrose.utils.ItemUtils.decrementSellIn;
import static com.gildedrose.utils.ItemUtils.increaseQuality;

public interface ItemStrategy {

    /*********************************************************
     * Generic strategies
     ********************************************************/
    static ItemStrategy DefaultStrategy() {
        return item -> {
            decrementSellIn(item);
            decreaseQuality(item);
        };
    }

    static ItemStrategy LegendaryStrategy() {
        return item -> {};
    }

    static ItemStrategy WellAgingStrategy() {
        return item -> {
            decrementSellIn(item);
            increaseQuality(item);
        };
    }

    static ItemStrategy ConjuredStrategy() {
        return item -> {
            decrementSellIn(item);
            decreaseQuality(item, 2);
        };
    }

    /*********************************************************
     * Custom strategies
     ********************************************************/
    static ItemStrategy BackStagePasseCustomStrategy() {
        return item -> {
            decrementSellIn(item);

            if (item.sellIn < 0) {
                item.quality = MIN_QUALITY;
            } else if (item.sellIn < 5) {
                increaseQuality(item, BACKSTAGE_PASSES_5DAYS_INCREASE_AMOUNT);
            } else if (item.sellIn < 10) {
                increaseQuality(item, BACKSTAGE_PASSES_10DAYS_INCREASE_AMOUNT);
            } else {
                increaseQuality(item);
            }
        };
    }

    void getsOlderByOneDay(Item item);
}