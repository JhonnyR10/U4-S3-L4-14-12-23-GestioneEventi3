package GiovanniLongo.DAO;

import GiovanniLongo.entities.Concerto;
import GiovanniLongo.entities.Evento;
import GiovanniLongo.entities.GenereMusica;
import GiovanniLongo.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " aggiunto correttamente!");
    }

    public Evento findById(long id) {
        // SELECT * FROM students WHERE id = 1
        return em.find(Evento.class, id);
    }


    public void findByIdAndDelete(long id) {
        Evento found = this.findById(id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Evento " + found.getTitolo() + " eliminato correttamente!");

        } else {
            System.out.println("L'evento con l'id " + id + " non è stato trovato");
        }


    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereMusica genere) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(String squadra) {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(String squadra) {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }

    public List<String> getTitoliPartiteVinteInCasa(String squadra) {
        TypedQuery<String> query = em.createNamedQuery("PartitaDiCalcio.getTitoliPartiteVinteInCasa", String.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }

    public List<String> getTitoliPartiteVinteInTrasferta(String squadra) {
        TypedQuery<String> query = em.createNamedQuery("PartitaDiCalcio.getTitoliPartiteVinteInTrasferta", String.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }
}
