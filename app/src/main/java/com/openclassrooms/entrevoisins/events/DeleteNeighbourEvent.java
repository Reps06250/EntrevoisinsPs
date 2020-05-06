package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */
public class DeleteNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;
    public int tag;

    /**
     * Constructor.
     * @param neighbour
     */
    public DeleteNeighbourEvent(Neighbour neighbour, int tag) {
        this.neighbour = neighbour;
        this.tag = tag;//je retourne le tag d'instance de façon à gerer la logique du delete selon si je suis dans la liste complète ou celle des favoris
    }
}