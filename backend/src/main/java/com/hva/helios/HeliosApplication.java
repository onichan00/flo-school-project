package com.hva.helios;

import com.hva.helios.data.EventData;
import com.hva.helios.data.SkillData;
import com.hva.helios.models.Event;
import com.hva.helios.models.Project;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.repositories.interfaces.EntityRepository;
import com.hva.helios.repositories.interfaces.jpa.EventJPARepository;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.repositories.user.UserSkillJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class HeliosApplication implements CommandLineRunner {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HeliosApplication.class, args);
	}

	@Autowired
	private EntityRepository<Skill> skillRepo;

	@Autowired
	private UserJPARepository userRepository;

	@Autowired
	private SpecialistJPARepository specialistRepo;

	@Autowired
	private EventJPARepository eventRepo;

	@Autowired
	private ProjectJPARepository projectRepo;

	@Autowired
	private UserSkillJPARepository userSkillRepo;

	@Autowired
	private EntityRepository<AvailableHour> availableHourRepo;

	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("Running CommandLine Startup");

//		createInitialSkillData();
//		createInitialHoursData();
//		createInitialEvents();
//		createInitialUserSkill();
	}

	private void createInitialHoursData() {
		List<AvailableHour> hours = availableHourRepo.findAll();
		List<Specialist> specialists = specialistRepo.findAll();
		if (hours.size() > 0) return;
		System.out.println("Configuring some initial hours in the repository");

		AvailableHour hour = new AvailableHour();

		for (Specialist specialist : specialists) {
			specialist.setHours(hour);
		}
	}

	private void createInitialEvents() {
		List<Event> events = eventRepo.findAll();
		if (events.size() > 0) return;
		System.out.println("Configuring some initial events in the repository");

		Specialist specialist = userRepository.findByEmail("specialist").getSpecialist();
		Project project = projectRepo.findAll().get(0);
		EventData eventData = new EventData(specialist);

		for (Event event : eventData.getEvents()) {
			eventRepo.save(event);

			event.associateSpecialist(specialist);
			event.associateProject(project);
		}
	}

	private void createInitialSkillData() {
		List<Skill> skills = skillRepo.findAll();
		if (skills.size() > 0) return;
		System.out.println("Configuring some initial skills in the repository");

		SkillData skillData = new SkillData();

		for (Skill skill : skillData.getAvailableSkills()) {
			skillRepo.save(skill);
		}
	}

	private void createInitialUserSkill() {
		Skill skill = skillRepo.findAll().get(0);
		Specialist specialist = userRepository.findByEmail("specialist").getSpecialist();
		List<UserSkill> userSkills = userSkillRepo.findAll();
		if (userSkills.size() > 0) return;
		System.out.println("Configuring some initial user skills in the repository");

		UserSkill userSkill = new UserSkill(skill, 4, specialist);

		userSkillRepo.save(userSkill);
		specialist.associateUserSkill(userSkill);
	}
//
//	private void createInitialProjectData() {
//		List<Project> projects = projectRepo.findAll();
//		if (projects.size() > 0) return;
//		System.out.println("Configuring some initial project in the repository");
//
//		ProjectData projectData = new ProjectData();
//
//		for (Project project : projectData.getProjects()) {
//			projectRepo.save(project);
//		}
//	}
//
//	private void createInitialSpecialistData() {
//		List<Specialist> specialists = specialistRepo.findAll();
//		if (specialists.size() > 0) return;
//		System.out.println("Configuring some initial specialists in the repository");
//
//		SpecialistData specialistData = new SpecialistData();
//
//		for (Specialist specialist : specialistData.getSpecialists()) {
//			Set<UserSkill> userSkills = new HashSet<>(List.of(
//					new UserSkill(skillRepo.findAll().get(0), 1, specialist),
//					new UserSkill(skillRepo.findAll().get(1), 2, specialist),
//					new UserSkill(skillRepo.findAll().get(2), 3, specialist)
//			));
//
//			List<Project> definedProjects = projectRepo.findAll();
//
//			Set<Project> projects = new HashSet<>(List.of(
//					definedProjects.get(0),
//					definedProjects.get(1)
//			));
//
//			specialist.setSkills(userSkills);
//			specialist.setProjects(projects);
//
//			specialistRepo.save(specialist);
//		}
//	}
//
//	private void createInitialClientData() {
//		List<Client> clients = clientRepo.findAll();
//		if (clients.size() > 0) return;
//
//		System.out.println("Configuring some initial clients in the repository");
//
//		ClientData clientData = new ClientData();
//
//		for (Client client : clientData.getClients()) {
//			clientRepo.save(client);
//		}
//	}
//
//	private void createInitialAdminData() {
//		List<Admin> admins = adminRepo.findAll();
//		if (admins.size() > 0) return;
//
//		System.out.println("Configuring some initial admins in the repository");
//
//		AdminData adminData = new AdminData();
//
//		for (Admin admin : adminData.getAdmins()) {
//			adminRepo.save(admin);
//		}
//
//	}
}
