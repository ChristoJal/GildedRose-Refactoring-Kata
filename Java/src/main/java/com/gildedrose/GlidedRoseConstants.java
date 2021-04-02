package com.gildedrose;

public final class GlidedRoseConstants {

    private GlidedRoseConstants() {}

    // TODO create and use item category instead of item names which will be very hard to maintain as list growths
    public static final class ItemNames {
        public static final String DEXTERITY_5_VEST = "+5 Dexterity Vest";
        public static final String AGED_BRIE = "Aged Brie";
        public static final String MONGOOSE_ELIXIR = "Elixir of the Mongoose";
        public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
        public static final String BACKSTAGE_PASSES_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
        public static final String CONJURED_MANA_CAKES = "Conjured Mana Cake";
    }

    public static final class ItemDetails {
        public static final int MIN_QUALITY = 0;
        public static final int MAX_QUALITY = 50;
        public static final int BACKSTAGE_PASSES_5DAYS_INCREASE_AMOUNT = 3;
        public static final int BACKSTAGE_PASSES_10DAYS_INCREASE_AMOUNT = 2;
    }
}