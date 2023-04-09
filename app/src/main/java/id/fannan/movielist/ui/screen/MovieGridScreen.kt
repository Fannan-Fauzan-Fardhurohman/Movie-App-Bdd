package id.fannan.movielist.ui.screen


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import id.fannan.movielist.domain.model.Movie
import id.fannan.movielist.ui.components.MovieItem

@ExperimentalMaterial3Api
@Composable
fun MovieGridScreen(
    paddingValues: PaddingValues, movies: List<Movie>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(movies) { movie ->
            val mContext = LocalContext.current
            MovieItem(
                modifier = Modifier.padding(horizontal = 16.dp),
                isGrid = true,
                movie = movie,
                onItemClick = {
                    mToast(mContext)
                }
            )
        }
    }
}

private fun mToast(context: Context){
    Toast.makeText(context, "Item Clicked", Toast.LENGTH_LONG).show()
}
