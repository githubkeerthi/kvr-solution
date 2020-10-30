package com.kvr.solution.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.entity.Sequence;

@Service
public class SequenceDAOImpl implements SequenceDAO {

	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public long getNextSequenceId(String key) {
		
		 Sequence seqId = getSquencedetailsByKey(key);
		 //If seqId null means first time adding record into the collection, so updating the sequence collection
		  if (seqId == null) {
			  
			  Sequence sequence = new Sequence();
			  sequence.setId(key);
			  sequence.setSeq(0);
			  mongoOperation.save(sequence);
			  return getSquencedetailsByKey(key).getSeq();
		  }

		  return seqId.getSeq();
	}
	
	private Sequence getSquencedetailsByKey(String key) {
		
		 //get sequence id
		  Query query = new Query(Criteria.where("_id").is(key));

		  //increase sequence id by 1
		  Update update = new Update();
		  update.inc("seq", 1);

		  //return new increased id
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);

		  //this is the magic happened.
		  Sequence seqId = 
	            mongoOperation.findAndModify(query, update, options, Sequence.class);
		  
		  return seqId;
	}

}
