package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val DEXTERITY_VEST = "+5 Dexterity Vest"

class RegularItemTest {

    @Test
    fun `all items have a sellIn property`() {
        val items = listOf(RegularItem(DEXTERITY_VEST, 10, 20))

        assertEquals(10, items[0].sellIn)
    }

    @Test
    fun `all items have a name`() {
        val items = listOf(RegularItem(DEXTERITY_VEST, 10, 20))

        assertEquals(DEXTERITY_VEST, items[0].name)
    }

    @Test
    fun `all items have a quality property`() {
        val items = listOf(RegularItem(DEXTERITY_VEST, 10, 20))

        assertEquals(20, items[0].quality)
    }

    @Test
    fun `every day decrease all values for each item`() {
        val items = listOf(RegularItem(DEXTERITY_VEST, 10, 20))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(9, (updateQuality[0] as RegularItem).sellIn)
        assertEquals(19, (updateQuality[0] as RegularItem).quality)
    }

    @Test
    fun `when the recommended date has passed, the quality degrades twice as fast`() {
        val items = listOf(RegularItem(DEXTERITY_VEST, 0, 10))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(-1, (updateQuality[0] as RegularItem).sellIn)
        assertEquals(8, (updateQuality[0] as RegularItem).quality)
    }

    @Test
    fun `the quality of the item is never negative`() {
        val items = listOf(RegularItem(DEXTERITY_VEST, -7, 0))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(-8, (updateQuality[0] as RegularItem).sellIn)
        assertEquals(0, (updateQuality[0] as RegularItem).quality)
    }
}



