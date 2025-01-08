package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.crawling.TeamRanking;
import umc.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		//웹 크롤링
		TeamRanking teamRanking = new TeamRanking();
		try {
			teamRanking.process();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	//다음 주차 실습에서 번거로워서 주석 걺
	/*@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);


			//네번째 미션
			System.out.println("------------------마이페이지 화면 QueryDSL ------------------");
			MemberQueryService memberQueryService = context.getBean(MemberQueryService.class);

			Long memberId = 1L;

			memberQueryService.findMember(memberId)
					.forEach(System.out::println);

		};
	}*/
}
