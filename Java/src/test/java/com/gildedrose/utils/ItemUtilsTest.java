package com.gildedrose.utils;

import com.gildedrose.dto.Item;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GlidedRoseConstants.ItemDetails.MAX_QUALITY;
import static com.gildedrose.GlidedRoseConstants.ItemDetails.MIN_QUALITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemUtilsTest {

    @Test
    void testDecrementSellIn() {
        // given
        int sellIn = 42;
        Item item = new Item(null, sellIn, 0);
        // when
        ItemUtils.decrementSellIn(item);
        // then
        assertEquals(sellIn - 1, item.sellIn);
    }

    @Test
    void testDecreaseQuality_withPositiveSellInValue() {
        // given
        int sellIn = 42;
        int quality = 43;
        Item item = new Item(null, sellIn, quality);
        // when
        ItemUtils.decreaseQuality(item);
        // then
        assertEquals(quality - 1, item.quality);
    }

    @Test
    void testDecreaseQuality_withNegativeSellInValue() {
        // given
        int sellIn = -1;
        int quality = 42;
        Item item = new Item(null, sellIn, quality);
        // when
        ItemUtils.decreaseQuality(item);
        // then
        assertEquals(quality - 2, item.quality);
    }

    @Test
    void testDecreaseQuality_lowestQualityLimit() {
        // given
        int quality = MIN_QUALITY;
        Item item = new Item(null, 42, quality);
        // when
        ItemUtils.decreaseQuality(item);
        // then
        assertEquals(MIN_QUALITY, item.quality);
    }

    @Test
    void testDecreaseQuality_withAmountParam_withPositiveSellInValue() {
        // given
        int amount = 3;
        int sellIn = 42;
        int quality = 43;
        Item item = new Item(null, sellIn, quality);
        // when
        ItemUtils.decreaseQuality(item, amount);
        // then
        assertEquals(quality - amount, item.quality);
    }

    @Test
    void testDecreaseQuality_withAmountParam_withNegativeSellInValue() {
        // given
        int amount = 3;
        int sellIn = -1;
        int quality = 42;
        Item item = new Item(null, sellIn, quality);
        // when
        ItemUtils.decreaseQuality(item, amount);
        // then
        assertEquals(quality - (amount * 2), item.quality);
    }

    @Test
    void testDecreaseQuality_withAmountParam_lowestQualityLimit() {
        // given
        int amount = 3;
        int quality = MIN_QUALITY;
        Item item = new Item(null, 42, quality);
        // when
        ItemUtils.decreaseQuality(item, amount);
        // then
        assertEquals(MIN_QUALITY, item.quality);
    }

    @Test
    void testIncreaseQuality() {
        // given
        int quality = 0;
        Item item = new Item(null, 42, quality);
        // when
        ItemUtils.increaseQuality(item);
        // then
        assertEquals(quality + 1, item.quality);
    }

    @Test
    void testDecreaseQuality_highestQualityLimit() {
        // given
        int quality = MAX_QUALITY;
        Item item = new Item(null, 42, quality);
        // when
        ItemUtils.increaseQuality(item);
        // then
        assertEquals(MAX_QUALITY, item.quality);
    }

    @Test
    void testIncreaseQuality_withAmountParam() {
        // given
        int amount = 3;
        int quality = 0;
        Item item = new Item(null, 42, quality);
        // when
        ItemUtils.increaseQuality(item, amount);
        // then
        assertEquals(quality + amount, item.quality);
    }

    @Test
    void testIncreaseQuality_withAmountParam_highestQualityLimit() {
        // given
        int amount = 3;
        int quality = MAX_QUALITY;
        Item item = new Item(null, 42, quality);
        // when
        ItemUtils.increaseQuality(item, amount);
        // then
        assertEquals(MAX_QUALITY, item.quality);
    }
}