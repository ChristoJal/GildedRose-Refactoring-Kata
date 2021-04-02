package com.gildedrose.itemstrategy;

import com.gildedrose.itemstrategy.ItemStrategy;
import com.gildedrose.itemstrategy.ItemStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.gildedrose.GlidedRoseConstants.ItemNames.AGED_BRIE;
import static com.gildedrose.GlidedRoseConstants.ItemNames.BACKSTAGE_PASSES_TAFKAL80ETC;
import static com.gildedrose.GlidedRoseConstants.ItemNames.CONJURED_MANA_CAKES;
import static com.gildedrose.GlidedRoseConstants.ItemNames.DEXTERITY_5_VEST;
import static com.gildedrose.GlidedRoseConstants.ItemNames.MONGOOSE_ELIXIR;
import static com.gildedrose.GlidedRoseConstants.ItemNames.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertSame;

class ItemStrategyFactoryTest {

    private ItemStrategyFactory itemStrategyFactory;

    @BeforeEach
    public void setUp() {
        itemStrategyFactory = new ItemStrategyFactory();
    }

    @Test
    void testNewItemStrategy() {
        assertSame(ItemStrategy.WellAgingStrategy(), itemStrategyFactory.newItemStrategy(AGED_BRIE));
        assertSame(ItemStrategy.LegendaryStrategy(), itemStrategyFactory.newItemStrategy(SULFURAS));
        assertSame(ItemStrategy.BackStagePasseCustomStrategy(), itemStrategyFactory.newItemStrategy(BACKSTAGE_PASSES_TAFKAL80ETC));
        assertSame(ItemStrategy.ConjuredStrategy(), itemStrategyFactory.newItemStrategy(CONJURED_MANA_CAKES));

        assertSame(ItemStrategy.DefaultStrategy(), itemStrategyFactory.newItemStrategy(DEXTERITY_5_VEST));
        assertSame(ItemStrategy.DefaultStrategy(), itemStrategyFactory.newItemStrategy(MONGOOSE_ELIXIR));
    }

    @Test
    void testNewItemStrategy_withUnknownItemName() {
        // given
        String unexpectedItemName = UUID.randomUUID().toString(); // poor collision chances
        // when & then
        assertSame(ItemStrategy.DefaultStrategy(), itemStrategyFactory.newItemStrategy(unexpectedItemName));
    }
}