import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ChartTest {

        private static WebDriverWait wait;

        private static WebDriver driver;
        private static String baseUrl;

    @BeforeClass
        public static void initDriver() {
            System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/chromedriver");
            driver = new ChromeDriver();
            baseUrl = "http://www.highcharts.com";
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get(baseUrl + "/demo/line-basic");
            wait = new WebDriverWait(driver, Duration.ofMillis(10), Duration.ofMillis(100));
        }

        @AfterClass
        public static void tearDown() {
            driver.close();
        }

        @Test
        public void elementTest() {
            WebElement element = driver.findElement(By.xpath(".//*[@id='highcharts-3s9korn-0']"));
            System.out.println("element text " + element.getText());
            System.out.println("element getTagName " + element.getTagName());
        }

        @Test
        public void baseTest() {
            driver.findElement(By.linkText("Basic line")).click();
            WebElement element = driver.findElement(By.id("highcharts-3s9korn-0"));
            WebElement legend = driver.findElement(By.cssSelector("g.highcharts-legend"));
            WebElement toolTip = driver.findElement(By.cssSelector("g.highcharts-tooltip"));
            System.out.println("is char displayed " + wait.until(webDriver -> ExpectedConditions.presenceOfElementLocated(By.id("highcharts-3s9korn-0")).apply(webDriver)));
            System.out.println("is char isLegendDisplayed " + legend.isDisplayed());
            System.out.println("is char isLegendDisplayed " + legend.getText());
            System.out.println("is char isTooltipDisplayed " + wait.until(webDriver -> ExpectedConditions.presenceOfElementLocated(By.cssSelector("g.highcharts-tooltip")).apply(webDriver)));
        }

        @Test
        public void labelsTest() {
            driver.findElement(By.linkText("Basic line")).click();

            List<String> labels = new ArrayList<>();
            List<WebElement> axisLabels = driver.findElements(By.xpath("//*[@id=\"highcharts-3s9korn-0\"]/svg/g[3]"));
            List<WebElement> xAxisLabels = axisLabels.get(0).findElements(By.cssSelector("text"));

            for (WebElement xAxisLabel : xAxisLabels) {
                labels.add(xAxisLabel.getText());
            }

            System.out.println("getXAxisLabelsAsArray() length" + xAxisLabels.size());
            for (WebElement label : xAxisLabels) {
                System.out.println("label : " + label.getText());
            }
        }
    }