package com.example.microservicio_cliente_contacto_05.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservicio_cliente_contacto_05.model.Persona;

@RestController
public class PersonasController {
    @Autowired
    RestTemplate templete;

    String url = "http://localhost:8080";

    @GetMapping(value = "/personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> altaPersona(@PathVariable("nombre") String nombre,
    @PathVariable("email") String email, @PathVariable("edad") int edad){

        Persona persona = new Persona (nombre, email, edad);

        //templete.postForLocation(url,"/persona"+persona);
        templete.postForLocation(url + "/persona", persona);

        Persona[] personas = templete.getForObject(url + "/contactos", Persona[].class);
        return Arrays.asList(personas) ;
    }

    @GetMapping(value= "/personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> buscarEdades (@PathVariable("edad1") int edad1, @PathVariable("edad2")int edad2){
        Persona[] personas = templete.getForObject(url+"contactos", Persona[].class);
        return Arrays.stream(personas)
             .filter(p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
             .collect(Collectors.toList());
        
       // Arrays.stream(personas).filter(p->p.getEdad()>-edad1&&p.getEdad()<-edad2).collect(Collectors.toList());
    }
}
