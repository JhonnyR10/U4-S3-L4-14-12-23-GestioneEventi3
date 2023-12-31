package GiovanniLongo.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "partitaDiCalcio")
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraDiCasa = :squadra AND p.squadraVincente = :squadra")
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraOspite = :squadra AND p.squadraVincente = :squadra")
@NamedQuery(name = "PartitaDiCalcio.getTitoliPartiteVinteInCasa", query = "SELECT p.titolo FROM PartitaDiCalcio p WHERE p.squadraDiCasa = :squadra AND p.squadraVincente = :squadra")
@NamedQuery(name = "PartitaDiCalcio.getTitoliPartiteVinteInTrasferta", query = "SELECT p.titolo FROM PartitaDiCalcio p WHERE p.squadraOspite = :squadra AND p.squadraVincente = :squadra")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio() {
    }

    // Costruttore senza squadraVincente (considera pareggio)
    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, Location location,
                           String squadraDiCasa, String squadraOspite,
                           int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, eventType, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = ""; // Considera pareggio
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    // Costruttore con squadraVincente (non pareggio)
    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, Location location,
                           String squadraDiCasa, String squadraOspite, String squadraVincente,
                           int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, eventType, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}';
    }
}
