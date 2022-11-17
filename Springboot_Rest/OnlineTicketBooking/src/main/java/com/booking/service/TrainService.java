package com.booking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.model.Trains;
import com.booking.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	private TrainRepository trainRepository;

	public TrainRepository getTrainRepository() {
		return trainRepository;
	}

	public void setTrainRepository(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	public Trains insertTrain(Trains train)
	{
		return trainRepository.save(train);
	}
	public Trains updateTrain(int trainNo) {
		Optional<Trains> optional = trainRepository.findById(trainNo);
        Trains train= null;
        if (optional.isPresent())
            train = optional.get();
        else
            throw new RuntimeException(
                "Train not found for id : " + trainNo);
        return train;
	}
	public void deleteTrain(int trainNo) {
		trainRepository.deleteById(trainNo);
	}
	public List<Trains> getTrain(){
		List<Trains> b=trainRepository.findAll();
		return b;
	}
	
	public List<Trains> searchTrains(String to,String from){
		return trainRepository.findByToAndFrom(to, from);
	}
}
