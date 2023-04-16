import java.util.*;

/**
 * Class that represents a collection of Art pieces.
 */
public class ArtMuseum {

    // Field that holds all art pieces
    ArrayList<Art> collection = new ArrayList<>();

    // Field that holds the museum's name
    private final String museumName;

    /**
     * Constructor that initializes a new museum
     * @param museumName name of musueum
     */
    public ArtMuseum(String museumName) {
        this.museumName = museumName;
    }

    /**
     * Method that adds a new piece to the museum
     * @param art piece to add
     * @return true if piece added successfully
     */
    public boolean add(Art art) {
        return collection.add(art);
    }

    /**
     * Returns all piece in the collection by a given artist
     * @param artistName name of artist to look for
     * @return list of all pieces by artist
     */
    public List<Art> findArts(String artistName) {
        // Init. a new list to store art pieces
        ArrayList<Art> list = new ArrayList<>();
        // Parse through all art pieces
        for(Art piece : collection) {
            // Compare name to given name
            if(piece.getArtistName().equals(artistName))
                // Add if the same
                list.add(piece);
        }
        return list;
    }

    public List<Art> randomizeArts(int n) {
        // Init. new list
        ArrayList<Art> list = new ArrayList<>();

        // Init. new hashtable to check if index has been added
        Hashtable<Integer, Integer> table = new Hashtable<>();

        // New Random instance to generate random indices
        Random random = new Random();

        // Return empty list if n too small
        if(n <= 0)
            return list;

        // Check if n is too large, if so reduce
        if(n > collection.size())
            n = collection.size();


        // Iterate n times, and add n random pieces
        for(int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(collection.size());
            // Checking if index has already been added
            if(table.get(randomIndex) == null) {
                // Put in hash map, and add to return list
                table.put(randomIndex, randomIndex);
                list.add(collection.get(randomIndex));
            } else
                // Decrement i to ensure we add n art objects
                i--;
        }

        // Return the list of art pieces
        return list;
    }

    /**
     * Sorts collection by given attribute and in the given direction
     * @param attribute attribute to sort by
     * @param direction direction to sort in
     * @return sorted list
     */
    public List<Art> sort(String attribute, int direction) {
        // Wrapper for the recursive sort implemented
        sortRecursive(collection, 0, collection.size()-1, attribute, direction);
        // Return the sorted list
        return collection;
    }

    public List<Art> randomSort(List<Art> arts) {
        // Calculate how many values to sort at a time
        int increment = arts.size()/5;
        // Sort every partition
        sortRecursive(arts, 0, increment-1, "height", 0);
        sortRecursive(arts, increment, (2*increment-1), "price", 0);
        sortRecursive(arts, 2 * increment, (3*increment-1), "width", 0);
        sortRecursive(arts, 3 * increment, (4*increment-1), "names", 0);
        sortRecursive(arts, 4 * increment, arts.size()-1, "artistName", 0);
        // Return the sorte
        return arts;
    }

    /**
     * Helper method that sorts from low bound to high bound by a price
     * @param low lower bound
     * @param high higher bound
     * @param attribute attribute to sort by
     */
    private void sortRecursive(List<Art> list, int low, int high, String attribute, int direction) {
        // Checking if anything left to be sorted
        if(low < high) {
            // Index to split at
            int splitIndex;

            // Assign splitIndex
            splitIndex = split(list, low, high, attribute, direction);

            // Sorting both sub-arrays created above
            sortRecursive(list, low, splitIndex-1, attribute, direction);
            sortRecursive(list,splitIndex+1, high, attribute, direction);
        }

    }

    /**
     * Helper method that sorts a list of Art objects around a pivot point
     * @param list list to sort
     * @param low beginning index
     * @param high ending index
     * @param attribute What to sort by
     * @return index of sorted pivot point
     */
    private int split(List<Art> list, int low, int high, String attribute, int direction) {
        // Sets the last elements as the pivot
        Art pivot = list.get(high);
        // Sets the lower pointer
        int i = low-1;

        // Iterating through sub-array
        for(int j = low; j < high; j++) {
            // Checking element and direction
            if (direction >= 0) {
                if (Art.compare(list.get(j), pivot, attribute) <= 0) {
                    // Moving left pointer
                    i++;
                    // Swapping if smaller than pivot
                    Collections.swap(list, i, j);
                }
            } else {
                if (Art.compare(list.get(j), pivot, attribute) >= 0) {
                    // Moving left pointer
                    i++;
                    // Swapping if smaller than pivot
                    Collections.swap(list, i, j);
                }
            }
        }

        // Placing pivot in its place
        Collections.swap(list, i+1, high);

        // Returning the index of the sorted pivot
        return i+1;
    }




}
