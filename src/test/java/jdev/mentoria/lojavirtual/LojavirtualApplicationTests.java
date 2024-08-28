package jdev.mentoria.lojavirtual;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import jdev.mentoria.lojavirtual.service.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojavirtualApplication.class)
class LojavirtualApplicationTests {


    @Autowired
    private AcessoService acessoService;

    @Autowired
    private AcessoRepository acessoRepository;

	@Test
	void testCadastraAcesso() {
        Acesso acesso = new Acesso();
//
//        Mockito.when(acessoRepository.save(ArgumentMatchers.any()))
//                .thenReturn(acesso);
        acesso.setDescricao("ROLE_ADMIN");

        acessoService.save(acesso);
    }

}
