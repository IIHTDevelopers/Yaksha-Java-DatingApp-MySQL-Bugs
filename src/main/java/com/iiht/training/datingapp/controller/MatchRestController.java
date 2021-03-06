package com.iiht.training.datingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.filter.Filter;
import com.iiht.training.datingapp.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchRestController {

	@Autowired
	MatchService matchService;


	@GetMapping("/{userId}")
	public List<MatchDto> getMatches(@RequestParam Long userId) {
		return matchService.getAllMatches(userId);
	}

	@PostMapping("/{userId}")
	public List<UserDto> getCandidates(@RequestParam Long userId, List<Filter> filters) {
		return matchService.getPotentialMatches(userId, filters);
	}
}