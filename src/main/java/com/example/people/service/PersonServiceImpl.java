package com.example.people.service;

import com.example.people.dto.req.PersonRequestDTO;
import com.example.people.dto.res.PersonResponseDTO;
import com.example.people.entity.Person;
import com.example.people.repository.PersonRepo;
import com.example.people.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    private final PersonRepo personRepo;

    private final PersonMapper personMapper;


    @Override
    public PersonResponseDTO findById(Long id) {
        Person person = returnPerson(id);

        return personMapper.toPersonDTO(person);

    }

    @Override
    public List<PersonResponseDTO> findAll() {

        return personMapper.toPeopleDTO(personRepo.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);


        return personMapper.toPersonDTO(personRepo.save(person));
    }

    @Override
    public PersonResponseDTO update( Long id, PersonRequestDTO personDTO) {
        Person person = returnPerson(id);

        personMapper.updatePersonData(person, personDTO);

        return personMapper.toPersonDTO(personRepo.save(person));

    }

    @Override
    public String delete(Long id) {
        personRepo.deleteById(id);
        return "Person id:" +id+ "deleted";
    }

    public Person returnPerson(Long id) {
        return personRepo.findById(id).orElseThrow(() -> new RuntimeException("Person wasn't found on database"));
    }


}
