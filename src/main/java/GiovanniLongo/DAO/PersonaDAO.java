package GiovanniLongo.DAO;

import GiovanniLongo.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("La persona " + persona.getNome() + " " + persona.getCognome() + " aggiunta correttamente!");
    }

    public Persona findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Persona.class, id);
    }


    public void findByIdAndDelete(long id) {
        Persona found = this.findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La persona " + found.getNome() + " " + found.getCognome() + " eliminato correttamente!");

        } else {
            System.out.println("L'evento con l'id " + id + " non è stato trovato");
        }


    }
}