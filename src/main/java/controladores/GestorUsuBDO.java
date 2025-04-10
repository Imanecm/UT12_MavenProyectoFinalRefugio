/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controladores;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class GestorUsuBDO {
    Usuario usuario = new Usuario();
    
    String nombreBDO = "GestorUsuBDO.odb";
    String rutaBase = "dbUsuarios/";
    String rutaBDO = rutaBase + nombreBDO;
    String jpql;
    EntityManagerFactory emf;
    EntityManager em;
    
    public GestorUsuBDO() {
        conectarBDO();
    }
    
    public void conectarBDO() {
        try {
        System.out.println("->CREANDO UN ENTITYMANAGER ASOCIADO A LA BDO");
        emf = Persistence.createEntityManagerFactory(rutaBDO);
        em = emf.createEntityManager();

        System.out.println("BDO: " + rutaBDO + " creada.\n");            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public Object[][] obtenerTodo() {
        try {
            // Consulta JPQL para recuperar todos los deportistas
              TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
              List<Usuario> lista = query.getResultList();

            // Crear una matriz para almacenar los datos
            Object[][] tabla = new Object[lista.size()][2]; // el [4] son los campos en este caso son 4 (nomYApe, deporte, añoNac y altura). Si hubiera más, [5], ...[6],...

            // Rellenar la matriz con los datos de los deportistas
            for (int i = 0; i < lista.size(); i++) {
                usuario = lista.get(i);
                tabla[i][0] = usuario.getUsuario();
                tabla[i][1] = usuario.getClave();
            }
            return tabla;
        } catch (Exception e) {
            System.err.println("Error al recuperar datos de la BDO: " + e.getMessage());
            return new Object[0][0]; // Devolver una matriz vacía en caso de error
        }
    }
    
    public void cargarEjemplos(){
          Usuario admin = new Usuario("admin", "1234");
          Usuario usuario = new Usuario("pepe", "1010");
          
        try {
            // inicio transacción bloque hacer datos persistentes -> uno por cada commit()
            em.getTransaction().begin();
            
            // indicación de hacer persistentes los objetos vehículo
            em.persist(admin);
            em.persist(usuario);
            
            // em.persist(v); // provocando un error
            
            // confirmacion de la persistencia
            em.getTransaction().commit();
            
            System.out.println("Datos de usuarios persistentes en BDO.");
        } catch (Exception e) {
            System.err.println("\tError al ejecutar la transacción.");
        }
    }
    
    public void añadir(String usuario, String clave) {
        try {
            Usuario usu = new Usuario(usuario, clave); //Aqui están los valores que vienen de la ventana (los escritos por el admin)
            // inicio transacción bloque hacer datos persistentes -> uno por cada commit()
            em.getTransaction().begin();

            // indicación de hacer persistentes los objetos usuarios
            em.persist(usu); //se añade el usuario y la clave dados desde la ventana

            // em.persist(v); // provocando un error
            // confirmacion de la persistencia
            em.getTransaction().commit();

            System.out.println("Usuario nuevo añadido a la BDO." + usuario + " y " + clave);
        } catch (Exception e) {
            System.err.println("\tError al ejecutar la transacción.");
        }
    }
    
    public void borrar(String nombre){
        try {
            // inicio transacción bloque hacer datos persistentes -> uno por cada commit()
            em.getTransaction().begin();
            
            //Búsqueda
            Usuario usu = em.find(Usuario.class, nombre);
            // ACCION
            if (usu != null) {
            em.remove(usu);
            System.out.println("Borrando usuario: " + usu);
            }
            else {
                System.out.println("NO SE ENCUENTRA");
            }
            
            // confirmacion de la persistencia
            em.getTransaction().commit();

            System.out.println("Usuario borrado");
        } catch (Exception e) {
            System.err.println("\tError al ejecutar la transacción.");
        }
    }
    
    public String obtenerClave(String nombre){
        String clave = null;
        try {
            // inicio transacción bloque hacer datos persistentes -> uno por cada commit()
            em.getTransaction().begin();
            
            //Búsqueda
            Usuario usu = em.find(Usuario.class, nombre);
            // ACCION
            if (usu != null) {
                clave = usu.getClave();
                System.out.println("Clave obtenida es: " + clave);
            }
            else {
                System.out.println("NO SE ENCUENTRA");
            }
            
            // confirmacion de la persistencia
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.err.println("\tError al ejecutar la transacción.");
        }
        return clave;
    }
}
