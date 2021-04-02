package com.gildedrose.utils;

import com.gildedrose.dto.Item;

import static com.gildedrose.GlidedRoseConstants.ItemDetails.MAX_QUALITY;
import static com.gildedrose.GlidedRoseConstants.ItemDetails.MIN_QUALITY;

public final class ItemUtils {

    private ItemUtils() {}

    public static void decrementSellIn(Item item) {
        item.sellIn--;
    }

    public static void decreaseQuality(Item item) {
        decreaseQuality(item, 1);
    }

    public static void decreaseQuality(Item item, int qualityAmount) {
        if (item.sellIn < 0) {
            qualityAmount = qualityAmount * 2;
        }
        item.quality = Math.max(item.quality - qualityAmount, MIN_QUALITY);
    }

    public static void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    public static void increaseQuality(Item item, int qualityAmount) {
        item.quality = Math.min(item.quality + qualityAmount, MAX_QUALITY);
    }
}