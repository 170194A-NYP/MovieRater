package a170194a.nyp.movierater

import android.widget.RatingBar
import java.io.Serializable

class MovieEntity(Title : String, Overview : String, Language : String, Release_Date : String, Suitability : Boolean, Violence : Boolean, Language_used : Boolean) : Serializable {

    var movietitle = Title
    var overview = Overview
    var language = Language
    var release_date = Release_Date
    var suitability = !Suitability
    var violence = Violence
    var language_used = Language_used
    var review:Float? = null
    var review_reason:String? = null

}