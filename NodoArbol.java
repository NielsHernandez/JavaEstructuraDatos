package arbol.binario.busquedad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author q669YS4G
 */
public class NodoArbol {
    
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;

    public NodoArbol(int dato, String nombre) {
        this.dato = dato;
        this.nombre = nombre;
        this.hijoDerecho=null;
        this.hijoIzquierdo=null;
    }

    @Override
    public String toString() {
        return "NodoArbol{" + "dato=" + dato + ", nombre=" + nombre + '}';
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    
    
    
    
}
