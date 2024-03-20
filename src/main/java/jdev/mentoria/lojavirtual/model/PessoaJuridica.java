package jdev.mentoria.lojavirtual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cnpj;
    private String incricaoEstadual;
    private String incricaoMunicipal;
    private String nomeFantasia;
    private String razaoSocial;
    private String categoria;

}
