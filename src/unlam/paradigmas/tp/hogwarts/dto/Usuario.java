package unlam.paradigmas.tp.hogwarts.dto;

import java.util.Objects;

import unlam.paradigmas.tp.hogwarts.producto.Producto;

public class Usuario {
    private String nombre;
    private String gusto;
    private float presupuesto;
    private int horas;
    private ResumenCompraDeUsuario compras;
    
    public Usuario(String nombre, String gusto, float presupuesto, int horas) {
        this.nombre = nombre;
        this.gusto = gusto;
        this.presupuesto = presupuesto;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGusto() {
        return gusto;
    }

    public void setGusto(String gusto) {
        this.gusto = gusto;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    //TODO esto es correcto? RTA: No se me ocurre qué podría representar la implementación del método contiene.
    public boolean estaComprado(Producto producto) {
    	return compras.estaComprado(producto);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", gusto='" + gusto + '\'' +
                ", presupuesto=" + presupuesto +
                ", horas=" + horas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Float.compare(usuario.getPresupuesto(), getPresupuesto()) == 0 && getHoras() == usuario.getHoras() && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getGusto(), usuario.getGusto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getGusto(), getPresupuesto(), getHoras());
    }
    
    public boolean recursosDisponibles() {
    	return this.presupuesto == 0 || this.horas == 0;
    }
}
