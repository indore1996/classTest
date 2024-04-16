package com.example.demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

	@Autowired
	private ActorRepo actorRepo;
	
	@GetMapping("/{pageNumber}/{pageSize}")
	public Page<Actor> getAllactor(@PathVariable Integer pageNumber,@PathVariable Integer pageSize, @RequestParam(defaultValue="id") String sortBy){
		Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		return actorRepo.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Actor getById(@PathVariable Long id) throws Exception {
		Actor actor = actorRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		return actor;
	}
	
	
	@PostMapping
	public Actor createActor(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("/{id}")
	public Actor updateActor(@RequestBody Actor actor, @PathVariable Long id) throws Exception {
		Actor act = actorRepo.findById(id).orElseThrow(()->new Exception("no"+id));
		
		act.setName(actor.getName());
		
		return actorRepo.save(act);
	}
	
	@DeleteMapping("/{id}")
	public void deleteActor(@PathVariable Long id) {
		actorRepo.deleteById(id);
	}
}
