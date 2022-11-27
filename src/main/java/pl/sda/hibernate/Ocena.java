package pl.sda.hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class Ocena {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

//         @Column(nullable = false)
        private double wartosc;
//        INSERT INTO OCENA VALUES(1, 4.5 now())
    @CreationTimestamp // odpowiednik SQL funkcja: now()

        private LocalDateTime dataCzasDodania;



    @Enumerated(value = EnumType.STRING)
    private Przedmiot przedmiot;



    //Relacje
    @ManyToOne
    private Student uczen; //kolumna student_id
}
