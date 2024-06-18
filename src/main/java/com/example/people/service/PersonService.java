package com.example.people.service;


import com.example.people.dto.req.PersonRequestDTO;
import com.example.people.dto.res.PersonResponseDTO;

import java.util.List;


public interface PersonService {

    PersonResponseDTO findById (Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO register(PersonRequestDTO personDTO);

    PersonResponseDTO update( Long id, PersonRequestDTO personDTO);

    String delete (Long id);

}
