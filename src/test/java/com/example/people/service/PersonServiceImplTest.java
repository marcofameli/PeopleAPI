package com.example.people.service;

import com.example.people.dto.req.PersonRequestDTO;
import com.example.people.dto.res.PersonResponseDTO;
import com.example.people.entity.Person;
import com.example.people.repository.PersonRepo;
import com.example.people.util.PersonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonMapper personMapper;

    @Mock
    private PersonRepo personRepo;

    @Test
    @DisplayName("Deve retornar uma lista com um usuario")
    public void ShouldReturnAListWithOneUser(){
        Person person = new Person("CPF", 18, "Nome");
        PersonResponseDTO personResponseDTO = new PersonResponseDTO(person);
        Mockito.when(personRepo.findAll()).thenReturn(Collections.singletonList(person));
        Mockito.when(personMapper.toPeopleDTO(Collections.singletonList(person))).thenReturn(Collections.singletonList(personResponseDTO));
        List<PersonResponseDTO> todos = personService.findAll();

        Assertions.assertEquals(1, todos.size());


    }
   @Test
   @DisplayName("Lança uma exceção quando o usuário não for encontrado")
    public void ShouldThrowExceptionWhenUserNotFound(){
        Mockito.when(personRepo.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, () -> personService.findById(1L));
    }

}
