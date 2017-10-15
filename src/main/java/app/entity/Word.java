package app.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table (name="words")
public class Word implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String word;
    @Column
    private String translation;
}
