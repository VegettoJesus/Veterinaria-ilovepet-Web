package com.veterinaria.proyecto_veterinaria;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
import com.veterinaria.proyecto_veterinaria.Entidades.Citas;
import com.veterinaria.proyecto_veterinaria.Entidades.CitasRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Mascota;
import com.veterinaria.proyecto_veterinaria.Entidades.MascotaRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Producto;
import com.veterinaria.proyecto_veterinaria.Entidades.ProductoRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Propietario;
import com.veterinaria.proyecto_veterinaria.Entidades.PropietarioRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Rol;
import com.veterinaria.proyecto_veterinaria.Entidades.RolRepository;
import com.veterinaria.proyecto_veterinaria.Entidades.Servicio;
import com.veterinaria.proyecto_veterinaria.Entidades.ServicioRepository;


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

	@Autowired
	private PropietarioRepository propietarioRepository;

	@Autowired
	private MascotaRepository mascotaRepository;

	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private CitasRepository citasRepository;


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
		String nombre="USER";
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
		String buscador = "USER";
		Rol rol = new Rol("Administrador");
		rol.setId(47L);
		rolRepository.save(rol);
		Rol rolModificado = rolRepository.findByNombre(buscador);
		assertThat(rolModificado.getNombre()).isEqualTo(buscador);
	}

	@Test
	@Rollback(false)
	public void testEliminarRol(){
		Long id = 5L;

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
	public void testModificarEmpleado() throws ParseException{
		String buscador = "jesusleonangulo@hotmail.com";
		String dateInString = "20/12/2000";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInString);
		Empleado_Login empleado_Login = new Empleado_Login(70948451L, "Christian Jesus", "Leon Angulo",date, 992238230, "jesusleonangulo@hotmail.com", "Av. La paz 769, San Miguel", "Christian446", "123", "M", Arrays.asList(new Rol("Medico")));
		empleado_Login.setId(28L);
		empleado_Repositoriy.save(empleado_Login);
		Empleado_Login empleadoModificado = empleado_Repositoriy.findByEmail(buscador);
		assertThat(empleadoModificado.getEmail()).isEqualTo(buscador);
	}

	@Test
	@Rollback(false)
	public void testEliminarEmpleado(){
		Long id = 28L;

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
		String nombre="Comida";
		Categoria b = categoriaRepository.findByNombre(nombre);

		assertThat(b.getNombre()).isEqualTo(nombre);
	}

	@Test
	public void testVerificarListaCategorias(){
		List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
		assertThat(categorias).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testModificarCategoria(){
		String nombreCategoria = "Higiene";
		Categoria categoria = new Categoria(nombreCategoria);
		categoria.setId(13L);
		categoriaRepository.save(categoria);
		Categoria categoriaModificado = categoriaRepository.findByNombre(nombreCategoria);
		assertThat(categoriaModificado.getNombre()).isEqualTo(nombreCategoria);
	}
 
	@Test
	@Rollback(false)
	public void testEliminarCategoria(){
		Long id = 12L;

		boolean existeId = categoriaRepository.findById(id).isPresent();
		categoriaRepository.deleteById(id);
		boolean noExisteId = categoriaRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/* TEST PRODUCTO */

	@Test
	public void buscarNombreProductoExistente(){
		String nombre="Comida para perro";
		Producto b = productoRepository.findByNombre(nombre);
		assertThat(b.getNombre()).isEqualTo(nombre);
	}
	@Test
	public void testVerificarListaProducto(){
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		assertThat(productos).size().isGreaterThan(0);
	}
	@Test
	@Rollback(false)
	public void testEliminarProducto(){
		Long id = 5L;

		boolean existeId = productoRepository.findById(id).isPresent();
		productoRepository.deleteById(id);
		boolean noExisteId = productoRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/* TEST PROPIETARIO */
	@Test
	@Rollback(false)
	public void testGuardarPropietario(){
		Propietario propietario = new Propietario("Eduardo Raul Cueva Leon", "Av. La paz 852, San Miguel", 99852150L, "Efectivo", "eduardo2013@gmail.com");
		Propietario propietarioGuardar = propietarioRepository.save(propietario);

		assertNotNull(propietarioGuardar);
	}
	@Test
	public void buscarNombrePropietarioExistente(){
		String nombre="Eduardo Raul Cueva Leon";
		Propietario propietario = propietarioRepository.findByNombre(nombre);
		assertThat(propietario.getNombre()).isEqualTo(nombre);
	}
	@Test
	public void testVerificarListaPropietario(){
		List<Propietario> propietarios = (List<Propietario>) propietarioRepository.findAll();
		assertThat(propietarios).size().isGreaterThan(0);
	}
	@Test
	@Rollback(false)
	public void testEliminarPropietario(){
		Long id = 28L;

		boolean existeId = propietarioRepository.findById(id).isPresent();
		propietarioRepository.deleteById(id);
		boolean noExisteId = propietarioRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/*TEST MASCOTA*/

	@Test
	public void buscarNombreMascotaExistente(){
		String nombre="Mini Mini";
		Mascota mascota = mascotaRepository.findByNombre(nombre);
		assertThat(mascota.getNombre()).isEqualTo(nombre);
	}
	@Test
	public void testVerificarListaMascota(){
		List<Mascota> mascotas = (List<Mascota>) mascotaRepository.findAll();
		assertThat(mascotas).size().isGreaterThan(0);
	}
	@Test
	@Rollback(false)
	public void testEliminarMascota(){
		Long id = 12L;

		boolean existeId = mascotaRepository.findById(id).isPresent();
		mascotaRepository.deleteById(id);
		boolean noExisteId = mascotaRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/*TEST SERVICIO*/
	@Test
	public void testVerificarListaServicio(){
		List<Servicio> servicios = (List<Servicio>) servicioRepository.findAll();
		assertThat(servicios).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testEliminarServicio(){
		Long id = 22L;

		boolean existeId = servicioRepository.findById(id).isPresent();
		servicioRepository.deleteById(id);
		boolean noExisteId = servicioRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}

	/*TEST CITA*/
	@Test
	public void testVerificarListaCitas(){
		List<Citas> citas = (List<Citas>) citasRepository.findAll();
		assertThat(citas).size().isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	public void testEliminarCitas(){
		Long id = 15L;

		boolean existeId = citasRepository.findById(id).isPresent();
		citasRepository.deleteById(id);
		boolean noExisteId = citasRepository.findById(id).isPresent();

		assertTrue(existeId);
		assertFalse(noExisteId);
	}
}
