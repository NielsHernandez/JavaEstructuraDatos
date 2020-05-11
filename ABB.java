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
public class ABB {

    public NodoArbol raiz;

    //constructor
    public ABB() {
        this.raiz = null;
    }

    public void agregar(int dato, String nombre) {

        //creacion del nuevo nodo 
        NodoArbol nuevo = new NodoArbol(dato, nombre);

        //verificar si la raiz esta vacia y agregar el primer nodo si lo esta
        if (raiz == null) {
            raiz = nuevo;
        } else {
            //crear 2 nodos temporales
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;

                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {

                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }

    }

    //metodo booleano para saber si la raiz esta vacia
    public boolean esVacia() {
        return raiz == null;
    }

    //Recorridos
    //InOrden
    public void inOrden(NodoArbol r) {

        if (r != null) {
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato + " , ");
            inOrden(r.hijoDerecho);
        }

    }

    //preOrden
    public void preOrden(NodoArbol r) {

        if (r != null) {
            System.out.print(r.dato + " , ");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }

    }

    //postOrden
    public void postOrden(NodoArbol r) {

        if (r != null) {
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
            System.out.print(r.dato + " , ");
        }

    }

    //Buscar metodo
    public NodoArbol buscar(int d) {
        NodoArbol auxiliar = raiz;

        while (auxiliar.dato != d) {

            if (d < auxiliar.dato) {

                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                auxiliar = auxiliar.hijoDerecho;
            }

            if (auxiliar == null) {

                return null;
            }
        }

        return auxiliar;
    }
    //

    //metodo eliminar
    public boolean eliminar(int d) {
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;

        boolean esHijoIzq = true;

        while (auxiliar.dato != d) {

            padre = auxiliar;
            if (d < auxiliar.dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {

                return false;
            }
        }//end while

        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {

            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzq) {

                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (auxiliar.hijoDerecho == null) {
            //
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoIzquierdo;
            } else if (esHijoIzq) {

                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
            //
        } else if (auxiliar.hijoIzquierdo == null) {

            if (auxiliar == raiz) {
                raiz = auxiliar.hijoDerecho;
            } else if (esHijoIzq) {

                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }

        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {

                raiz = reemplazo;

            } else if (esHijoIzq) {

                padre.hijoIzquierdo = reemplazo;

            } else {
                padre.hijoDerecho = reemplazo;
            }
            //fijar el nodo
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }

        return true;

    }

    //metodo reemplazo devuleve el nodo a usar donde se elimina
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp) {

        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.hijoDerecho;

        while (auxiliar != null) {

            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;

        }

        if (reemplazo != nodoReemp.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemp.hijoDerecho;
        }

        System.out.println("el nodo reemplazo es " + reemplazo);

        return reemplazo;

    }
    
    //total de nodos
    
   
  
    
      public int numeroNodos(NodoArbol raizNodo) 
    { 
        if (raizNodo == null) 
            return 0; 
        else
            return(numeroNodos(raizNodo.hijoIzquierdo) + 1 + numeroNodos(raizNodo.hijoDerecho)); 
    }
      
    public int getAlturaArbol(NodoArbol raizNodo) {
    if (raizNodo == null) {
      return -1;
    }
    
    return Math.max(getAlturaArbol(raizNodo.hijoIzquierdo), getAlturaArbol(raizNodo.hijoDerecho)) + 1;
  }
    
    
     public void recorridoTransversal(NodoArbol node) {
    if (node == null) {
      return;
    }
    
    int height = getAlturaArbol(node);
    
    for(int i = 0; i <= height; i++) {
      printAtGivenLevel(node, i + 1);
      System.out.println();
    }
  }
  
  
  
  
  public void printAtGivenLevel(NodoArbol node, int level) {
    if(node == null) {
      return;
    }
    
    if(level == 1) {
      System.out.print(node.dato + " ");
      return;
    }
    
    printAtGivenLevel(node.hijoIzquierdo, level - 1);
    printAtGivenLevel(node.hijoDerecho, level - 1);
  }
  
  
  public int funcion(NodoArbol raiz, NodoArbol x){

   if(raiz == null)

      return 0;

   if(x.dato == raiz.dato)

      return 0;

   if(x.dato < raiz.dato)

      return funcion(raiz.hijoIzquierdo, x) + 1;

   else

      return funcion(raiz.hijoDerecho,x) + 1;

  }
    
    


   
}
