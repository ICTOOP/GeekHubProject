/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitnessmember;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Owner
 */
public class Datamember {

    EntityManagerFactory emf;

    private static Datamember instance = null;

    private Datamember() {
    }

    public static Datamember getInstance() {
        if (instance == null) {
            instance = new Datamember();
            instance.emf = Persistence.createEntityManagerFactory("JavaApplication1PU");

        }
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
