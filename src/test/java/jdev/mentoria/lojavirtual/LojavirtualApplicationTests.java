package jdev.mentoria.lojavirtual;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LojavirtualApplication.class)
public class LojavirtualApplicationTests {

    @Autowired
    private AcessoController acessoController;

    @Autowired
    private AcessoRepository acessoRepository;

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void testRestApiCadastroAcesso() throws Exception {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        MockMvc mockMvc = builder.build();

        Acesso acesso = new Acesso();

        acesso.setDescricao("ROLE_COMPRADOR");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions retornoApi = mockMvc
                .perform(MockMvcRequestBuilders.post("/salvarAcesso")
                        .content(objectMapper.writeValueAsString(acesso))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON));

        Acesso objetoRetorno = objectMapper
                .readValue(retornoApi.andReturn().getResponse().getContentAsString(),
                        Acesso.class);

        assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());
    }

    @Test
    public void testCadastraAcesso() {
        Acesso acesso = new Acesso();

        acesso.setDescricao("ROLE_ADMIN");

        assertNull(acesso.getId());

        acesso = acessoController.salvarAcesso(acesso).getBody();

        assert acesso != null;
        assertTrue(acesso.getId() > 0);
        assertEquals("ROLE_ADMIN", acesso.getDescricao());
    }

}
