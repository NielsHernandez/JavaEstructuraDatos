package repaso;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ListaEnlazada miLista = new ListaEnlazada();
		
		miLista.insertar(new Integer(50));
		miLista.insertar(new Integer(27));
		miLista.insertar(new Integer(100));
		miLista.insertar(new Integer(8));
		miLista.insertar(new Integer(18));
		
		miLista.borrar(4);
		miLista.borrar(5);
		
		System.out.println("Lista Original");
		
		miLista.mostrar();
		
		
		System.out.println("Lista Ordenada");
		miLista.ordenarList();
		miLista.mostrar();
		
		miLista.encontrar(5);
		
		

	}

}
