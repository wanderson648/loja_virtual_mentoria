package jdev.mentoria.lojavirtual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", initialValue = 1, allocationSize = 1)
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();

}
