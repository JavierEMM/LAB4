package edu.pucp.gtics.lab4_gtics_20221.controller;

import edu.pucp.gtics.lab4_gtics_20221.entity.Distribuidoras;
import edu.pucp.gtics.lab4_gtics_20221.entity.Paises;
import edu.pucp.gtics.lab4_gtics_20221.repository.DistribuidorasRepository;
import edu.pucp.gtics.lab4_gtics_20221.repository.PaisesRepository;
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
@RequestMapping("/distribuidoras")
public class DistribuidorasController {

    @Autowired
    DistribuidorasRepository distribuidorasRepository;

    @Autowired
    PaisesRepository paisesRepository;

    @GetMapping(value = {"/lista"})
    public String listaDistribuidoras (Model model ){
        model.addAttribute("listaDistribuidoras",distribuidorasRepository.findAll());
        return "distribuidoras/lista";

    }

    @GetMapping("/editar")
    public String editarDistribuidoras(@ModelAttribute("distribuidora") Distribuidoras distribuidora, Model model, @RequestParam("id") int id){
        Optional<Distribuidoras> optDistribuidora = distribuidorasRepository.findById(id);
        if(optDistribuidora.isPresent()){
            distribuidora = optDistribuidora.get();
            model.addAttribute("distribuidora",distribuidora);
            model.addAttribute("listaDistribuidoras",distribuidorasRepository.findAll());
            model.addAttribute("listaPaises",paisesRepository.findAll());
            return "distribuidoras/editarFrm";
        }else {
            return "redirect:/distribuidoras/lista";
        }
    }

    @GetMapping("/nuevo")
    public String nuevaDistribuidora(@ModelAttribute("distribuidora") Distribuidoras distribuidora, Model model){
        model.addAttribute("listaDistribuidoras",distribuidorasRepository.findAll());
        model.addAttribute("listaPaises",paisesRepository.findAll());
        return "distribuidoras/editarFrm";
    }


    public String guardarDistribuidora( ){
        return "redirect:/distribuidoras/lista";
    }

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id){
        Optional<Distribuidoras> opt = distribuidorasRepository.findById(id);
        if (opt.isPresent()) {
            distribuidorasRepository.deleteById(id);
        }
        return "redirect:/distribuidoras/lista";
    }

}
