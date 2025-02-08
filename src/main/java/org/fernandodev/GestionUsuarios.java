package org.fernandodev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GestionUsuarios extends Biblioteca{
    protected Collection<Usuario> listaUsuarios;

    public GestionUsuarios() {
        super();
        listaUsuarios = new ArrayList<>();
    }

    public void anadirUsuario(Usuario nuevoUsuario){
        this.listaUsuarios.add(nuevoUsuario);
    }

    public List<Usuario> obtenerListaUsuarios(){
        return new ArrayList<Usuario>(this.listaUsuarios);
    }

    public Usuario buscarUsuarioPorId(String userId){
        List<Usuario> result =  this.listaUsuarios.stream()
                .filter(usuario -> usuario.getId().equals(userId))
                .toList();
        return result.isEmpty() ? null : result.get(0);
    }

    public List<Usuario> buscarUsuariosPorNombre(String nombre){
        return this.listaUsuarios.stream()
                .filter(usuario -> usuario.getNombre().equals(nombre))
                .collect(Collectors.toList());
    }

    public List<Usuario> buscarUsuariosPorApellido(String apellido){
        return this.listaUsuarios.stream()
                .filter(usuario -> usuario.getApellidoPaterno().equals(apellido))
                .collect(Collectors.toList());
    }

    public void mostrarUsuarios() {
        String result = this.listaUsuarios.stream()
                .map(Usuario::toString)
                .collect(Collectors.joining("\n"));

        if (result.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("=== Lista de Usuarios ===\n" + result);
        }
    }

    public boolean eliminarUsuarioPorId(String userId){
        for(Usuario usuario: listaUsuarios) {
            if(usuario.getId().equals(userId)) {
                listaUsuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuarioPorNombre(String nombre){
        for(Usuario usuario: listaUsuarios) {
            if(usuario.getNombre().equals(nombre)) {
                listaUsuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuarioPorApellido(String apellido){
        for(Usuario usuario: listaUsuarios) {
            if(usuario.getApellidoPaterno().equals(apellido)) {
                listaUsuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }
}
