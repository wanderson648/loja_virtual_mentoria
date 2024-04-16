package jdev.mentoria.lojavirtual.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", initialValue = 1, allocationSize = 1)
public class CupomDesconto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
    private Long id;

    private String codDesconto;

    private BigDecimal valorRealDesc;

    private BigDecimal valorPercentDesc;

    @Temporal(TemporalType.DATE)
    private Date dataValidadeCupom;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CupomDesconto that = (CupomDesconto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
