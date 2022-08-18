package com.gildedrose

private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
private const val AGED_BRIE = "Aged Brie"
private const val CONJURED = "Conjured Mana Cake"

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.indices.forEach { i ->
            val item = items[i]
            updateItemQuality(item, i)
        }
    }

    private fun updateItemQuality(item: Item, i: Int) {

        val adjustQuality = 1

        when (item.name) {
            SULFURAS -> {
                updateItemSulfuras(item)
            }
            AGED_BRIE -> {
                updateItemAgedBrie(item, adjustQuality)
            }
            CONJURED -> {
                updateItemConjured(item, adjustQuality)
            }
            BACKSTAGE_PASSES -> {
                updatedBackstagePasses(item, adjustQuality)
            }
            else -> {
                UpdateRestOfItems(item, adjustQuality)
            }
        }
    }

    private fun UpdateRestOfItems(item: Item, adjustQuality: Int) {
        item.sellIn--
        if (item.sellIn < 0) {
            item.quality -= adjustQuality * 2
        } else {
            item.quality -= adjustQuality
        }
        if (item.quality < 0) {
            item.quality = 0
        }
    }

    private fun updatedBackstagePasses(item: Item, adjustQuality: Int) {
        item.sellIn--
        if (item.sellIn < 0) {
            item.quality = 0
        } else if (item.sellIn < 6) {
            item.quality += adjustQuality * 3
        } else if (item.sellIn in 6..10) {
            item.quality += adjustQuality * 2
        }
    }

    private fun updateItemConjured(item: Item, adjustQuality: Int) {
        item.sellIn--
        item.quality -= adjustQuality * 2
    }

    private fun updateItemAgedBrie(item: Item, adjustQuality: Int) {
        if (item.sellIn > 0) {
            item.quality += adjustQuality
        } else {
            item.quality += adjustQuality * 2
        }
        item.sellIn--
        if (item.quality > 50) {
            item.quality = 50
        }
    }

    private fun updateItemSulfuras(item: Item) {
        item.quality = 80
        item.sellIn = 0
    }
}
