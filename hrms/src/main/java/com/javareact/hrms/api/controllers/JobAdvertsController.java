package com.javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.hrms.business.abstracts.JobAdvertService;
import com.javareact.hrms.core.utilities.results.DataResult;
import com.javareact.hrms.core.utilities.results.Result;
import com.javareact.hrms.entities.concretes.JobAdvert;
import com.javareact.hrms.entities.concretes.JobPosition;
import com.javareact.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	
	@PostMapping("/add")
	
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertDto jobAdvert){
		return ResponseEntity.ok(this.jobAdvertService.add(jobAdvert));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobAdvert jobAdvert){
		return ResponseEntity.ok(this.jobAdvertService.update(jobAdvert));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.jobAdvertService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@PathVariable("id") int id){
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getAll")
	//@Cacheable("allJobAdverts")
	public DataResult<List<JobAdvert>> getAll(){		
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id){
		return this.jobAdvertService.changeOpenToClose(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList(){
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}
	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt(){
		return this.jobAdvertService.findAllByOrderByPublishedAt();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id){
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}
}