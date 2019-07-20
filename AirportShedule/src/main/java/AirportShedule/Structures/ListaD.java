package Structures;

public class ListaD {

    private NodoDoble inicio, fin;
    int size=0;

    public ListaD() {
        inicio = null;
        fin = null;
    }

    public void add(int numero) {

        NodoDoble nuevo = new NodoDoble(numero);
        nuevo.numero = numero;

        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = null;
            inicio.anterior = null;
            fin = inicio;
            size++;
        } else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            nuevo.siguiente = null;
            fin = nuevo;
            size++;
        }
    }

    public void seeLeft() {
        NodoDoble actual = fin;

        while (actual != null) {
            System.out.print("[" + actual.numero + "] ");
            actual = actual.anterior;
        }
    }

    public void seeRight() {
        
        NodoDoble actual = inicio;
        while (actual != null) {
            System.out.print("[" + actual.numero + "] ");
            actual = actual.siguiente;
        }
    }

    public boolean itsEmpty() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addToFinal(int n) {
        if (!itsEmpty()) {
            fin = new NodoDoble(n, null, fin);
            fin.anterior.siguiente = fin;
            size++;
        } else {
            inicio = fin = new NodoDoble(n);
            size++;
        }
    }

    public void addToBegining(int n) {
        if (!itsEmpty()) {
            inicio = new NodoDoble(n, inicio, null);
            inicio.siguiente.anterior = inicio;
            size++;
        } else {
            inicio = fin = new NodoDoble(n);
            size++;
        }
    }

    //metodo para mostrar la lista inicio a fin
    public void MostrarInicioFIn() {
        if (!itsEmpty()) {
            String datos1 = " ";
            NodoDoble aux = inicio;
            while (aux != null) {
                datos1 = datos1 + " [" + aux.numero + "] " + "<->";
                aux = aux.siguiente;
            }
            System.out.print(datos1);
        }
    }

    public void MostrarFinInicio() {
        if (!itsEmpty()) {
            String datos1 = " <-> ";
            NodoDoble aux = fin;
            while (aux != null) {
                datos1 = datos1 + " [" + aux.numero + "] " + "<->";
                aux = aux.anterior;
            }
            System.out.println(datos1);
        }
    }
}
