package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Visa;
import com.library_management_system.library.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Visa")
public class VisaController {
    @Autowired
    private VisaService Service;

    @PostMapping("/SaveVisa")
    public Visa saveVisa(@RequestBody Visa visa) {
        return Service.saveVisa(visa);
    }

    @GetMapping("/GetVisas/{UserId}")
    public List<Visa> getVisas(@PathVariable int UserId) {
        return Service.getVisas(UserId);
    }

    @GetMapping("/getVisa/{Id}")
    public Visa getVisaById(@PathVariable int Id) {
        return Service.getVisaById(Id);
    }

    @DeleteMapping("/DeleteVisa/{Id}")
    public String DeleteVisaById(@PathVariable int Id) {
        Service.DeleteVisaById(Id);
        return "deleted successfully !!" + Id;
    }

    @PutMapping("/UpdateVisa")
    public Visa UpdateUser(@RequestBody Visa visa) {
        return Service.UpdateUser(visa);

    }
}
