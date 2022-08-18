package com.gildedrose

import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

private const val AGED_BRIE = "Aged Brie"


class AgedBrieTest {

    @Test
    fun `aged brie increases in quality the older it gets`() {
        val items = arrayOf(Item(AGED_BRIE, 2, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, Matchers.equalTo(1))
        assertThat(items[0].quality, equalTo(1))
    }

    @Test
    fun `after the date of sale its quality increases 2 units per day`() {
        val items = arrayOf(Item(AGED_BRIE, 0, 2))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(-1))
        assertThat(items[0].quality, equalTo(4))

    }

    @Test
    fun `the quality of the item is never greater than 50`() {
        val items = arrayOf(Item(AGED_BRIE, 10, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, Matchers.equalTo(9))
        assertThat(items[0].quality, Matchers.equalTo(50))
    }


}