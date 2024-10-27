public class Libro {

    private Prestamo prestamo;
    private String nombre;
    private String autor;
    private String editorial;

    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return this.editorial;
    }

    /**
     *
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     *
     * @param nombre
     * @param autor
     * @param editorial
     */
    public Libro(String nombre, String autor, String editorial) {
        // TODO - implement Libro.Libro
        throw new UnsupportedOperationException();
    }

}