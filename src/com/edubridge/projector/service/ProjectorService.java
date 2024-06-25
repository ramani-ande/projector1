
	package com.edubridge.projector.service;

	import java.util.List;

	import com.edubridge.projector.model.Projector;

	public interface ProjectorService {
		int addProjector(Projector p);
		List<Projector> findProjectors();
		Projector findProjectorByBrand(String brand);
		int updateProjector(Projector p);
		int deleteProjectorBybrand(String brand);
		void deleteAllProjectors();
		
	}

