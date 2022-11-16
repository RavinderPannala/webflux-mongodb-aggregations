package com.nisum.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SwaggerDefinition
//@EnableWebMvc
//@EnableSwagger2
//@EnableWebFlux
//@OpenAPIDefinition(info = @Info(title = "Swagger Demo", version = "1.0", description = "Documentation APIs v1.0"))
@SpringBootApplication
public class TaskApplication //extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//       return application.sources(TaskApplication.class);
//    }
//
//    @Bean
//    public Docket api() { 
//       return new Docket(DocumentationType.SWAGGER_2)  
//         .select()                                  
//         .apis(RequestHandlerSelectors.any())
//         .paths(PathSelectors.any()) 
//         .build();
//         //.apiInfo(apiInfo());                                           
//    }
}

//    private ApiInfo apiInfo() {
//         return new ApiInfo(
//             "API XXXX", 
//             "API XXXX para integrações entre sistemas.", 
//             "API V1", 
//             "Terms of service", 
//           //  new Contact("XXXX", "www.XXXX.com", "XXXX.XXXX@XXXX.com"), 
//             "License of XXX", "API license URL", Collections.emptyList());
//        }
//    }
	
//	@Bean
//	   public Docket productApi() {
//	      return new Docket(DocumentationType.SWAGGER_2).select()
//	         .apis(RequestHandlerSelectors.basePackage("com.nisum.task")).build();
//	   }


