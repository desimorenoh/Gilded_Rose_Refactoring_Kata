package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

private const val DEXTERITY_VEST = "+5 Dexterity Vest"

class GildedRoseTest {

    @Test
    fun `all items have a sellIn property`() {
        val items = listOf(Item(DEXTERITY_VEST, 10, 20))

        assertEquals(10, items[0].sellIn)
    }

    @Test
    fun `all items have a name`() {
        val items = listOf(Item(DEXTERITY_VEST, 10, 20))

        assertEquals(DEXTERITY_VEST, items[0].name)
    }

    @Test
    fun `all items have a quality property`() {
        val items = listOf(Item(DEXTERITY_VEST, 10, 20))

        assertEquals(20, items[0].quality)
    }

    @Test
    fun `every day decrease all values for each item`() {
        val items = listOf(Item(DEXTERITY_VEST, 10, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, items[0].sellIn)
        assertEquals(19, items[0].quality)
    }

    @Test
    fun `when the recommended date has passed, the quality degrades twice as fast`() {
        val items = listOf(Item(DEXTERITY_VEST, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(-1, items[0].sellIn)
        assertEquals(8, items[0].quality)
    }

    @Test
    fun `the quality of the item is never negative`() {
        val items = listOf(Item(DEXTERITY_VEST, -7, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(-8, items[0].sellIn)
        assertEquals(0, items[0].quality)
    }
}



