package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        String url = movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(list -> list.stream())
                .reduce((box1, box2) -> box1.getWidth() > box2.getWidth() ? box1 : box2)
                .map(BoxArt::getUrl).get();

        return url;
    }
}
