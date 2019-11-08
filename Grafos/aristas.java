public class aristas {
    public nodo nodo1;
    public nodo nodo2;
    public int precio;


    public aristas() {
    }

    public aristas(nodo nodo1, nodo nodo2, int precio) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.precio = precio;
    }

    public nodo getNodo1() {
        return nodo1;
    }

    public void setNodo1(nodo nodo1) {
        this.nodo1 = nodo1;
    }

    public nodo getNodo2() {
        return nodo2;
    }

    public void setNodo2(nodo nodo2) {
        this.nodo2 = nodo2;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "aristas{" +
                "nodo1=" + nodo1 +
                ", nodo2=" + nodo2 +
                ", precio=" + precio +
                '}';
    }
}
