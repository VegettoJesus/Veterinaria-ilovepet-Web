package com.veterinaria.proyecto_veterinaria.Entidades;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/*import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;*/

public class RolServiceImplTest {

    @Mock
    private RolRepository rolRepository;


    @InjectMocks
    private RolServiceImpl rolServiceImpl;
    private Rol rol;

    
    @BeforeEach
   void setUp(){
    /*MockitoAnnotations.initMocks(this); */
    MockitoAnnotations.openMocks(this);
    rol = new Rol();
    rol.setId(new Long(10));
    rol.setNombre("Administrador");
  }
    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {
        when(rolRepository.findAll()).thenReturn(Arrays.asList(rol));
        assertNotNull(rolServiceImpl.findAll());

    }

    /*@Test
    void testFindAll2Page() {
        when(rolRepository.findAll()).thenReturn(Arrays.asList(() -> ));
        assertNotNull(rolServiceImpl.findAll());

    }*/

    @Test
    void testFindOne() {

        when(rolRepository.findAll()).thenReturn(Arrays.asList(rol));
       Assertions.assertNotEquals(rolServiceImpl.findOne(44L), rol);

    }

    @Test
    void testSave() {

    }
}
