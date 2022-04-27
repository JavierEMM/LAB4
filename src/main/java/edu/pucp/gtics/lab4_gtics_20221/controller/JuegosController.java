package edu.pucp.gtics.lab4_gtics_20221.controller;

import edu.pucp.gtics.lab4_gtics_20221.entity.*;
import edu.pucp.gtics.lab4_gtics_20221.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/juegos")
public class JuegosController {

    @Autowired
    JuegosRepository juegosRepository;

    @Autowired
    PlataformasRepository plataformasRepository;

    @Autowired
    DistribuidorasRepository distribuidorasRepository;

    @Autowired
    GenerosRepository generosRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"", "/","/lista"})
    public String listaJuegos (Model model){
        model.addAttribute("listaJuegos", juegosRepository.findAll());
        return "juegos/lista";
    }

    public String vistaJuegos ( ){
        return "juegos/vista";
    }

    @GetMapping("/nuevo")
    public String nuevoJuegos(@ModelAttribute("juegos") Juegos juegos,Model model ){
        model.addAttribute("listaGeneros",generosRepository.findAll());
        model.addAttribute("listaPlataforma",plataformasRepository.findAll());
        model.addAttribute("listaDistribuidora",distribuidorasRepository.findAll());

        return "juegos/editarFrm";
    }
    @GetMapping("/editar")
    public String editarJuegos(@ModelAttribute("juegos") Juegos juegos,Model model,@RequestParam("id") Integer id){
        Optional<Juegos> optionalJuegos = juegosRepository.findById(id);
        if (optionalJuegos.isPresent()){
            juegos=optionalJuegos.get();
            model.addAttribute("juegos",juegos);
            model.addAttribute("listaGeneros",generosRepository.findAll());
            model.addAttribute("listaPlataforma",plataformasRepository.findAll());
            model.addAttribute("listaDistribuidora",distribuidorasRepository.findAll());
            return "juegos/editarFrm";
        }else{
            return "redirect:juegos";
        }



    }

    public String guardarJuegos(@ModelAttribute("juegos")@Valid Juegos juegos ){

        return "redirect:/";
    }

    @GetMapping("/juegos/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id){
        Optional<Juegos> opt = juegosRepository.findById(id);
        if (opt.isPresent()) {
            juegosRepository.deleteById(id);
        }
        return "redirect:/juegos/lista";
    }

}
