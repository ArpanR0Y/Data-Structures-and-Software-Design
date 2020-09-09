import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

	  TreeMap<String, PriorityQueue<Integer>> treeMap = new TreeMap<>();

	  if (allUsersRatings == null) {
	    return treeMap;
    }

		for (UserMovieRating userMovieRating : allUsersRatings) {

		  if (validUserRating(userMovieRating)) {
		    String movie = userMovieRating.getMovie().toLowerCase();
		    int rating = userMovieRating.getUserRating();

        PriorityQueue<Integer> queue;
        if (treeMap.containsKey(movie)) {
          queue = treeMap.get(movie);
        } else {
          queue = new PriorityQueue<>();
        }
        queue.add(rating);
        treeMap.put(movie, queue);
      }
    }

		return treeMap;
	}

	private static boolean validUserRating(UserMovieRating userMovieRating) {
	  return userMovieRating != null && userMovieRating.getMovie() != null &&
        !userMovieRating.getMovie().isEmpty() && userMovieRating.getUserRating() >= 0;
  }

}