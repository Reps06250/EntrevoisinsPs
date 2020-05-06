package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void createNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        // save neighbours list size
        int neighboursOriginalSize = neighbours.size();
        Neighbour neighbour = new Neighbour(13,"bli","bla","blo","blu","ble",false);
        // Add a neighbour
        service.createNeighbour(neighbour);
        // Check neighbours have 1 element more
        assertEquals(neighbours.size(), neighboursOriginalSize + 1, 0.001);
    }

    @Test
    public void getFavoritesWithSuccess() {
        List<Neighbour> favorites = service.getFavorites();
        List<Neighbour> expectedFavorites = DummyNeighbourGenerator.generateNeighbours();
        for(Neighbour neighbour : DummyNeighbourGenerator.generateNeighbours())
            if(!neighbour.isFavorite())expectedFavorites.remove(neighbour);
        assertThat(favorites, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavorites.toArray()));
    }

    @Test
    public void addFavoriteWithSuccess() {
        Neighbour neighbour = new Neighbour(13,"bli","bla","blo","blu","ble",false);
        service.createNeighbour(neighbour);
        assertFalse(service.getFavorites().contains(neighbour));
        neighbour.setFavorite(true);// on passe le neighbour en favoris
        assertTrue(service.getFavorites().contains(neighbour));
    }

    @Test
    public void deleteFavoriteWithSuccess() {
        Neighbour neighbour = new Neighbour(13,"bli","bla","blo","blu","ble",true);
        service.createNeighbour(neighbour);
        assertTrue(service.getFavorites().contains(neighbour));
        neighbour.setFavorite(false);// on passe le neighbour en non-favoris
        assertFalse(service.getFavorites().contains(neighbour));
    }
}
