package com.gildedrose;

import com.gildedrose.dto.Item;

import static com.gildedrose.GlidedRoseConstants.ItemNames.AGED_BRIE;
import static com.gildedrose.GlidedRoseConstants.ItemNames.BACKSTAGE_PASSES_TAFKAL80ETC;
import static com.gildedrose.GlidedRoseConstants.ItemNames.CONJURED_MANA_CAKES;
import static com.gildedrose.GlidedRoseConstants.ItemNames.DEXTERITY_5_VEST;
import static com.gildedrose.GlidedRoseConstants.ItemNames.MONGOOSE_ELIXIR;
import static com.gildedrose.GlidedRoseConstants.ItemNames.SULFURAS;

public class TexttestFixture {
    public static void main(String[] args) {
        // TODO log an useful statement, eg "application started with arguments ..."
        System.out.println("OMGHAI!");

        // TODO check that argument[0], if provided, is castable to an integer

        // TODO move item creation to a ItemRepository.class and a findAll() method or load from a resource file
        Item[] items = new Item[]{
                new Item(DEXTERITY_5_VEST, 10, 20), //
                new Item(AGED_BRIE, 2, 0), //
                new Item(MONGOOSE_ELIXIR, 5, 7), //
                new Item(SULFURAS, 0, 80), //
                new Item(SULFURAS, -1, 80),
                new Item(BACKSTAGE_PASSES_TAFKAL80ETC, 15, 20),
                new Item(BACKSTAGE_PASSES_TAFKAL80ETC, 10, 49),
                new Item(BACKSTAGE_PASSES_TAFKAL80ETC, 5, 49),
                new Item(CONJURED_MANA_CAKES, 3, 6),
                new Item(CONJURED_MANA_CAKES, 3, 60)};


        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}