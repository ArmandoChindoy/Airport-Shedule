package Structures;

public class NodoDoble {

    int numero;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int dato) {

        siguiente = null;
        anterior = null;
        numero = dato;
    }

    public NodoDoble(int dato, NodoDoble s, NodoDoble a) {
        numero = dato;
        siguiente = s;
        anterior = a;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return
                " numero = " + numero +
                " siguiente = " + siguiente +
                " anterior = " + anterior;
    }
}
