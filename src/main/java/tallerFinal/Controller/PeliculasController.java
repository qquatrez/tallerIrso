package tallerFinal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

import tallerFinal.Model.PeliculasModel;
import tallerFinal.Service.PeliculasService;

@RestController
@RequestMapping("/taller")
public class PeliculasController {
	
	@Autowired
	PeliculasService peliculaService;
	
	
	//Get
	@GetMapping("/peliculas")
	public List <PeliculasModel>getAllPeliculas() {
		return peliculaService.listAllPeliculas();
	}
	
	@GetMapping("/peliculas/{id}")
	public ResponseEntity <PeliculasModel> getById(@PathVariable(value = "id") Integer idPelicula){
		try {
			PeliculasModel peliculaModel = peliculaService.getPelicula(idPelicula);
			return new ResponseEntity<PeliculasModel>(peliculaModel, HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<PeliculasModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/peliculas/{id}")
	public ResponseEntity<?> deletePelicula(@PathVariable(value = "id") int idPelicula){
		
		try {
			peliculaService.deletePeliculaById(idPelicula);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(RuntimeException ex){
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/peliculas")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPeliculas(@RequestBody PeliculasModel peliculaModel) {
		peliculaService.agregarPelicula(peliculaModel);
	}
	
	@PutMapping("/peliculas/{id}")
    public ResponseEntity<?> update(@RequestBody PeliculasModel peliculaModel, @PathVariable(value = "id") int idPelicula) {
        try {
            peliculaModel.setIdpelicula(idPelicula);
            peliculaService.agregarPelicula(peliculaModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	

}
