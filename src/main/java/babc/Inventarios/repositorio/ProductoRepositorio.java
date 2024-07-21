package babc.Inventarios.repositorio;

import babc.Inventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
