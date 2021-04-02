package com.gildedrose;

import com.gildedrose.dto.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        // given
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        // TODO GlidedRose constructor should propose an ItemStrategyFactory instance parameter that could be mocked and verified using a mocking framework (Mockito?)
        // then nothing expected
    }

    @Test
    void testUpdateQuality_withEmptyItemArray() {
        // given
        Item[] items = new Item[0];
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        // then nothing expected
    }

    @Test
    void testUpdateQuality_withNullItemArray() {
        // given
        Item[] items = null;
        GildedRose app = new GildedRose(items);
        // when
        Assertions.assertThrows(RuntimeException.class, app::updateQuality);
    }

    @Test
    void testUpdateQuality_withItemArrayContainsNull() {
        // given
        Item[] items = new Item[]{null};
        GildedRose app = new GildedRose(items);
        // when
        Assertions.assertThrows(RuntimeException.class, app::updateQuality);
    }
}