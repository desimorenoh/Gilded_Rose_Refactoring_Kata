package com.gildedrose

class AgedBrie(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {

    override fun updateQualityOfItems(item: Item, adjustQuality: Int) {

        if (sellIn > 0) {
            quality += adjustQuality
        } else {
            quality += adjustQuality * 2
        }
        sellIn--
        if (quality > 50) {
            quality = 50
        }
    }
}
