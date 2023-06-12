package unlam.paradigmas.tp.hogwarts.dto;

import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Producto {

    protected boolean esPromocion;
    protected String tipo;

    public static List<Producto> prepararOfertas(List<Promocion> promociones, Map<String, Atraccion> atracciones) {
        List<Producto> ofertas = new ArrayList<>();
        ofertas.addAll(promociones);
        ofertas.addAll(atracciones.values());

        ProductoComparator comparator = new ProductoComparator();
        ofertas.sort(comparator);

        return ofertas;
    }

    public abstract boolean hayCupo();

    public abstract void descontarCupo();

    public abstract boolean esProductoPreferidoPorElUsuario(String preferencia);

    public abstract double getPrecio();

    public abstract double getDuracion();

    public String getTipo() {
        return this.tipo;
    }

    public abstract boolean contiene(Producto otro);

    public boolean comprar() {
        if (hayCupo()) {
            descontarCupo();
            return true;
        }
        return false;
    }

    public boolean esPromocion() {
        return this.esPromocion;
    }

    public boolean esOfertable(Usuario usuario) {
        return (usuario.getPresupuesto() >= this.getPrecio() &&
                usuario.getHoras() >= this.getDuracion() &&
                !usuario.estaComprado(this) &&
                this.hayCupo());
    }

    public boolean esGustoPreferido(Usuario usuario) {
        return usuario.getGusto().equals(getTipo());
    }


}