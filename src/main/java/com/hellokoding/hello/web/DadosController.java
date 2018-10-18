package com.hellokoding.hello.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

@Controller
public class DadosController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/dados", method = RequestMethod.GET)
    public String dados(Model model) throws JsonProcessingException {

        Formulario f = new Formulario();
        f.setObjetoUm(popularHidden());
        f.setObjetoDois(popularHidden());
        f.setObjetoTres(popularHidden());
        f.setObjetoQuatro(popularHidden());

        model.addAttribute("formulario", f);
        return "dados";
    }

    private String popularHidden() throws JsonProcessingException {
        Cliente c = new Cliente();

        c.setIdade(15);
        c.setEndereco("Endereço do cliente");
        c.setCampos(Arrays.asList("a", "b"));
        c.setNome("Fulano");


        final String s = mapper.writeValueAsString(c);
        return new String(Base64.getEncoder().encode(s.getBytes()));
    }

}
