describe('Probar Login', () => {
  it('Visitar Login Usuario Default', () => {
    
      cy.visit(Cypress.env('base_url') + '/login')
      cy.get('#username') .type('administrador@hotmail.com')
      .should('have.value','administrador@hotmail.com')
      cy.get('#password') .type('123')
      .should('have.value','123')
      cy.get('#login-submit').click()

  })

  it('Cerrar Sesion Usuario Default', () => {
    
    cy.visit(Cypress.env('base_url'+""))
    cy.get('#logout') .click()
    cy.location('pathname').should('eq','/login')
  })
})

describe('Mantener Empleado', () => {
    it('Entrar al Gestionar Rol', () => {
        cy.visit(Cypress.env('base_url'))
        cy.get('#btnRegRol').click()
        cy.location('pathname').should('eq','/GestionRol')
          
    })
    it('Registrar Rol Cajero', () => {
      
      cy.url(Cypress.env('base_url'+'/GestionRol'))
      cy.get('#btnRegistrarRoles').click()
      cy.location('pathname').should('eq','/formularioRol')
      cy.get('#nombre').type('Cajero')
      .should('have.value','Cajero');
      cy.get('#btn-registrar').click()
      cy.location('pathname').should('eq','/GestionRol')  
    })
    it('Modificar Rol Cajero', () => {
      
      cy.url(Cypress.env('base_url'+'/GestionRol'))
      cy.get('#btn-editar-rol').click()
      cy.location('pathname').should('contain','/formularioRol/')
      cy.get('#nombre').clear().type('Medico')
      .should('have.value','Medico');
      cy.get('#btn-registrar').click()
      cy.location('pathname').should('eq','/GestionRol')  
    })
    it('Eliminar Rol Cajero', () => {
      
      cy.url(Cypress.env('base_url'+'/GestionRol'))
      cy.get('#btn-eliminar-rol').click()
      //cy.location('pathname').should('contain','/GestionRol/')
    })
     
    it('Registrar Empleado', () => {
      
      cy.visit(Cypress.env('base_url'))
      cy.get('#btnRegEmpleado').click()
      cy.location('pathname').should('eq','/formularioEmpleado')
      cy.get('#dni').type('73189018')
      cy.get('#nombre').type('Adriana')
      cy.get('#apellido').type('Valverde')
      cy.get('#direccion').type('Av. Los Jardines 123')
      cy.get('#email').type('adriana17@gmail.com')
      cy.get('#celular').type('987654321')
      cy.get('#sexo').select('M')
      cy.get('#fecha_Nacimiento').type('2002-04-12')
      cy.get('#usuario').type('Adri17')
      cy.get('#password').type('123')
      //cy.get('select').find('Cajero')
      cy.get('#btn-registrar').click()
      //cy.location('pathname').should('eq','/gestionAdmin')  
    })

    it('Editar Empleado', () => {
      
      cy.visit(Cypress.env('base_url'))
      cy.get('#btnEditar').click()
      cy.location('pathname').should('eq','/formularioEmpleado')
      cy.get('#dni').type('73189018')
      cy.get('#nombre').type('Adriana')
      cy.get('#apellido').type('Valverde')
      cy.get('#direccion').type('Av. Los Jardines 123')
      cy.get('#email').type('adriana17@gmail.com')
      cy.get('#celular').type('987654321')
      cy.get('#sexo').select('F')
      cy.get('#fecha_Nacimiento').type('2002-04-12')
      cy.get('#usuario').type('Adri17')
      cy.get('#password').type('123')
      //cy.get('select').find('Cajero')
      cy.get('#btn-registrar').click()
      //cy.location('pathname').should('eq','/gestionAdmin')  
    })

    it('Ver Empleado', () => {
      
      cy.visit(Cypress.env('base_url'))
      cy.get('#btn-ver').click()
      cy.location('pathname').should('eq','/detalleEmpleado/1')
      //cy.get('select').find('Cajero')
      cy.get('#btn-registrar').click()
      cy.location('pathname').should('eq','/gestionAdmin')  
    }) 
    
  })

  describe('Mantener Propietario', () => {
    it('Registrar Propietario', () => {
      cy.visit(Cypress.env('base_url'))
      cy.get('#agProp').click()
      cy.location('pathname').should('eq','/gestionPropietario')
      cy.get('#btnRegPropietario').click()
      cy.location('pathname').should('eq','/formularioPropietario')
      cy.get('#nomPropietario').type('Rodrigo Jorge Alonso Gomez Velasquez')
      cy.get('#direccion').type('Av Villamaria del Triunfo')
      cy.get('#correo').type('rodrigoval@gmail.com')
      cy.get('#celPropietario').type('954254114')
      //cy.get('select').find('Cajero')
      cy.get('#btn-Propietario').click()
      //cy.location('pathname').should('eq','/gestionAdmin')  
          
    })

    it('Editar Propietario', () => {
      cy.visit(Cypress.env('base_url'))
      cy.get('#agProp').click()
      cy.location('pathname').should('eq','/gestionPropietario')
      cy.get('#btnRegPropietario').click()
      cy.location('pathname').should('eq','/formularioPropietario')
      cy.get('#nomPropietario').type('Rodrigo Jorge Alonso Gomez Velasquez')
      cy.get('#direccion').type('Av Villamaria del Triunfo')
      cy.get('#correo').type('rodrigoval@gmail.com')
      cy.get('#celPropietario').type('954254114')
      //cy.get('select').find('Cajero')
      cy.get('#btn-Propietario').click()
      //cy.location('pathname').should('eq','/gestionAdmin')  
          
    })
    
  })

  describe('Mantener Mascota', () => {
    it('Registrar Mascota', () => {
      cy.visit(Cypress.env('base_url'))
      cy.get('#agMasc').click()
      cy.location('pathname').should('eq','/gestionMascota')
      cy.get('#btnRegMascota').click()
      cy.location('pathname').should('eq','/formularioMascota')
      cy.get('#nombre').type('Firulais')
      cy.get('#edad').type('9')
      cy.get('#Sexo').select('M')
      cy.get('#especie').select('Perro')
      cy.get('#raza').type('Pitbull')
      cy.get('#estatura').clear()
      cy.get('#estatura').type('50')
      cy.get('#peso').clear()
      cy.get('#peso').type('35')
      cy.get('#color').type('negro')
      cy.get('#fecha_Registro').type('2022-10-03')
      //cy.get('#propietario').select()
      cy.get('#btn-registrar').click()
      cy.location('pathname').should('eq','/gestionMascota')  
          
    })
    
  })
