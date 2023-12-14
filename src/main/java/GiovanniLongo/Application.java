package GiovanniLongo;

import GiovanniLongo.DAO.EventoDAO;
import GiovanniLongo.DAO.LocationDAO;
import GiovanniLongo.DAO.PartecipazioneDAO;
import GiovanniLongo.DAO.PersonaDAO;
import GiovanniLongo.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        PersonaDAO ped = new PersonaDAO(em);
        LocationDAO ld = new LocationDAO(em);

        Location location1 = new Location("Miramare", "Soverato");
        Location location2 = new Location("Mamas", "Soverato");

        //       ld.save(location1);
//        ld.save(location2);

        Persona persona1 = new Persona("Giovanni", "Longo", "email@email.it", LocalDate.of(1992, 8, 10), PersonaSesso.M);
        Persona persona2 = new Persona("Francesco", "Leo", "email2@email.it", LocalDate.of(1993, 7, 23), PersonaSesso.M);
//        ped.save(persona1);
//        ped.save(persona2);
        Evento evento1 = new Evento("Evento 1", LocalDate.of(2023, 12, 31), "Concerto di capodanno", EventType.PUBBLICO, 1000, location1);
        Evento evento2 = new Evento("Evento 2", LocalDate.of(2023, 12, 25), "Concerto di natale", EventType.PUBBLICO, 1000, location1);
        Evento evento3 = new Evento("Evento 3", LocalDate.of(2023, 12, 31), "Concerto di capodanno", EventType.PRIVATO, 1000, location1);

//        ed.save(evento1);
        //   ed.save(evento2);
        //ed.save(evento3);
        Concerto concerto1 = new Concerto("Concerto1", LocalDate.of(2023, 12, 31), "Concerto di capodanno", EventType.PRIVATO, 1000, location1, GenereMusica.POP, true);
//        ed.save(concerto1);
//        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, PartecipazioneStato.CONFERMATA);
//        pd.save(partecipazione1);


//        Scanner input = new Scanner(System.in);
//        System.out.println("Inserire l'id dell'evento desiderato");
//        long id = Long.parseLong(input.nextLine());
//        Evento eventoCercato = ed.findById(id);
//        if (eventoCercato != null) {
//            System.out.println(eventoCercato);
//        } else {
//            System.out.println("Evento con id " + id + " non trovato");
//        }
//
//        System.out.println("Inserire l'id dell'evento che si desidera eliminare");
//        long idDelete = Long.parseLong(input.nextLine());
//        ed.findByIdAndDelete(idDelete);
        ed.getConcertiInStreaming(true).forEach(System.out::println);
        ed.getConcertiPerGenere(GenereMusica.POP).forEach(System.out::println);
        em.close();
        System.out.println("ciao");
    }
}