public class LibraryAddress {
    
    private String hexagonId; 
    private int wall; 
    private int shelf; 
    private int volume; 
    private int page; 
    private String searchQuery; // ADDED: to hold the searched word

    // Constructor 1: For normal navigation (no search word)
    public LibraryAddress(String hexagonId, int wall, int shelf, int volume, int page) {
        this(hexagonId, wall, shelf, volume, page, null);
    }

    // Constructor 2: For the Search Engine (includes the search word)
    public LibraryAddress(String hexagonId, int wall, int shelf, int volume, int page, String searchQuery) {
        this.hexagonId = hexagonId;
        this.wall = (wall >= 1 && wall <= 4) ? wall : 1;
        this.shelf = (shelf >= 1 && shelf <= 5) ? shelf : 1;
        this.volume = (volume >= 1 && volume <= 32) ? volume : 1;
        this.page = (page >= 1 && page <= 410) ? page : 1;
        this.searchQuery = searchQuery;
    }
    
    public String getHexagonId() { return hexagonId; }
    public int getWall() { return wall; }
    public int getShelf() { return shelf; }
    public int getVolume() { return volume; }
    public int getPage() { return page; }
    public String getSearchQuery() { return searchQuery; } // ADDED

    @Override
    public String toString() {
        return String.format("Hex: %s, Wall: %d, Shelf: %d, Vol: %d, Page: %d", hexagonId, wall, shelf, volume, page);
    }
}