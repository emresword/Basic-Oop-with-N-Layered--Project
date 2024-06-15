package oopWithNLayeredApp.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.InstructorDao;
import oopWithNLayeredApp.entities.Instructor;
import oopWithNLayeredApp.tools.Orm;

public class InstructorManager {
	private InstructorDao instructorDao;
	private List<Instructor> instructors;
	private Orm orm;
	private List<Logger> loggers;

	public InstructorManager(List<Instructor> instructors, Orm orm, List<Logger> loggers, InstructorDao instructorDao) {
		this.instructors = instructors;
		this.orm = orm;
		this.loggers = loggers;
		this.instructorDao = instructorDao;

	}

	public void add(Instructor instructor) throws Exception {
		for (Instructor instructor2 : instructors) {
			if (instructor.getInstructorName() == instructor2.getInstructorName()
					&& instructor.getInstructorSurname() == instructor2.getInstructorSurname()
					&& instructor.getInstructorAge() == instructor2.getInstructorAge()) {
				throw new Exception("This instructor already exist");
			}
		}
		orm.add();
		instructorDao.add(instructor);
		instructors.add(instructor);

		for (Logger logger : loggers) {
			logger.log(instructor.getInstructorName());
		}
	}

	public void delete(Instructor instructor) throws Exception {
		int sizeOfList = instructors.size();
		for (Instructor instructor2 : instructors) {

			if (instructor.getInstructorName() == instructor2.getInstructorName()
					&& instructor.getInstructorSurname() == instructor2.getInstructorSurname()
					&& instructor.getInstructorAge() == instructor2.getInstructorAge()) {
				instructorDao.delete(instructor);
				instructors.remove(instructor);
				break;
			}
			sizeOfList--;
			/*
			 * burda silinecek değerin var olup olmadiğini ogreniyoruz . altkai kodun
			 * çalışma prensibi foreach yapısı sayesinde butun değerleri dondurup son kalan
			 * list de eşit degilse thro fırlatıyor
			 */
			if (sizeOfList == 0) {
				throw new Exception("this Instructor doesn't exist");
			}
		}

	}

	public void update(Instructor instructor) throws Exception {
		// ************************burda hata varrrrrr************************
		// burda ise değistirilecek nesne nesne listesinde varmi yanı kişi mevcutmu
		for (Instructor instructor2 : instructors) {
			if (instructor.getInstructorName() == instructor2.getInstructorName()
					&& instructor.getInstructorSurname() == instructor2.getInstructorSurname()
					&& instructor.getInstructorAge() == instructor2.getInstructorAge()) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("please enter new Instructor");
				String newInstructor = scanner.next();
				instructor.setInstructorName(newInstructor);
				System.out.println("please enter surname of Instructor");
				String newSurname = scanner.next();
				instructor.setInstructorSurname(newSurname);
				System.out.println("please enter age of Instructor");
				int ageOfInstructor = scanner.nextInt();
				instructor.setInstructorAge(ageOfInstructor);
				instructor = new Instructor(newInstructor, newSurname, ageOfInstructor);
				/*
				 * burda ilk olarak listeden güncellenen kişiyi çıkarıyoruz çunkü
				 * güncellediğimizde nesne sabit kalıp değerler değişiyor alttaki for
				 * dögususndede hata oluşturuyor bu yüzden ilk silecez ve baska degerler
				 * karşılaştrılılacak
				 */
				instructors.remove(instructor);
				// buranın ana mantığı degiştrilen nesne daha önceden eklenmişmi diye kontrol
				// ediyoruz
				// burda sorun var
				for (Instructor instructor3 : instructors) {
					int sizeOfList = instructors.size();
					if (instructor.getInstructorName() == instructor3.getInstructorName()
							&& instructor.getInstructorSurname() == instructor3.getInstructorSurname()
							&& instructor.getInstructorAge() == instructor3.getInstructorAge()) {
						System.out.println("***************");
						throw new Exception("this Instructor is already exist");
					}
					sizeOfList--;
					if (sizeOfList == 0) {
						instructors.add(instructor);
						instructorDao.update(instructor);

						break;
					}
				}
				break;
			}

		}
	}
}
