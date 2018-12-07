package a170194a.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.rate_movie.*
import kotlinx.android.synthetic.main.view_movie.*
import java.io.Serializable

class view_movie_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)

        try {

            var movie = intent.extras.get("Movie") as MovieEntity

            viewMovie_title.text = movie.movietitle
            viewMovie_overview.text = movie.overview
            viewMovie_language.text = movie.language
            viewMovie_releaseDate.text = movie.release_date
            var suitability = ""
            if (movie.suitability == true) {
                suitability = "No"
            } else {
                suitability = "Yes"
            }
            viewMovie_suitable.text = suitability

            if (movie.review != null) {
                rbviewMovie_RB.setVisibility(View.VISIBLE)
                rbviewMovie_RB.setRating(movie.review.toString().toFloat())
                viewMovie_reviews.text = movie.review_reason
            }
        } catch (e: Exception) {

        }
        registerForContextMenu(viewMovie_reviews)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == viewMovie_reviews.id) {
            menu?.add(1, 1, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1) {
            var movie = intent.extras.get("Movie") as MovieEntity
            var Intent = Intent(this, rate_movie_activity::class.java)
            Intent.putExtra("Movie", movie as Serializable)
            startActivity(Intent)
        }
        return super.onContextItemSelected(item)
    }

}
