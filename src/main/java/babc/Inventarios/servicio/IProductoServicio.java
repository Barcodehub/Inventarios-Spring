package babc.Inventarios.servicio;

import babc.Inventarios.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProducto(Integer idProducto);



}
