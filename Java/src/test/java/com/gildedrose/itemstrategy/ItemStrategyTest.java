package com.gildedrose.itemstrategy;

import com.gildedrose.dto.Item;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GlidedRoseConstants.ItemDetails.BACKSTAGE_PASSES_10DAYS_INCREASE_AMOUNT;
import static com.gildedrose.GlidedRoseConstants.ItemDetails.BACKSTAGE_PASSES_5DAYS_INCREASE_AMOUNT;
import static com.gildedrose.GlidedRoseConstants.ItemDetails.MIN_QUALITY;
import static com.gildedrose.utils.ItemUtils.decreaseQuality;
import static com.gildedrose.utils.ItemUtils.decrementSellIn;
import static com.gildedrose.utils.ItemUtils.increaseQuality;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemStrategyTest {

    @Test
    void testDefaultStrategy() {
        // given
        int quality = 42;
        int sellIn = 442;
        ItemStrategy defaultStrategy = ItemStrategy.DefaultStrategy();
        Item sourceItem = new Item(null, sellIn, quality);
        // when
        defaultStrategy.getsOlderByOneDay(sourceItem);
        // then
        Item expectedItem = new Item(null, sellIn, quality);
        decrementSellIn(expectedItem);
        decreaseQuality(expectedItem);
        assertEquals(expectedItem.quality, sourceItem.quality);
        assertEquals(expectedItem.sellIn, sourceItem.sellIn);
    }

    @Test
    void testLegendaryStrategy() {
        // given
        int quality = 80;
        int sellIn = 42;
        ItemStrategy legendaryStrategy = ItemStrategy.LegendaryStrategy();
        Item item = new Item(null, sellIn, quality);
        // when
        legendaryStrategy.getsOlderByOneDay(item);
        // then
        assertEquals(quality, item.quality);
        assertEquals(sellIn, item.sellIn);
    }

    @Test
    void testWellAgingStrategy() {
        // given
        int quality = 1;
        int sellIn = 42;
        ItemStrategy wellAgingStrategy = ItemStrategy.WellAgingStrategy();
        Item sourceItem = new Item(null, sellIn, quality);
        // when
        wellAgingStrategy.getsOlderByOneDay(sourceItem);
        // then
        Item expectedItem = new Item(null, sellIn, quality);
        decrementSellIn(expectedItem);
        increaseQuality(expectedItem);
        assertEquals(expectedItem.quality, sourceItem.quality);
        assertEquals(expectedItem.sellIn, sourceItem.sellIn);
    }

    @Test
    void testBackStagePasseCustomStrategy_whenSellIn_isAbove10() {
        // given
        int quality = 1;
        int sellIn = 11;
        ItemStrategy backStagePasseCustomStrategy = ItemStrategy.BackStagePasseCustomStrategy();
        Item sourceItem = new Item(null, sellIn, quality);
        // when
        backStagePasseCustomStrategy.getsOlderByOneDay(sourceItem);
        // then
        Item expectedItem = new Item(null, sellIn, quality);
        decrementSellIn(expectedItem);
        increaseQuality(expectedItem);
        assertEquals(expectedItem.quality, sourceItem.quality);
        assertEquals(expectedItem.sellIn, sourceItem.sellIn);
    }

    @Test
    void testBackStagePasseCustomStrategy_whenDecrementedSellIn_isNegative() {
        // given
        int quality = 1;
        int sellIn = 0;
        ItemStrategy backStagePasseCustomStrategy = ItemStrategy.BackStagePasseCustomStrategy();
        Item sourceItem = new Item(null, sellIn, quality);
        // when
        backStagePasseCustomStrategy.getsOlderByOneDay(sourceItem);
        // then
        Item expectedItem = new Item(null, sellIn, quality);
        decrementSellIn(expectedItem);
        assertEquals(MIN_QUALITY, sourceItem.quality);
        assertEquals(expectedItem.sellIn, sourceItem.sellIn);
    }

    @Test
    void testBackStagePasseCustomStrategy_whenDecrementedSellIn_isLowerThan5() {
        // given
        int quality = 1;
        int sellIn = 5;
        ItemStrategy backStagePasseCustomStrategy = ItemStrategy.BackStagePasseCustomStrategy();
        Item sourceItem = new Item(null, sellIn, quality);
        // when
        backStagePasseCustomStrategy.getsOlderByOneDay(sourceItem);
        // then
        Item expectedItem = new Item(null, sellIn, quality);
        decrementSellIn(expectedItem);
        increaseQuality(expectedItem, BACKSTAGE_PASSES_5DAYS_INCREASE_AMOUNT);
        assertEquals(expectedItem.quality, sourceItem.quality);
        assertEquals(expectedItem.sellIn, sourceItem.sellIn);
    }

    @Test
    void testBackStagePasseCustomStrategy_whenDecrementedSellIn_isLowerThan10() {
        // given
        int quality = 1;
        int sellIn = 10;
        ItemStrategy backStagePasseCustomStrategy = ItemStrategy.BackStagePasseCustomStrategy();
        Item sourceItem = new Item(null, sellIn, quality);
        // when
        backStagePasseCustomStrategy.getsOlderByOneDay(sourceItem);
        // then
        Item expectedItem = new Item(null, sellIn, quality);
        decrementSellIn(expectedItem);
        increaseQuality(expectedItem, BACKSTAGE_PASSES_10DAYS_INCREASE_AMOUNT);
        assertEquals(expectedItem.quality, sourceItem.quality);
        assertEquals(expectedItem.sellIn, sourceItem.sellIn);
    }
}