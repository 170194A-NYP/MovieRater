package a170194a.nyp.movierater

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.rate_movie.*
import java.io.Serializable

class rate_movie_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_movie)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rate_movie_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSubmit) {
            var movie = intent.extras.get("Movie") as MovieEntity
            movie.review = rbRating.getRating()
            movie.review_reason = etShareView.text.toString()
            var Intent = Intent(this, view_movie_activity::class.java)
            Intent.putExtra("Movie", movie as Serializable)
            startActivity(Intent)
        }
        return super.onOptionsItemSelected(item)
    }
}