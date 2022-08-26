package com.gildedrose

class BackstagePasses(sellIn: Int, quality: Int) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {

    override fun updateQualityOfItems(item: Item, adjustQuality: Int) {

        sellIn--
        if (sellIn < 0) {
            quality = 0
        } else if (sellIn < 6) {
            quality += adjustQuality * 3
        } else if (sellIn in 6..10) {
            quality += adjustQuality * 2
        }
    }
}