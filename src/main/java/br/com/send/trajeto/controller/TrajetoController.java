package br.com.send.trajeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.send.trajeto.service.TrajetoService;
import br.com.send.trajeto.vo.TrajetoVo;


@RestController
@RequestMapping(path = "/trajeto")
public class TrajetoController extends Controller {

	@Autowired
	private TrajetoService trajetoService;
	
	@GetMapping(path="/{identificadorDispositivo}/{dtIniyyyyMMddHHmmss}/{dtFinalyyyyMMddHHmmss}", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<List<TrajetoVo>> get(@PathVariable("identificadorDispositivo") final String identificadorDispositivo,
    		@PathVariable("dtIniyyyyMMddHHmmss") final String dtIniyyyyMMddHHmmss, 
    		@PathVariable("dtFinalyyyyMMddHHmmss") final String dtFinalyyyyMMddHHmmss){
		try {
			return ResponseEntity.ok().body(trajetoService.find(identificadorDispositivo, dtIniyyyyMMddHHmmss , dtFinalyyyyMMddHHmmss )); 
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
    }
}
