package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {


    open fun updateQualityOfItems(item: Item, adjustQuality: Int = 1) {
        sellIn--
        if (sellIn < 0) {
            quality -= adjustQuality * 2
        } else {
            quality -= adjustQuality
        }
        if (quality < 0) {
            quality = 0
        }
    }
}
