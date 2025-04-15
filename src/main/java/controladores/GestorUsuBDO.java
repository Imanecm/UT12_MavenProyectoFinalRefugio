/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controladores;

import com.objectdb.o.JOP;
import java.awt.Component;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
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
            em.find(Usuario.class, usuario);
            // indicación de hacer persistentes los objetos usuarios
            em.persist(usu); //se añade el usuario y la clave dados desde la ventana

            // confirmacion de la persistencia
            em.getTransaction().commit();

            System.out.println("Usuario nuevo añadido a la BDO." + usuario + " y " + clave);
        } catch (Exception e) {
            System.out.println(e);
            // esto es creado por la ayuda de NetBeans, para inicializar la ventana desde aqui, y lanzar un mensaje de error en el que el nombre
            // del usuario ya existe y no pueden haber 2 repetidos
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent, "Pruebe con otro nombre de usuario, puede que este esté en uso.");
        }
    }
    
    public void borrarTodo(int confirm) {
        Query qBorrar;
        Query qModif;

        try {
            if (confirm == 0) {
                em.getTransaction().begin();
                
                jpql = "DELETE FROM Usuario";
                System.out.println("");
                System.out.println("Borrando vehículo con jpql [" + jpql + "]");
                qModif = em.createQuery(jpql);
                int numObjBorrados = qModif.executeUpdate();
                System.out.println("Usuarios borrados: " + numObjBorrados);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e);
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
    
    public void actualizar(String buscarNom, String nombre, String clave) {
        // modificación  -------------------------------------------------------
        System.out.println("Actualizando los datos del usuario");
        // inicio transacción bloque modificar
        em.getTransaction().begin();

        // modificación mediante identificador 
        System.out.println("Modificando matrícula con setter");
        Usuario usu = em.find(Usuario.class, buscarNom); //Se busca por el nombre del usuario ya que no se van a poder tener dos iguales
        usu.setUsuario(nombre);
        usu.setClave(clave);

        // modificación mediante query
//        Query qModif;
//        jpql = "UPDATE Usuarios SET usuario = '" + nombre + "', clave = '" 
//                    + clave + "'"; 
//        System.out.println("Modificando matrícula con jpql [" + jpql + "]");
//        System.out.println("");
//        qModif = em.createQuery(jpql);
//        int numObjModificados = qModif.executeUpdate();
        em.getTransaction().commit();
    }
    
    //FICHEROS
    public void guardarArchivoBin(String nomArchivoBin, Object[][] tabla) {
        try {
            ObjectOutputStream fichero1;
            fichero1 = new ObjectOutputStream(new FileOutputStream(nomArchivoBin));
            fichero1.writeObject(tabla);
            System.out.println("\tLos datos se han guardado correctamente en " + nomArchivoBin);
        } catch (IOException e) {
            System.out.println("\tError: ha habido una fallo al escribir los datos de la tabla en el archivo.");
        }
    }
    
    public void cargarArchivoBin(String nomArchivoBin) throws ClassNotFoundException {
        Object[][] tabla = null;
        String usuario, clave;
        
        // borramos la tabla completa para poner solo lo guardado
        borrarTodo(0);
        try {
            ObjectInputStream fichero1 = new ObjectInputStream(new FileInputStream(nomArchivoBin));
            tabla = (Object[][]) fichero1.readObject();
            for (Object[] objects : tabla) {
                    usuario = objects[0].toString();
                    clave = objects[1].toString();
                    añadir(usuario, clave);
            }
            System.out.println("Los datos se han cargado correctacamente desde " + nomArchivoBin);
            
        } catch (IOException e) {
            System.out.println("\tError: Ha habido un fallo al cargar los datos.");
        }
    }
    
    public void guardarArchivoXML(String nomArchivoXML, Object[][] tabla) {
        XMLEncoder xmle;

        // necesitamos pasar el DefaultListModel a List para poder guardarlo como XML
        try {
            xmle = new XMLEncoder(new FileOutputStream(nomArchivoXML) );
            xmle.writeObject(tabla);
            xmle.close();
            System.out.println("\tLos datos se han guardado correctamente en " + nomArchivoXML);
        } catch (Exception e) {
            System.err.println("\tERROR en la escritura de datos del archivo: " + "listadoColores.xml");
        }
    }
    
    public void cargarArchivoXML(String nomArchivoXML) throws ClassNotFoundException {
        Object[][] tabla = null;
        String usuario, clave;

        // borramos la tabla completa para poner solo lo guardado
        borrarTodo(0);
        try {
            XMLDecoder xmld = new XMLDecoder(new FileInputStream(nomArchivoXML));
            tabla = (Object[][]) xmld.readObject();
//            xmld.close();
            for (Object[] objects : tabla) {
                usuario = objects[0].toString();
                clave = objects[1].toString();
                añadir(usuario, clave);
            }
            System.out.println("Los datos se han cargado correctamente desde " + nomArchivoXML);
        } catch (Exception e) {
            System.err.println("\tERROR en la lectura de datos del archivo: " + "listadoColores.xml");
        }
    }
}
