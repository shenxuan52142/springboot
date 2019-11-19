package com.shenxuan.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//SpringBoot的核心注解，主要是开启自动配置
@SpringBootApplication(
		exclude = {MongoAutoConfiguration.class, DataSourceAutoConfiguration.class}
)
@RestController
//@ImportResource({})
public class SpringbootApplication {
//	@Value("${book.author}")
//	private String bookAuthor;
//	@Value("${book.name}")
//	private String bookName;
//	@RequestMapping("/")
//    String index(){
//		return "book name is : " + bookName + " and book author is :" + bookAuthor;
//	}
//	@SuppressWarnings("all")
//	@Autowired
//	HelloService helloService;
//	@RequestMapping(value = "/im/ceshi",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
//    public String index(@RequestBody JSONObject jsonObject){
//		return helloService.sayHello();
//    }
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
@RequestMapping(
		value = {"/im/ceshi"},
		method = {RequestMethod.GET},
		produces = {"application/json;charset=UTF-8"}
)
public void ceshi() {
	Money.getAllGupiao();

}
}
