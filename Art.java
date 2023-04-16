import javax.xml.stream.events.Attribute;

/**
 * Class that represents a given art piece.
 */
public class Art {

    // Field that holds the price of a piece
    private int price;

    // Field that holds the height
    private int height;

    // Field that holds the width
    private int width;

    // Field that holds the name
    private String name;

    // Field that holds the artist's name
    private String artistName;

    /**
     * Constructor that initializes a new piece of art
     * @param price given price
     * @param height given dimension
     * @param width given dimension
     * @param name given name
     * @param artistName given artist name
     */
    public Art(int price, int height, int width, String name, String artistName) {
        this.price = price;
        this.height = height;
        this.width = width;
        this.name = name;
        this.artistName = artistName;
    }

    /**
     * Method that returns the price
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Method that sets the price
     * @param price integer price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Method that returns the height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Method that sets the height
     * @param height integer height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Method that returns the width
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method that sets the width
     * @param width integer width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Method that returns the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name
     * @param name piece name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that returns the artist name
     * @return artist name
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Method that sets the name
     * @param artistName artist's name
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * To String method for legibility
     * @return string representation of the piece
     */
    @Override
    public String toString() {
        return "Art{" +
                "price=" + price +
                ", height=" + height +
                ", width=" + width +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }

    /**
     * Compares 2 art pieces in the same way comparator does but with an extra parameter
     * @param a Art piece a
     * @param b Art piece b
     * @param attribute what attributes to compare
     * @return 0 if equal, 1 if a ">" b, -1 if a "<" b
     */
    protected static int compare(Art a, Art b, String attribute){
        // Compare based on attribute passed in, return the appropriate integer outlined in comment above
        if(attribute.equals("price")) {
            if (a.getPrice() > b.getPrice())
                return 1;
            if (a.getPrice() < b.getPrice())
                return -1;
            if (a.getPrice() == b.getPrice())
                return 0;
        }
        if(attribute.equals("height")) {
            if (a.getHeight() > b.getHeight())
                return 1;
            if (a.getHeight() < b.getHeight())
                return -1;
            if (a.getHeight() == b.getHeight())
                return 0;
        }
        if(attribute.equals("width")) {
            if (a.getWidth() > b.getWidth())
                return 1;
            if (a.getWidth() < b.getWidth())
                return -1;
            if (a.getWidth() == b.getWidth())
                return 0;
        }
        if(attribute.equals("names"))
            return a.getName().compareToIgnoreCase(b.getName());

        if(attribute.equals("artistName"))
            return a.getArtistName().compareToIgnoreCase(b.getArtistName());

        // Statement should never be reachable given valid input
        throw new IllegalArgumentException();
    }


}
