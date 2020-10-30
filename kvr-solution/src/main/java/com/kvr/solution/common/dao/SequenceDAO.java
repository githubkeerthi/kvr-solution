package com.kvr.solution.common.dao;

import com.kvr.solution.exceptions.SequenceException;

public interface SequenceDAO {

	long getNextSequenceId(String key) throws SequenceException;
}
