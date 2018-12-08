package a170194a.nyp.movierater

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.edit_page.*

class Edit_page_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_page)

        chkbxSuitable_edit.setOnClickListener(View.OnClickListener {
            if (chkbxSuitable_edit.isChecked()) {
                llotherBoxes_edit.setVisibility(View.VISIBLE)
            } else {
                llotherBoxes_edit.setVisibility(View.INVISIBLE)
            }
        })

        val id:Int = intent.extras.getInt("id")
        etMovieName_edit.setText(Movies.myMovieEntities[id].movietitle)
        etMovieDescription_edit.setText(Movies.myMovieEntities[id].overview)
        when (Movies.myMovieEntities[id].language) {
            "English" -> rbEnglish_edit.toggle()
            "Chinese" -> rbChinese_edit.toggle()
            "Malay" -> rbMalay_edit.toggle()
            "Tamil" -> rbTamil_edit.toggle()
            else -> rgLanguage.clearCheck()
        }
        etReleaseDate_edit.setText(Movies.myMovieEntities[id].release_date)
        if (Movies.myMovieEntities[id].suitability == true) {
            chkbxSuitable_edit.toggle()
            llotherBoxes_edit.setVisibility(View.VISIBLE)
        }
        if (Movies.myMovieEntities[id].violence == true) {
            chkbxViolence_Used_edit.toggle()
        }
        if (Movies.myMovieEntities[id].language_used == true) {
            chkbxLanguage_Used_edit.toggle()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_page_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.miSave) {
            val id:Int = intent.extras.getInt("id")
            var theitem:MovieEntity = Movies.myMovieEntities[id]
            theitem.movietitle = etMovieName_edit.text.toString()
            theitem.overview = etMovieDescription_edit.text.toString()
            var selected = rgLanguage_edit.findViewById<RadioButton>(rgLanguage_edit.checkedRadioButtonId).text.toString()
            theitem.language = selected
            theitem.release_date = etReleaseDate_edit.text.toString()
            theitem.suitability = chkbxSuitable_edit.isChecked()
            theitem.language_used = chkbxLanguage_Used_edit.isChecked()
            theitem.violence = chkbxViolence_Used_edit.isChecked()
            var intent:Intent = Intent(this, view_movie_activity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
        if (item?.itemId == R.id.miCancel) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}