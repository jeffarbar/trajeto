package br.com.send.trajeto.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.send.trajeto.repository.TrajetoRepository;
import br.com.send.trajeto.util.DataUtil;
import br.com.send.trajeto.vo.TrajetoVo;

@Service
public class TrajetoService {

	private static final Logger logger = LogManager.getLogger(TrajetoService.class);
	
	@Autowired
	private TrajetoRepository trajetoRepository;
	
	public List<TrajetoVo> find(String identificadorDispositivo, String dtIniyyyyMMddHHmmss , String dtFinalyyyyMMddHHmmss) throws Exception{

		try {
			
			Date startDate = DataUtil.convert_yyyyMMddHHmmss(dtIniyyyyMMddHHmmss);
			Date endDate = DataUtil.convert_yyyyMMddHHmmss(dtFinalyyyyMMddHHmmss);;
			
			return trajetoRepository.findByIdentificadorDispositivoAndDtCriacaoBetween(identificadorDispositivo, 
					startDate, endDate).parallelStream().map( TrajetoVo :: new)
			 .collect(Collectors.toList());
		
		}catch (Exception e) {
			logger.error("{}", e);
			throw e;
		}
	}
	
}
