package repaso;

public class ListaEnlazada {
	
	//crear variables auxiliares para los enlaces entre los nodos
	
	public Nodo inicio;
	public Nodo fin;
	public Nodo anterior;
	public Nodo actual;
	public int cantidad;
	
	public ListaEnlazada()
	{
		inicio=null;
		fin=null;
		cantidad=0;
	}
	
	
	public void insertar(Object valor)
	{
		actual = new Nodo(valor);
		
		//validar si la lista esta vacia
		if(inicio==null)
		{
			inicio=actual;
			fin=actual;
		}
		else//con esto se va corriendo el enlace al final o actual
		{
			fin.setSiguiente(actual);
			fin=actual;
		}
		
		cantidad++;
		
	}
	
	
	public void mostrar() {
		
		//iniciar del inicio
		
		actual = inicio;
		System.out.println("la cantidad de nodos en la lista es: "+cantidad);
		
		
		while(actual!=null)
		{
			System.out.print(actual.getDato()+" -> ");
			
			// mover el apuntador actual al siguiente elemento en la lista enlazada
			
			actual=actual.getSiguiente();
			
		}
		
		System.out.println("\n--------------------------------------------------------");
	}
	
	
	public void encontrar(int q)
	{
		
		actual = inicio;
		boolean encontrato=false;
		
		while(actual!=null)
		{
			
			if((int)actual.getDato()==q)
			{
			//System.out.print("Dato encontrado " + actual.getDato()+" -> ");
			encontrato = true;
			// mover el apuntador actual al siguiente elemento en la lista enlazada
			actual=null;
		
			
			}
			else
			{
				actual=actual.getSiguiente();
				
			}
			
			
			
		}
		
		if(encontrato==true)
		{
			System.out.print("Dato encontrado " + actual.getDato()+" -> ");
		}
		else
		{
			System.out.println("Dato no encontrado");
		}
		
		System.out.println("--------------------------------------------------------");
	}
	
	
	public void ordenarList()
	{
		
		// apuntar a la cabeza
		// crear un variable Nodo index como auxiliar
		
		Nodo current = inicio, index = null;
		int temp;
		
		if(inicio == null)
		{
			return;
		}
		
		else
		{
			while(current != null)
			{
				
				index = current.getSiguiente();
				
				while(index != null)
				{
					if((int)current.getDato() > (int)index.getDato())
					{
						temp = (int)current.getDato();
						current.setDato(index.getDato());
						index.setDato(temp);
						
					}
					
					index = index.getSiguiente();
				}
				
				current = current.getSiguiente();
			}
		}
	}
	
	
	public void borrar(int position)
	{
		
		
		if(cantidad >= position)
		{
			cantidad--;
			
			//chek si la lista no esta vacia
			
			if(inicio == null)
			{
				return;
			}
			
			Nodo temp = inicio;
			
			// si tenes q borrar el primer elemento inicio
			
			if(position == 0)
			{
				inicio = temp.getSiguiente();
				return;
			}
			
			// encontrar el nodo anterio del nodo hacer borrado
			
			for (int i=0; temp!=null && i<position-1; i++)
			{
				temp = temp.getSiguiente();
			}
			
			// si la posicion es mas que un numero de nodos
			
			if(temp == null || temp.getSiguiente() == null)
			{
				return;
			}
			
			Nodo next = temp.getSiguiente().getSiguiente();
			
			temp.setSiguiente(next);
			
			
			
			
		}
		else
		{
			System.out.println("lo siento la posicion "+position + " es invalida");
			
		}
		
		
		
		
		
	}
		
	
	

}
