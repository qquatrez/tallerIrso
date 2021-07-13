package tallerFinal.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tallerFinal.Model.PeliculasModel;
import tallerFinal.Exception.PeliculaNotFoundException;
import tallerFinal.Repository.PeliculasRepository;

@Service
public class PeliculasService {
	
	@Autowired
	PeliculasRepository peliculasRepository;
	
	//Get
	public List <PeliculasModel> listAllPeliculas(){
		return peliculasRepository.findAll();
	}
	
	public PeliculasModel getPelicula(Integer idPelicula) {
		return peliculasRepository.findById(idPelicula).get();
	}
	
	//Delete
	public void deletePeliculaById(Integer idPelicula) throws PeliculaNotFoundException{
		Optional <PeliculasModel> peliculaModel = peliculasRepository.findById(idPelicula);
		
		if(peliculaModel.isPresent()) {
			peliculasRepository.deleteById(idPelicula);
		}
		else {
			throw new PeliculaNotFoundException("NO se encontro pelicula id ", idPelicula);
		}
	}
	
	//Post
	public void agregarPelicula(PeliculasModel peliculaModel) {
		peliculasRepository.save(peliculaModel);
	}
	
	
}
