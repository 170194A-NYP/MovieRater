package a170194a.nyp.movierater

class Movies {
    companion object MovieEntries {
        var myMovieEntities = arrayListOf<MovieEntity>()
        var number:Int = 0;
        @JvmStatic
        fun addMovie (movie: MovieEntity) {
            myMovieEntities.add(movie)
            number = number + 1
        }

        @JvmStatic
        fun returnMovies() : ArrayList<MovieEntity>? {
            return myMovieEntities
        }
    }
}