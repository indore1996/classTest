package com.example.demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/film")
public class FilmController {

	@Autowired
	private FilmRepo actorRepo;
	
	@GetMapping("/{pageNumber}/{pageSize}")
	public Page<Film> getAllactor(@PathVariable Integer pageNumber,@PathVariable Integer pageSize, @RequestParam(defaultValue="id") String sortBy){
		Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		return actorRepo.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Film getById(@PathVariable Long id) throws Exception {
		Film actor = actorRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		return actor;
	}
	
	@PostMapping
	public Film createActor(@RequestBody Film actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("/{id}")
	public Film updateActor(@RequestBody Film actor, @PathVariable Long id) throws Exception {
		Film act = actorRepo.findById(id).orElseThrow(()->new Exception("no"+id));
		
		act.setTitle(actor.getTitle());
		
		return actorRepo.save(act);
	}
	
	@DeleteMapping("/{id}")
	public void deleteActor(@PathVariable Long id) {
		actorRepo.deleteById(id);
	}
}
