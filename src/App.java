import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        ApiRequest api = new ApiRequest();
        String body = api.body("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json");
        JsonParse parser = new JsonParse();
        List<Map<String, String>> movieList = parser.parse(body);

        for (Map<String,String> movie : movieList) {
            System.out.println("\u001b[36mName: \u001b[m\u001b[1m" + movie.get("title") + "\u001b[m ");
            System.out.println("\u001b[36mPoster: \u001b[m\u001b[4m\u001b[34m" + movie.get("image") + "\u001b[m ");
            System.out.print("\u001b[36mRating: \u001b[m" + movie.get("imDbRating") + " - ");
            double rating = Double.parseDouble(movie.get("imDbRating"));
            int stars = (int) rating;
            for (int i = 1; i <= stars; i++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }
    }
    
}
