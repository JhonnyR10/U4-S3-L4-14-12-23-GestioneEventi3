package GiovanniLongo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "garaDiAtletica")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(
            name = "partecipazione_gara_atletica",
            joinColumns = @JoinColumn(name = "gara_atletica_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    // Costruttore senza atleti e vincitore specificati
    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, Location location) {
        super(titolo, dataEvento, descrizione, eventType, numeroMassimoPartecipanti, location);
    }

    // Costruttore con atleti specificati
    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, Location location, List<Persona> atleti) {
        super(titolo, dataEvento, descrizione, eventType, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
    }

    // Costruttore con atleti e vincitore specificati
    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, Location location, List<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, eventType, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getAtleti() {
        return atleti;
    }


    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "vincitore=" + vincitore +
                '}';
    }
}
