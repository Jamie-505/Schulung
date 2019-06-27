package com.exxeta.entities;

import com.exxeta.validation.ValidDuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRAINING")
@NamedQueries(value = {
        @NamedQuery(name = "Training.findAll", query = "select t from Training t"),
        @NamedQuery(name = "Training.findAllFetchTeilnehmer", query = "select t from Training t left outer join fetch t.teilnehmer")
})
@NamedEntityGraph(name = "Training.allAttributes", attributeNodes = {
        @NamedAttributeNode("trainer"),
        @NamedAttributeNode("teilnehmer")
})

@ValidDuration
public class Training {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Column(name="BEGINN")
    @NotNull
    private LocalDate beginn;

    @Column(name="ENDE")
    @NotNull
    private LocalDate ende;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="ID_TRAINER")
    private Trainer trainer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name="TRAINING_ZU_TEILNEHMER",
            joinColumns = @JoinColumn(name = "ID_TRAINING"),
            inverseJoinColumns = @JoinColumn(name = "ID_TEILNEHMER"))
    private List<Teilnehmer> teilnehmer;

}
