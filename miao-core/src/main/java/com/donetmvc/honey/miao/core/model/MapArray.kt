package com.eland.android.pangpangRN.model

import android.os.Parcel
import android.os.Parcelable

data class MapArray(
        var orderId: String? = "",
        var uuid: String? = "",
        var items: ArrayList<Item>? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            arrayListOf<Item>().apply {
                parcel.readList(this, Item::class.java.classLoader)
            })

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(orderId)
        parcel.writeString(uuid)
        parcel.writeList(items)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MapArray> {
        override fun createFromParcel(parcel: Parcel): MapArray {
            return MapArray(parcel)
        }

        override fun newArray(size: Int): Array<MapArray?> {
            return arrayOfNulls(size)
        }
    }
}

data class Item(
        var brand_code: String? = "",
        var shop_code: String? = ""
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand_code)
        parcel.writeString(shop_code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}