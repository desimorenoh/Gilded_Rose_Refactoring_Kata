package com.gildedrose

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

private const val DEXTERITY_VEST = "+5 Dexterity Vest"

class GildedRoseTest {

    @Test
    fun `all items have a sellIn property`() {
        val items = arrayOf(Item(DEXTERITY_VEST, 10, 20))

        assertThat(items[0].sellIn, equalTo(10))
    }

    @Test
    fun `all items have a name`() {
        val items = arrayOf(Item(DEXTERITY_VEST, 10, 20))

        assertThat(items[0].name, equalTo(DEXTERITY_VEST))
    }

    @Test
    fun `all items have a quality property`() {
        val items = arrayOf(Item(DEXTERITY_VEST, 10, 20))

        assertThat(items[0].quality, equalTo(20))
    }

    @Test
    fun `every day decrease all values for each item`() {
        val items = arrayOf(Item(DEXTERITY_VEST, 10, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertThat(items[0].sellIn, equalTo(9))
        assertThat(items[0].quality, equalTo(19))
    }

    @Test
    fun `when the recommended date has passed, the quality degrades twice as fast`() {
        val items = arrayOf(Item(DEXTERITY_VEST, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(-1))
        assertThat(items[0].quality, equalTo(8))
    }

    @Test
    fun `the quality of the item is never negative`() {
        val items = arrayOf(Item(DEXTERITY_VEST, -7, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(-8))
        assertThat(items[0].quality, equalTo(0))
    }
}



