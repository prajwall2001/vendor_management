/*
 * package com.xworkz.vmanagement.resource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc;
 * 
 * import com.xworkz.vmanagement.service.AdminLoginService;
 * 
 * @RestController
 * 
 * @RequestMapping("/")
 * 
 * @EnableWebMvc public class AdminLoginAjaxController {
 * 
 * @Autowired private AdminLoginService service;
 * 
 * @GetMapping(value = "/adminLoginMailAjax/{email}") public String
 * adminLoginEmailAjax(@PathVariable String email) {
 * System.out.println("Checking for mail :"+email);
 * System.out.println("Invoking the adminLoginEmailAjax().."); return
 * this.service.emailAdminLoginAjax(email); }
 * 
 * @GetMapping(value = "/adminLoginPassAjax/{password}") public String
 * adminLoginPasswordAjax(@PathVariable String password) {
 * System.out.println("Checking for password :"+password);
 * System.out.println("Invoking the adminLoginPassAjax().."); return
 * this.service.passwordAdminLoginAjax(password); }
 * 
 * }
 */