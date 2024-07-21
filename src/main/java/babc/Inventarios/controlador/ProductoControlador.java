package babc.Inventarios.controlador;


import babc.Inventarios.excepcion.RecursoNoEncontradoExcepcion;
import babc.Inventarios.modelo.Producto;
import babc.Inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//localhost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value= "http://localhost:4200") //angular... permitir la conexion cruzada
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    //localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
    List<Producto> productos = this.productoServicio.listarProductos();
       logger.info("productos obtenidos");
       productos.forEach(producto -> logger.info(producto.toString()));

        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
    logger.info("prodcuto a agregar" +producto);
    return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable int id) {
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontró el Id");
        }

    }

    }
