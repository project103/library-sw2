package com.library_management_system.library.service;
import com.library_management_system.library.entity.User;
import com.library_management_system.library.entity.Visa;
import com.library_management_system.library.repository.VisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VisaService {
    @Autowired
    private VisaRepository Repository;

    public Visa saveVisa(Visa visa) {
        return Repository.save(visa);
    }

    public List<Visa> getVisas(User userId) {
        return Repository.findAllByuserID(userId);
    }

    public Visa getVisaById(int id) {
        return Repository.findById(id).orElse(null);
    }



    public String DeleteVisaById(int id) {
        Repository.deleteById(id);
        return "deleted successfully !!" + id;
    }

    public Visa UpdateUser(Visa visa) {
        Visa existingVisa = Repository.findById(visa.getId()).orElse(null);
        existingVisa.setId(visa.getId());
        existingVisa.setUserID(visa.getUserID());
        existingVisa.setEndDate(visa.getEndDate());
        existingVisa.setCvv(visa.getCvv());
        existingVisa.setCreditCardNo(visa.getCreditCardNo());
        return Repository.save(existingVisa);

    }
}
