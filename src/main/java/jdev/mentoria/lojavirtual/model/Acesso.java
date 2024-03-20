package jdev.mentoria.lojavirtual.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "acesso")
@SequenceGenerator(name = "acesso", sequenceName = "seq_acesso", initialValue = 1, allocationSize = 1)
public class Acesso implements GrantedAuthority {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Override
    public String getAuthority() {
        return this.descricao;
    }
}
