public class nodo {
    String nombre;


    public nodo(String nombre) {
        this.nombre = nombre;
    }

    public nodo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        /*return "nodo{" +
                "nombre='" + nombre + '\'' +
                '}';*/
        return nombre;
    }
}
