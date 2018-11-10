package a170194a.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.view_movie.*

class view_movie_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)
        val movie = intent.extras.get("Movie") as MovieEntity

        viewMovie_title.text = movie.movietitle
        viewMovie_overview.text = movie.overview
        viewMovie_language.text = movie.language
        viewMovie_releaseDate.text = movie.release_date
        viewMovie_suitable.text = movie.suitability.toString()
    }


}
