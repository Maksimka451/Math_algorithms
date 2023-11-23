package com.kiranbahalaskar.navigationdrawer

sealed class NavigationItem(var route: String, var icon: Int, var title: String)
{
    object Home : NavigationItem("home", R.drawable.one, "Euclid")
    object Profile : NavigationItem("profile", R.drawable.second, "Eyler")
    object Settings : NavigationItem("settings", R.drawable.third, "Leghandr")
    object Share : NavigationItem("share", R.drawable.fourth, "Yakobi")
    object Contact : NavigationItem("contact", R.drawable.fifth, "Квад. вычеты")
    object Features : NavigationItem("features", R.drawable.sixth, "Куб. вычеты")
}
