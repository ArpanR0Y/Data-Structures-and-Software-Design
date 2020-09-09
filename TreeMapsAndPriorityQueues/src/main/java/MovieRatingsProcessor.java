import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {

    return movieRatings != null ? new ArrayList<>(movieRatings.keySet()) : new ArrayList<>();
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> sortedMoviesAboveRating = new ArrayList<>();

		if (movieRatings == null || movieRatings.isEmpty()) {
		  return sortedMoviesAboveRating;
    }

    //the PriorityQueue is a min-heap, meaning that the smallest rating is at the front of the queue!
    for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
		  int minRating = entry.getValue().peek();
      if (minRating > rating) {
        sortedMoviesAboveRating.add(entry.getKey());
      }
    }

		return sortedMoviesAboveRating;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
    TreeMap<String, Integer> movieRatingsRemoved = new TreeMap<>();
    List<String> moviesToBeRemoved = new ArrayList<>();

    if (movieRatings == null) {
      return movieRatingsRemoved;
    }

    for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
      int noOfRatingsRemoved = 0;
      int minRating = entry.getValue().peek();

      while (minRating < rating) {
          entry.getValue().remove();
          noOfRatingsRemoved++;
          if (entry.getValue().peek() != null) {
            minRating = entry.getValue().peek();
          } else {
            moviesToBeRemoved.add(entry.getKey());
            break;
          }
      }
      if (noOfRatingsRemoved > 0) {
        movieRatingsRemoved.put(entry.getKey(), noOfRatingsRemoved);
      }
    }

    for (String movie : moviesToBeRemoved) {
      movieRatings.remove(movie);
    }

		return movieRatingsRemoved;
	}
}
