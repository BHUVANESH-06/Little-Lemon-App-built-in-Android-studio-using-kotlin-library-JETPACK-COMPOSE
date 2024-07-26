package com.example.myapplication.ui.theme

interface Destination{
    val route : String
}
object Home : Destination{
    override val route: String = "Home"
}
object Menu : Destination{
    override val route: String = "Menu"
}