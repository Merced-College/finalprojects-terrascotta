import java.util.ArrayList; // DATA STRUCTURE #3: ArrayList

public class SearchEngine {
    
    // ALGORITHM #3: Linear Search/Filtering
    public ArrayList<String> findInPage(String query, String pageContent) {
        ArrayList<String> results = new ArrayList<>();
        if (pageContent.contains(query)) {
            results.add("Match found on current page!");
        } else {
            results.add("No matches in this specific volume.");
        }
        return results;
    }
}