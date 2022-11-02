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
/*import org.springframework.data.domain.Pageable;*/

public class PropietarioServiceImplTest {
  /*Proviene del PropietarioServiceImpl porque usa el repositorio */
  @Mock
  private PropietarioRepository propietarioRepository;

  @InjectMocks
  private PropietarioServiceImpl propietarioServiceImpl;

  private Propietario propietario;

  @BeforeEach
  void setUp(){

    /*MockitoAnnotations.initMocks(this); */
    MockitoAnnotations.openMocks(this);

    propietario = new Propietario();
    propietario.setDireccion(new String());
    propietario.setCorreo("nuevocorreo@gmail.com");
    propietario.setId(new Long(11));
  }

  @Test
  void findAll(){
    /*Retorna lista de objetos tipo Propietario */
    when(propietarioRepository.findAll()).thenReturn(Arrays.asList(propietario));
    assertNotNull(propietarioServiceImpl.findAll());
    

  }

   @Test
    void testFindOne() {

        when(propietarioRepository.findAll()).thenReturn(Arrays.asList(propietario));
       Assertions.assertNotEquals(propietarioServiceImpl.findOne(11L), propietario);

    }

  
}