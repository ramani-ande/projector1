
	package com.edubridge.projector.service;

	import java.util.List;


	import com.edubridge.projector.dao.Projectordao;
	import com.edubridge.projector.dao.ProjectordaoImpl;
	import com.edubridge.projector.model.Projector;

	public class ProjectorSeviceImpl implements ProjectorService{
			
		private Projectordao dao= new ProjectordaoImpl();

		@Override
		public int addProjector(Projector p) {
			// TODO Auto-generated method stub
			return dao.addProjector(p);
		}

		public List<Projector> findProjectors() {
			// TODO Auto-generated method stub
			return dao.findProjector();
		}

		@Override
		public Projector findProjectorByBrand(String brand) {
			// TODO Auto-generated method stub
			return dao.findProjectorByBrand(brand);
		}

		@Override
		public int updateProjector(Projector p) {
			// TODO Auto-generated method stub
			return dao.updateProjector(p);
		}

		@Override
		public int deleteProjectorBybrand(String brand) {
			// TODO Auto-generated method stub
			return dao.deleteProjectorByBrand(brand);
		}

		@Override
		public void deleteAllProjectors() {
			// TODO Auto-generated method stub
			dao.deleteAllProjectors();
		}

	}

