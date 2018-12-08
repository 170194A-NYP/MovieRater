package a170194a.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.rate_movie.*
import kotlinx.android.synthetic.main.view_movie.*
import java.io.Serializable

class view_movie_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)

        val id:Int = intent.extras.getInt("id")
        viewMovie_title.setText(Movies.myMovieEntities[id].movietitle)
        viewMovie_overview.setText(Movies.myMovieEntities[id].overview)
        viewMovie_language.setText(Movies.myMovieEntities[id].language)
        viewMovie_releaseDate.setText(Movies.myMovieEntities[id].release_date)
        if (Movies.myMovieEntities[id].suitability == true) {
            viewMovie_suitable.setText("No")
        } else if (Movies.myMovieEntities[id].suitability == false) {
            viewMovie_suitable.setText("Yes")
        }
        if (Movies.myMovieEntities[id].review != null) {
            rbviewMovie_RB.setVisibility(View.VISIBLE)
            rbviewMovie_RB.setRating(Movies.myMovieEntities[id].review.toString().toFloat())
            viewMovie_reviews.setText(Movies.myMovieEntities[id].review_reason)
        } else {
            rbviewMovie_RB.setVisibility(View.GONE)
            viewMovie_reviews.setText(R.string.viewMovie_review)
        }
        registerForContextMenu(viewMovie_reviews)
    }

    override fun onResume() {
        super.onResume()

        val id:Int = intent.extras.getInt("id")
        viewMovie_title.setText(Movies.myMovieEntities[id].movietitle)
        viewMovie_overview.setText(Movies.myMovieEntities[id].overview)
        viewMovie_language.setText(Movies.myMovieEntities[id].language)
        viewMovie_releaseDate.setText(Movies.myMovieEntities[id].release_date)
        if (Movies.myMovieEntities[id].suitability == true) {
            viewMovie_suitable.setText("No")
        } else if (Movies.myMovieEntities[id].suitability == false) {
            viewMovie_suitable.setText("Yes")
        }
        if (Movies.myMovieEntities[id].review != null) {
            rbviewMovie_RB.setVisibility(View.VISIBLE)
            rbviewMovie_RB.setRating(Movies.myMovieEntities[id].review.toString().toFloat())
            viewMovie_reviews.setText(Movies.myMovieEntities[id].review_reason)
        } else {
            rbviewMovie_RB.setVisibility(View.GONE)
            viewMovie_reviews.setText(R.string.viewMovie_review)
        }
        registerForContextMenu(viewMovie_reviews)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == viewMovie_reviews.id) {
            menu?.add(1, 1, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1) {
            var id = intent.extras.getInt("id")
            var Intent = Intent(this, rate_movie_activity::class.java)
            Intent.putExtra("id", id)
            startActivity(Intent)
        }
        return super.onContextItemSelected(item)
    }

}
