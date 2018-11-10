package a170194a.nyp.movierater

import java.io.Serializable

class MovieEntity(Title : String, Overview : String, Language : String, Release_Date : String, Suitability : Boolean) : Serializable {

    val movietitle = Title
    val overview = Overview
    val language = Language
    val release_date = Release_Date
    val suitability = !Suitability

}