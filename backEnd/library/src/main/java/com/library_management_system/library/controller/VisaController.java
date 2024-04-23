package com.library_management_system.library.controller;

import com.library_management_system.library.entity.User;
import com.library_management_system.library.entity.Visa;
import com.library_management_system.library.repository.userRepository;
import com.library_management_system.library.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Visa")
public class VisaController {
    @Autowired
    private VisaService Service;
    @Autowired
    private userRepository repository;

    @PostMapping("/SaveVisa")
    public Visa saveVisa(@RequestBody Map<String ,String> NewVisa) {
        Visa visa = new Visa();
        visa.setCvv(NewVisa.get("cvv"));
        visa.setCreditCardNo(NewVisa.get("cardNo"));
        visa.setEndDate(NewVisa.get("EndDate"));
        visa.setUserName(NewVisa.get("name"));
        User user = repository.getUserById(Integer.parseInt(NewVisa.get("userID")));
        visa.setUserID(user);
        return Service.saveVisa(visa);
    }


    @GetMapping("/GetVisas/{UserId}")
    public List<Visa> getVisas(@PathVariable int UserId) {
        User user = repository.getUserById(UserId);
        return Service.getVisas(user);
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
