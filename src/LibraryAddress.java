
public class LibraryAddress {
	
	private String hexagonId; // can be any string or number
	private int wall; // 1 - 4
	private int shelf; // 1 - 5
	private int volume; // 1 - 32
	private int page; // 1 - 410

	public LibraryAddress(String hexagonId, int wall, int shelf, int volume, int page) {
		this.hexagonId = hexagonId;
		
		// this validates the values, if not good, set to 1
		this.wall = (wall >= 1 && wall <= 4) ? wall : 1;
		this.shelf = (shelf >= 1 && shelf <= 5) ? shelf : 1;
		this.volume = (volume >= 1 && volume <= 32) ? volume : 1;
		this.page = (page >= 1 && page <= 410) ? page : 1;
	}
	
	// this gets the values when you WANT THEM
	
	public String getHexagonId() { return hexagonId; }
		public int getWall() { return wall; }
		public int getShelf() { return shelf; }
		public int getVolume() {return volume; }
		public int getPage() {return page; }
		@Override
		public String toString() {
			return String.format("Hex: %s, Wall: %d, Shelf: %d, Vol: %d, Page: %d", hexagonId, wall, shelf, volume, page);
		}
	}
	
	
	
	
	
	
	