package org.example.employer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "e_employer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

    @Id
    @Column(name ="e_employer_id")
    private long id;

    @Column(name = "e_employer_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "e_poste_id")
    @Column(name = "e_employer_poste_id")
    private Poste poste;

    @Column(name = "e_employer_departement_id")
    private int departement;


}
