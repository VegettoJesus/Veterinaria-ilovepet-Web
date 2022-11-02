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

public class ProductoServiceImplTest {
     /*Proviene del ProductoserviceImpl porque usa el repositorio */
  @Mock
  private ProductoRepository productoRepository;

   @InjectMocks
   private ProductoServiceImpl productoServiceImpl;
 
  private Producto producto;

  @BeforeEach
  void setUp(){

    /*MockitoAnnotations.initMocks(this); */
    MockitoAnnotations.openMocks(this);

    producto = new Producto();
    producto.setId(new Long(40));
    producto.setNombre("Manuel");
    producto.setDescripcion("BaÃ±o Burbujas");
    producto.setPrecio(200);
  }
    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));
        assertNotNull(productoServiceImpl.findAll());

    }

    @Test
    void testFindAll2() {

    }

    @Test
    void testFindOne() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));
        Assertions.assertNotEquals(productoServiceImpl.findOne(40L), producto);
    }

    @Test
    void testSave() {

    }
}
