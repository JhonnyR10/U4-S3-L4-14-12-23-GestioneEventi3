package GiovanniLongo.entities;

import javax.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private PartecipazioneStato stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, PartecipazioneStato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public PartecipazioneStato getStato() {
        return stato;
    }

    public void setStato(PartecipazioneStato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
