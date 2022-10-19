package com.veterinaria.proyecto_veterinaria;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.veterinaria.proyecto_veterinaria.Entidad_usuario.Empleado_Login;
import com.veterinaria.proyecto_veterinaria.Entidad_usuario.Empleado_Repositoriy;
import com.veterinaria.proyecto_veterinaria.Entidades.Categoria;
import com.veterinaria.proyecto_veterinaria.Entidades.CategoriaRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Producto;
import com.veterinaria.proyecto_veterinaria.Entidades.ProductoRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Rol;
import com.veterinaria.proyecto_veterinaria.Entidades.RolRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProyectoVeterinariaApplicationTests {

	@Autowired
	private Empleado_Repositoriy empleado_Repositoriy;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProductoRepository productoRepository;


	/* TEST ROLES */

	@Test
	@Rollback(false)
	public void testGuardarRol(){
		Rol rol = new Rol("Usuario");
		Rol rolGuardar = rolRepository.save(rol);

		assertNotNull(rolGuardar);
	}

	@Test
	public void buscarNombreRolExistente(){
		String nombre="Usuario";
		Rol b = rolRepository.findByNombre(nombre);

		assertThat(b.getNombre()).isEqualTo(nombre);
	}

	@Test
	public void testVerificarListaRoles(){
		List<Rol> roles = (List<Rol>) rolRepository.findAll();
		assertThat(roles).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testModificarRol(){
		String buscador = "Usuario";
		Rol rol = new Rol("USER");
		rol.setId(47L);
		rolRepository.save(rol);
		Rol rolModificado = rolRepository.findByNombre(buscador);
		assertThat(rolModificado.getNombre()).isEqualTo(buscador);
	}

	@Test
	@Rollback(false)
	public void testEliminarRol(){
		Long id = 47L;

		boolean existeId = rolRepository.findById(id).isPresent();
		rolRepository.deleteById(id);
		boolean noExisteId = rolRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/* TEST EMPLEADOS */


	@Test
	@Rollback(false)
	public void testGuardarUsuario() throws ParseException{

		String dateInString = "11/11/2000";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInString);
		Empleado_Login usuario = new Empleado_Login(70948451L, "Christian", "Leon",date, 992238230, "jesusleonangulo@hotmail.com", "Av. La paz 769, San Miguel", "Christian14", "123", "M", Arrays.asList(new Rol("Medico")));
		Empleado_Login empleadoGuardar = empleado_Repositoriy.save(usuario);

		assertNotNull(empleadoGuardar);
	}

	@Test
	public void buscarEmailExistente(){
		String email="administrador@hotmail.com";
		Empleado_Login b = empleado_Repositoriy.findByEmail(email);

		assertThat(b.getEmail()).isEqualTo(email);
	}

	@Test
	public void testVerificarListaEmpleado(){
		List<Empleado_Login> usuarios = (List<Empleado_Login>) empleado_Repositoriy.findAll();
		assertThat(usuarios).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testEliminarEmpleado(){
		Long id = 6L;

		boolean existeId = empleado_Repositoriy.findById(id).isPresent();
		empleado_Repositoriy.deleteById(id);
		boolean noExisteId = empleado_Repositoriy.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/* TEST CATEGORIA */
	@Test
	@Rollback(false)
	public void testGuardarCategoria(){
		Categoria categoria = new Categoria("Juguetes");
		Categoria categoriaGuardar = categoriaRepository.save(categoria);

		assertNotNull(categoriaGuardar);
	}

	@Test
	public void buscarNombreCategoriaExistente(){
		String nombre="Juguetes";
		Categoria b = categoriaRepository.findByNombre(nombre);

		assertThat(b.getNombre()).isEqualTo(nombre);
	}

	@Test
	public void testVerificarListaCategorias(){
		List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
		assertThat(categorias).size().isGreaterThan(0);
	}
/* 
	@Test
	@Rollback(false)
	public void testModificarCategoria(){
		String buscador = "Juguetes";
		Categoria categoria = new Categoria("Limpieza");
		categoria.setId(2L);
		categoriaRepository.save(categoria);
		Categoria categoriaModificado = categoriaRepository.findByNombre(buscador);
		assertThat(categoriaModificado.getNombre()).isEqualTo(buscador);
	}
*/
	@Test
	@Rollback(false)
	public void testEliminarCategoria(){
		Long id = 1L;

		boolean existeId = categoriaRepository.findById(id).isPresent();
		categoriaRepository.deleteById(id);
		boolean noExisteId = categoriaRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	
}
