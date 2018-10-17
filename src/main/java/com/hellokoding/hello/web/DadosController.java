package com.hellokoding.hello.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Controller
public class DadosController {
    @RequestMapping(value = "/dados", method = RequestMethod.GET)
    public String hello(Model model) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Cliente c = new Cliente();

        c.setIdade(15);
        c.setEndereco("Endereço do cliente");
        c.setCampos(Arrays.asList("a", "b"));
        c.setNome("Fulano");

        Formulario f = new Formulario();
        f.setJson(mapper.writeValueAsString(c));

        model.addAttribute("formulario", f);
        model.addAttribute("cliente", mapper.writeValueAsString(c));
        return "dados";
    }

    @RequestMapping(value = "/confirmacao", method = RequestMethod.POST)
    public String confirmacao(Model model){

        return "confirmado";
    }


}
