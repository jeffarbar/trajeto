package br.com.send.trajeto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.send.trajeto.model.TrajetoModel;

@Repository
public interface TrajetoRepository extends MongoRepository<TrajetoModel, String> {

	 List<TrajetoModel> findByIdentificadorDispositivoAndDtCriacaoBetween(String identificadorDispositivo, Date startDate, Date endDate);
}
