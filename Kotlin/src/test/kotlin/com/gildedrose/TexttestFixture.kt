package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = listOf(
        "+5 Dexterity Vest", 10, 20, //
        "Elixir of the Mongoose", 5, 7, //
        "Aged Brie", 2, 0, //
        "Sulfuras, Hand of Ragnaros", 0, 80, //
        "Sulfuras, Hand of Ragnaros", -1, 80,
        "Backstage passes to a TAFKAL80ETC concert", 15, 20,
        "Backstage passes to a TAFKAL80ETC concert", 10, 49,
        "Backstage passes to a TAFKAL80ETC concert", 5, 49,
        // this conjured item does not work properly yet
        "Conjured Mana Cake", 3, 6
    )

    val app: GildedRose = GildedRose(listOf())

    var days = 2
    if (args.isNotEmpty()) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0 until days) {
        println("------------------ day $i ------------------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }
}
