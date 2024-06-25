
	package com.edubridge.projector.dao;

	import java.util.List;

import com.edubridge.projector.model.Projector;

	

	public interface Projectordao {
		
		int addProjector(Projector p);
		List<Projector> findProjector();
		Projector findProjectorByBrand(String Brand);
		int updateProjector(Projector p);
		int deleteProjectorByBrand(String Brand);
		void deleteAllProjectors();

	}

