package com.gildedrose

class Conjured(sellIn: Int, quality: Int) : Item("Conjured Mana Cake", sellIn, quality){

    override fun updateQualityOfItems(item: Item, adjustQuality: Int) {
        sellIn--
        quality -= adjustQuality * 2
    }
}