package tallerFinal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tallerFinal.Model.PeliculasModel;

@Repository
public interface PeliculasRepository  extends JpaRepository  <PeliculasModel, Integer> {

}
