package com.yun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yun.service.PrototypeService;
import com.yun.service.ScopeService;
import com.yun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * 控制器使用示例
 */

@SpringBootApplication
@Controller
public class YunApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(YunApplication.class, args);
	}
	
	/*
	 * 返回字符串
	 * 调用示例 : localhost:8080
	 */
	@ResponseBody
	@RequestMapping("/")
	public String greeting() {	
		return "Hello World!";
	}
	
	/*
	 * 不带参数的模版渲染
	 * 调用示例 : localhost:8080/index
	 */
	@RequestMapping("/index")
	public String index() {	
		return "index";
	}
	
	/*
	 * 带参数的模版渲染（/风格）
	 * 调用示例 : localhost:8080/hello/1/jackie
	 */
	@RequestMapping("/hello/{id}/{name}")
    public String hello(@PathVariable("id") String id, @PathVariable("name") String name,Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "hello";
    }
	
	/*
	 * 带参数的模版渲染（?风格）
	 * 调用示例 : http://localhost:8080/hello?id=1&name=jackie
	 */
    @RequestMapping(value = "/hello")
    public String hello2(@RequestParam String id, @RequestParam String name, Model model) {
    	model.addAttribute("id", id);
    	model.addAttribute("name", name);
        return "hello";
    }
    
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping("/database/{id}")
    public String hello(@PathVariable("id") Integer id) {

        return userService.getById(id).getName();
    }
    
    @Autowired
    private ScopeService scopeService;
    
    @ResponseBody
    @RequestMapping("/setscopeid/{id}")
    public String setScopeId(@PathVariable("id") Integer id) {
        scopeService.setScopeId(id);
        return "id is set by " + id;
    }
    
    @ResponseBody
    @RequestMapping("/getscopeid")
    public String getScopeId() {
        return scopeService.getScopeId();
    }
}
