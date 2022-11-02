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

public class MascotaServiceImplTest {
    @Mock
    private MascotaRepository mascotaRepository;

   @InjectMocks
   private MascotaServiceImpl mascotaServiceImpl;
 
  private Mascota mascota;

  @BeforeEach
  void setUp(){

    /*MockitoAnnotations.initMocks(this); */
    MockitoAnnotations.openMocks(this);

    mascota = new Mascota();
    mascota.setId(new Long(12));
    mascota.setNombre("Bulbasaur");
    mascota.setEspecie(new String());
    mascota.setRaza(new String());
    mascota.setEdad(10);
    mascota.setEstatura(110);
    mascota.setSexo("Macho");
    mascota.setColor("Marron");
    mascota.setPeso(50);

  }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {
        when(mascotaRepository.findAll()).thenReturn(Arrays.asList(mascota));
        assertNotNull(mascotaServiceImpl.findAll());

    }

    @Test
    void testFindAll2() {

    }

    @Test
    void testFindOne() {
        when(mascotaRepository.findAll()).thenReturn(Arrays.asList(mascota));
        Assertions.assertNotEquals(mascotaServiceImpl.findOne(12L), mascota);

    }

    @Test
    void testSave() {

    }
}
