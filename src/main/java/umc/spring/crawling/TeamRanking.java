package umc.spring.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeamRanking {
    private WebDriver driver;

    private static final String url = "https://www.koreabaseball.com/Record/TeamRank/TeamRank.aspx";

    public void process() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pwyic\\Downloads\\chromedriver-win64\\chromedriver.exe");
        //크롬 드라이버 셋팅 (드라이버 설치한 경로 입력)
        //ChromeDriver 실행 파일의 경로를 셀레니움의 webdriver.chrome.driver 시스템 속성에 설정

        driver = new ChromeDriver();        //브라우저 선택
        driver.get(url);    //브라우저에서 url로 이동한다.
        Thread.sleep(1000); //브라우저 로딩될때까지 잠시 기다린다.


        // 드롭다운 요소 가져오기
        WebElement dropdownElement = driver.findElement(By.id("cphContents_cphContents_cphContents_ddlYear")); // 드롭다운의 id 속성 사용
        Select dropdown = new Select(dropdownElement);

        //2024년만 출력하기
        String year = "2024";
        dropdown.selectByVisibleText(year);

        getDataList(driver);
        System.out.println("Year: " + year);

        /*
        //2024-2023까지 출력되고 Stale.. Exception 뜸

        // 드롭다운의 모든 옵션 값 가져오기
        List<WebElement> options = dropdown.getOptions();

        // 드롭다운의 각 값에 대해 크롤링
        for (WebElement option : options) {
            String year = option.getText(); // 드롭다운 값
            dropdown.selectByVisibleText(year); // 드롭다운 값 선택
            Thread.sleep(1000); // 로딩 대기

            // 크롤링 코드 (예: 테이블 데이터 가져오기)
            getDataList(driver);
            System.out.println("Year: " + year);
            System.out.println("-------------------------------");
        }*/

        driver.close();	//탭 닫기
        driver.quit();	//브라우저 닫기
    }

    /**
     * data가져오기
     */
    private List<String> getDataList(WebDriver driver) {
        List<String> list = new ArrayList<>();

        WebElement tableElement = driver.findElement(By.cssSelector("table.tData"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

        // 테이블 데이터 파싱
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            StringBuilder rowData = new StringBuilder();
            for (WebElement column : columns) {
                // 텍스트를 가져와 출력
                String cellText = column.getText();
                rowData.append(cellText).append("\t");
                System.out.print(cellText + "\t"); // column.getText()를 출력
            }
            System.out.println();
            list.add(rowData.toString());
        }

        return list;
    }
}
