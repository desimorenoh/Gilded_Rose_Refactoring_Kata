package com.gildedrose

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class GildedRoseTest {

    @Test
    fun `return a list of items`() {
        val items = listOf(
            REGULAR_ITEM,
            AGED_BRIE,
            BACKSTAGE_PASSES,
            SULFURAS,
            CONJURED
        )

        val gildedRose = GildedRose(items)

        assertEquals(5, gildedRose.items.size)
    }

    @Test
    fun `return an update quality`() {
        val items = listOf(
            REGULAR_ITEM,
            AGED_BRIE,
            BACKSTAGE_PASSES,
            SULFURAS,
            CONJURED
        )

        val gildedRose = GildedRose(items)

        assertEquals(listOf(
            RegularItem(name = "+5 Dexterity Vest", sellIn=4, quality=6),
            AgedBrie(sellIn = 1, quality = 1),
            BackstagePasses(sellIn = 9, quality = 22),
            Sulfuras(sellIn = 0, quality = 80),
            Conjured(sellIn = 2, quality = 4)),
            gildedRose.updateQuality())
    }
}

private val REGULAR_ITEM = RegularItem("+5 Dexterity Vest", 5, 7)
private val AGED_BRIE = AgedBrie(2, 0)
private val BACKSTAGE_PASSES = BackstagePasses(10, 20)
private val SULFURAS = Sulfuras(0, 80)
private val CONJURED = Conjured(3, 6)
