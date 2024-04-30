/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class c_ControlBusqueda {

    private int id_Usuario;
    private ResultSet listaLibros;
    private Consulta consulta;
    private int valor = 0;
    private int limitePrestamo = 0;
    private ArrayList<Integer> librosPrestados = new ArrayList<>();
    private final E_libro libro;
    private final Temporal temp;
    private final E_prestamo pres;
    private final E_Usuario usuario;

    public c_ControlBusqueda() {
        this.listaLibros = new E_libro().getListaLibros();
        this.libro = new E_libro();
        this.temp = new Temporal();
        this.pres = new E_prestamo();
        this.usuario = new E_Usuario();
    }

    public void PrepararInterfazBusqueda() {
        this.consulta = new Consulta();
        this.usuario.setMatricula(this.id_Usuario);
        this.valor = this.usuario.getCantidadLibros();
        this.librosPrestados = this.usuario.getIdLibros();
        this.consulta.setLibrosId(this.librosPrestados);
        this.consulta.setValor(valor);
        this.consulta.setIdUsuario(this.id_Usuario);
        this.consulta.setLimitePrestamos(this.limitePrestamo);
        consulta.mostrarListaLibros(this.listaLibros, consulta.getModelo());
        this.consulta.setVisible(true);
    }

    public void setLimitePrestamos(int limite) {
        this.limitePrestamo = limite;
    }

    public void setIdUsuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    //metodos de busquedas
    public void buscarPorTitulo(String titulo) {
        this.libro.setTitulo(titulo);
        ResultSet rs = this.libro.consultarLibroPorTitulo();
        try {
            if (rs.next()) {
                rs = this.libro.consultarLibroPorTitulo();
                this.consulta.mostrarListaLibros(rs, this.consulta.getModelo());
            } else {
                this.consulta.mostrarListaLibros(new E_libro().getListaLibros(),
                        this.consulta.getModelo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarPorSubtitulo(String subtitulo) {
        this.libro.setSubtitulo(subtitulo);
        ResultSet rs = libro.consultarLibroPorTitulo();
        try {
            if (rs.next()) {
                rs = this.libro.consularLibroPorSubtitulo();
                this.consulta.mostrarListaLibros(rs, this.consulta.getModelo());
            } else {
                this.consulta.mostrarListaLibros(new E_libro().getListaLibros(),
                        this.consulta.getModelo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarPorMateria(String materia) {
        this.libro.setMateria(materia);
        ResultSet rs = this.libro.consultarLibroPorMateria();
        try {
            if (rs.next()) {
                rs = this.libro.consultarLibroPorMateria();
                this.consulta.mostrarListaLibros(rs, this.consulta.getModelo());
            } else {
                this.consulta.mostrarListaLibros(new E_libro().getListaLibros(),
                        this.consulta.getModelo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarPorAutor(String autor) {
        this.libro.setAutor(autor);
        ResultSet rs = this.libro.consultarLibroPorAutor();
        try {
            if (rs.next()) {
                rs = this.libro.consultarLibroPorAutor();
                this.consulta.mostrarListaLibros(rs, this.consulta.getModelo());
            } else {
                this.consulta.mostrarListaLibros(new E_libro().getListaLibros(),
                        this.consulta.getModelo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verificarFolioTemporal(int folio) {
        this.temp.setFolio(folio);
        ResultSet rs = this.temp.verificarFolio();
        boolean ver = false;
        try {
            ver = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ver;
    }

    public boolean verificarFolioPrestamo(int folio) {
        this.pres.setFolio(String.valueOf(folio));
        ResultSet rs = this.pres.verificarFolio();
        boolean ver = false;
        try {
            ver = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ver;
    }

    public int generarFolio() {
        int folio = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;
        while (true) {
            if (this.verificarFolioTemporal(folio) || this.verificarFolioPrestamo(folio)) {
                folio = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;
            } else {
                break;
            }
        }
        return folio;
    }

    public boolean verificarMatricula(int matricula) {
        this.usuario.setMatricula(matricula);
        ResultSet rs = this.usuario.verificarUsuario();
        boolean encontrado = false;
        try {
            encontrado = rs.next();
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Matricula incorrecta",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encontrado;
    }
}
