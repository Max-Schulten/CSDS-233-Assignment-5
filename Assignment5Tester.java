import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment5Tester {

    // Underlying test museum
    ArtMuseum m = new ArtMuseum("Test Museum");

    // Test add
    @Test
    public void testAdd() {
        assertTrue(m.add(new Art(100, 10, 10, "Community", "Jeff Winger")));
        assertTrue(m.add(new Art(250, 20, 14, "Full Metal Jacket", "Stanley Kubrick")));
        assertTrue(m.add(new Art(1000, 23, 8, "Pulp Fiction", "Quentin Tarantino")));
        assertTrue(m.add(new Art(1000, 50, 50, "Reservoir Dogs", "Quentin Tarantino")));
        assertTrue(m.add(new Art(4, 21, 9, "Twitter", "Elon Musk")));
        assertTrue(m.add(new Art(1000, 20, 14, "Sorting Algorithms: Visualized", "Maximilian Schulten")));
    }

    @Test
    public void testFindArts() {
        m.add(new Art(100, 10, 10, "Community", "Jeff Winger"));
        m.add(new Art(250, 20, 14, "Full Metal Jacket", "Stanley Kubrick"));
        m.add(new Art(1000, 23, 8, "Pulp Fiction", "Quentin Tarantino"));
        m.add(new Art(1000, 50, 50, "Reservoir Dogs", "Quentin Tarantino"));
        m.add(new Art(4, 21, 9, "Twitter", "Elon Musk"));
        m.add(new Art(1000, 20, 14, "Sorting Algorithms: Visualized", "Maximilian Schulten"));

        assertEquals("Sorting Algorithms: Visualized", m.findArts("Maximilian Schulten").get(0).getName());
        assertEquals("Pulp Fiction", m.findArts("Quentin Tarantino").get(0).getName());
        assertEquals("Reservoir Dogs", m.findArts("Quentin Tarantino").get(1).getName());
        assertEquals("Twitter", m.findArts("Elon Musk").get(0).getName());
        assertTrue(m.findArts("Not There").isEmpty());
    }

    @Test
    public void testRandomizeArts() {
        m.add(new Art(100, 10, 10, "Community", "Jeff Winger"));
        m.add(new Art(250, 20, 14, "Full Metal Jacket", "Stanley Kubrick"));
        m.add(new Art(10, 100, 23, "Apples", "Somebody"));
        m.add(new Art(1000, 23, 8, "Pulp Fiction", "Quentin Tarantino"));
        m.add(new Art(1000, 50, 50, "Reservoir Dogs", "Quentin Tarantino"));
        m.add(new Art(4, 21, 9, "Twitter", "Elon Musk"));
        m.add(new Art(1402, 20, 14, "Sorting Algorithms: Visualized", "Maximilian Schulten"));

        // Not foolproof but best method I managed
        // Very, very small prob. these test cases fail
        assertNotEquals(Arrays.toString(m.randomizeArts(150).toArray()), Arrays.toString(m.randomizeArts(150).toArray()));
        assertNotEquals(Arrays.toString(m.randomizeArts(100).toArray()), Arrays.toString(m.randomizeArts(100).toArray()));
        assertTrue(m.randomizeArts(-1).isEmpty());
    }

    @Test
    public void testSort() {
        m.add(new Art(100, 10, 10, "Community", "Jeff Winger"));
        m.add(new Art(250, 20, 14, "Full Metal Jacket", "Stanley Kubrick"));
        m.add(new Art(10, 100, 23, "Apples", "Somebody"));
        m.add(new Art(1000, 23, 8, "Pulp Fiction", "Quentin Tarantino"));
        m.add(new Art(1000, 50, 50, "Reservoir Dogs", "Quentin Tarantino"));
        m.add(new Art(4, 21, 9, "Twitter", "Elon Musk"));
        m.add(new Art(1402, 20, 14, "Sorting Algorithms: Visualized", "Maximilian Schulten"));

        List<Art> sort = m.sort("price", 0);

        assertEquals("Twitter", sort.get(0).getName());
        assertEquals("Apples", sort.get(1).getName());
        assertEquals("Community", sort.get(2).getName());
        assertEquals("Sorting Algorithms: Visualized", sort.get(6).getName());

        sort = m.sort("price", -1);

        assertEquals("Sorting Algorithms: Visualized", sort.get(0).getName());
        assertEquals("Reservoir Dogs", sort.get(1).getName());
        assertEquals("Pulp Fiction", sort.get(2).getName());
        assertEquals("Twitter", sort.get(6).getName());

        sort = m.sort("height", 0);

        assertEquals("Community", sort.get(0).getName());
        assertEquals("Full Metal Jacket", sort.get(1).getName());
        assertEquals("Sorting Algorithms: Visualized", sort.get(2).getName());
        assertEquals("Apples", sort.get(6).getName());

        sort = m.sort("height", -1);

        assertEquals("Apples", sort.get(0).getName());
        assertEquals("Reservoir Dogs", sort.get(1).getName());
        assertEquals("Pulp Fiction", sort.get(2).getName());
        assertEquals("Community", sort.get(6).getName());

        sort = m.sort("width", 0);

        assertEquals("Pulp Fiction", sort.get(0).getName());
        assertEquals("Twitter", sort.get(1).getName());
        assertEquals("Community", sort.get(2).getName());
        assertEquals("Reservoir Dogs", sort.get(6).getName());

        sort = m.sort("width", -1);

        assertEquals("Reservoir Dogs", sort.get(0).getName());
        assertEquals("Apples", sort.get(1).getName());
        assertEquals("Sorting Algorithms: Visualized", sort.get(2).getName());
        assertEquals("Pulp Fiction", sort.get(6).getName());

        sort = m.sort("names", 0);

        assertEquals("Apples", sort.get(0).getName());
        assertEquals("Community", sort.get(1).getName());
        assertEquals("Full Metal Jacket", sort.get(2).getName());
        assertEquals("Twitter", sort.get(6).getName());

        sort = m.sort("names", -1);

        assertEquals("Twitter", sort.get(0).getName());
        assertEquals("Sorting Algorithms: Visualized", sort.get(1).getName());
        assertEquals("Reservoir Dogs", sort.get(2).getName());
        assertEquals("Apples", sort.get(6).getName());

        sort = m.sort("artistName", 0);

        assertEquals("Elon Musk", sort.get(0).getArtistName());
        assertEquals("Jeff Winger", sort.get(1).getArtistName());
        assertEquals("Maximilian Schulten", sort.get(2).getArtistName());
        assertEquals("Stanley Kubrick", sort.get(6).getArtistName());

        sort = m.sort("artistName", -1);

        assertEquals("Stanley Kubrick", sort.get(0).getArtistName());
        assertEquals("Somebody", sort.get(1).getArtistName());
        assertEquals("Quentin Tarantino", sort.get(2).getArtistName());
        assertEquals("Elon Musk" , sort.get(6).getArtistName());
    }

    @Test
    public void testRandomSort() {
        List<Art> l = new ArrayList<>();

        l.add(new Art(100, 10, 10, "Community", "Jeff Winger"));
        l.add(new Art(250, 20, 14, "Full Metal Jacket", "Stanley Kubrick"));
        l.add(new Art(10, 100, 23, "Apples", "Somebody"));
        l.add(new Art(1000, 23, 8, "Pulp Fiction", "Quentin Tarantino"));
        l.add(new Art(1000, 50, 50, "Reservoir Dogs", "Quentin Tarantino"));
        l.add(new Art(4, 21, 9, "Twitter", "Elon Musk"));
        l.add(new Art(1402, 20, 14, "Sorting Algorithms: Visualized", "Maximilian Schulten"));
        l.add(new Art(1239485, 4, 23, "Paintings and Such", "Claude Monet"));
        l.add(new Art(3, 100, 83, "Newcastle", "Eddie Howe"));
        l.add(new Art(1, 1, 1203, "Arsenal", "Mikel Arteta"));

        l = m.randomSort(l);

        assertEquals("Community",l.get(0).getName());
        assertEquals("Full Metal Jacket",l.get(1).getName());
        assertEquals("Apples",l.get(2).getName());
        assertEquals("Pulp Fiction",l.get(3).getName());
        assertEquals("Twitter",l.get(4).getName());
        assertEquals("Reservoir Dogs",l.get(5).getName());
        assertEquals("Paintings and Such",l.get(6).getName());
        assertEquals("Sorting Algorithms: Visualized",l.get(7).getName());
        assertEquals("Newcastle",l.get(8).getName());
        assertEquals("Arsenal",l.get(9).getName());

    }
}
