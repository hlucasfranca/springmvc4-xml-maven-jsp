package com.hellokoding.hello.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Controller
public class ConfirmacaoController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/confirmacao", method = RequestMethod.POST)
    public String dados(@ModelAttribute("formulario") Formulario formulario,
                        BindingResult result,
                        ModelMap model) {

        final String s = new String(Base64.getDecoder().decode(formulario.getObjetoUm().getBytes()));

        try {
            final Cliente cliente = mapper.readValue(s, Cliente.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "confirmacao";
    }

}
