package pl.sda.hibernate;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

//    @Column(nullable = false)
    private int rokRozpoczeciaStudiow;

//    mnie chcemy żeby to była kolumna
    @Formula("(SELECT AVG(o.wartosc) FROM Ocena o WHERE o.uczen_id=id)")
    private Double sredniaOcen;

    @OneToMany(mappedBy = "uczen")
    private Set<Ocena> oceny;
}
