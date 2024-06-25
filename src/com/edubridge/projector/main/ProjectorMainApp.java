
	package com.edubridge.projector.main;

	import java.util.List;


	import java.util.Scanner;

	import com.edubridge.projector.model.Projector;
import com.edubridge.projector.service.ProjectorSeviceImpl;
	

	public class ProjectorMainApp {
		public static void main(String[] args) {
		com.edubridge.projector.service.ProjectorService service=new ProjectorSeviceImpl();
			Projector p=null;
			
			Scanner in =new Scanner(System.in);
			int option ;
			do {
				System.out.println("Welcome to Projector App");
				System.out.println("*******");
				System.out.println("1.add Projector name");
				System.out.println("2. view Projector");
				System.out.println("3. search Projector");
				System.out.println("4. update Projector");
				System.out.println("5. delete Projector");
				System.out.println("6. delete all Projector");
				System.out.println("0. exit");
				System.out.println("Please choose option:");
				option = in.nextInt();
				
				switch(option) {
				case 1:
				
				System.out.println("Add name of Projector:");
				System.out.println("--------------------");
				System.out.println("Add Projector brand name:");
				String brand=in.next();
				System.out.println("Enter Projector colour:");
				String colour=in.next();
				System.out.println("Enter Projector Connection:");
				String connection=in.next();		
				System.out.println("Enter Projector Imagescreen:");
				String imagescreen=in.next();
				System.out.println("Enter Projector Price:");
				float price=in.nextFloat();
				
				
				p=new Projector();
				p.setBrand(brand);
				p.setColour(colour);
				p.setConnection(connection);
				p.setImagescreen(imagescreen);
				p.setPrice(price);
				
				int status=service.addProjector(p);
				
				if(status==1) {
					
					System.out.println("Brand is added..!");
				}
				else {
					System.out.println("something went wrong!");
				}
				
				break;
				case 2:
					System.out.println("view brands");
					List<Projector> projectors=service.findProjectors();
					System.out.println("BRAND\tCOLOUR\tCONNECTION\tIMAGESCREEN\tPRICE");
					System.out.println("-----\t-----\t------\t------\t-------");
					
					for(Projector projector:projectors) {
						System.out.println(projector.getBrand()+"\t"+projector.getColour()+"\t"+projector.getConnection()+"\t"+projector.getImagescreen()+"\t"+projector.getPrice());
					}
				break;
				case 3:
					System.out.println("search Projector");
					System.out.println("please enter Projector name:");
					String searchBrand=in.next();
					Projector searchProjector=service.findProjectorByBrand(searchBrand);
					if(searchProjector!=null) {
						//System.out.println("Id: "+searchGrinder.getId());
						System.out.println("Brand: "+searchProjector.getBrand());
						System.out.println("Colour: "+searchProjector.getColour());
						System.out.println("Connection: "+searchProjector.getConnection());
						System.out.println("Imagescreen: "+searchProjector.getImagescreen());
					}else {
						System.out.println("no Projector found..!");
					}
					break;
				case 4:
					System.out.println("please enter projector name:");
					searchBrand=in.next();
					searchProjector=service.findProjectorByBrand(searchBrand);
					if(searchProjector!=null) {
						//displaying existing contact details
						System.out.println("Id: "+searchProjector.getId());
						System.out.println("Brand: "+searchProjector.getBrand());
						System.out.println("Colour: "+searchProjector.getColour());
						System.out.println("Connection: "+searchProjector.getConnection());
						System.out.println("Imagescreen: "+searchProjector.getImagescreen());
						System.out.println("Price: "+searchProjector.getPrice());
						//Reading contact update info
						System.out.println("please enter brand:");
						brand=in.next();
						System.out.println("please enter colour:");
						colour=in.next();
						System.out.println("please enter connection:");
						connection=in.next();
						System.out.println("please enter imagescreen:");
						imagescreen=in.next();
						System.out.println("please enter price:");
						price=in.nextFloat();
						
						
						Projector updateProjector=new Projector();
						
						updateProjector.setColour(colour);
						updateProjector.setConnection(connection);
						
						updateProjector.setImagescreen(imagescreen);
						updateProjector.setPrice(price);
						updateProjector.setId(searchProjector.getId());
						                                                                              
						int updateStatus =service.updateProjector(updateProjector);
						if(updateStatus==1) {
							System.out.println("Projector updated successfull");
						}else {
							System.out.println("something is wrong!");
						}
						
					}else {
						System.out.println("no Projector found with brand");
					}
					break;
				case 5:
					System.out.println("delete Projector");
					System.out.println("Please enter Projector brand:");
					searchBrand=in.next();
					
					searchProjector =service.findProjectorByBrand(searchBrand);
					if(searchProjector!=null) {
						int deleteStatus=service.deleteProjectorBybrand(searchBrand);
						if(deleteStatus==1) {
							System.out.println("Projector deleted successfully");
						}else {
							System.out.println("something went wrong");
						}
						}else {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
							                                                             
							System.out.println("No Projector found...!");
							
					}

					break;
				case 6:
					System.out.println("Are you sure delete all Grinder?[Y/N]");
					
					String deleteConfirmStatus = in.next();
					if(deleteConfirmStatus.equalsIgnoreCase("Y")) {
						service.deleteAllProjectors();
						System.out.println("all Projector deleted!");
					}
					break;
				case 0:
					System.out.println("BYE--...--!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option!");
					break;	
			}
				}while(option!=0);
		}
	}

