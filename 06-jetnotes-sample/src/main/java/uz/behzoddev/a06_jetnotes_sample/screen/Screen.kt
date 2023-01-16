package uz.behzoddev.a06_jetnotes_sample.screen

sealed interface Screen {
    object Home: Screen
    object Delete: Screen
}