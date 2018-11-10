package a170194a.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkbxSuitable.setOnClickListener(View.OnClickListener {
            if (chkbxSuitable.isChecked) {
                llotherBoxes.setVisibility(View.VISIBLE)
            } else {
                llotherBoxes.setVisibility(View.INVISIBLE)
            }
        })
    }

    fun validateForm(v: View) {
        if (etMovieName.text.toString() == "" || etMovieDescription.text.toString() == "" || etReleaseDate.text.toString() == "") {
            if (etMovieName.text.toString() == "") {
                etMovieName.setError("Field empty")
            }

            if (etMovieDescription.text.toString() == "") {
                etMovieDescription.setError("Field empty")
            }

            if (etReleaseDate.text.toString() == "") {
                etReleaseDate.setError("Field empty")
            }
        } else {
            var language_used = ""
            var violence = ""
            var language = when (rgLanguage.checkedRadioButtonId) {
                1 -> "English"
                2 -> "Chinese"
                3 -> "Malay"
                4 -> "Tamil"
                else -> ""
            }
            if (chkbxSuitable.isChecked) {
                if (chkbxLanguage_Used.isChecked) {
                    language_used = "true"
                }
                if (chkbxViolence_Used.isChecked) {
                    violence = "true"
                }
            }
            var duration = Toast.LENGTH_LONG
            var text = "Title = " + etMovieName.text.toString() + "\n" +
                    "Overview = " + etMovieDescription.text.toString() + "\n" +
                    "Release date = " + etReleaseDate.text.toString() + "\n" +
                    "Language = " + language + "\n" +
                    "Suitable for all ages = " + chkbxSuitable.isChecked() + "\n" +
                    "Reason : " + "\n" +
                    "Language : " + language_used + "\n" +
                    "Violence : " + violence
            Toast.makeText(applicationContext, text, duration).show()
            var movie = MovieEntity(etMovieName.text.toString(),etMovieDescription.text.toString(),language,etReleaseDate.text.toString(), !chkbxSuitable.isChecked())
            var Intent = Intent(this, view_movie_activity::class.java)
            Intent.putExtra("Movie", movie as Serializable)
            startActivity(Intent)
        }
    }

}
