/**
 * @author 54chen(陈臻) [chenzhen@xiaomi.com czhttp@gmail.com]
 * @since 2012-4-10 上午11:14:46
 */
package com.chen.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.chen.model.Chen;
import com.chen.model.Test;
import com.chen.service.TestService;
import com.topshare.airshuttle.common.util.Page;

@Path("/")
public class HelloController {

	@Autowired
	private TestService tService;

	@Get("")
	public String world(Invocation inv) {
		inv.addModel("now", new Date());
		return "hello-world.jsp";
	}

	@Get("/param")
	public String param(Chen chen) throws Exception {
		return "@hello world:" + chen.getChen1() + ":" + chen.getChen2();
	}

	@Get("errorTest")
	public String errorTest() {
		int i = 3 / 0;
		return "@errorTest";
	}

	@Post("/doUpload")
	public String doUpload(@Param("file") MultipartFile multipartFile)
			throws IllegalStateException, IOException {
		System.out.println("文件长度: " + multipartFile.getSize());
		System.out.println("文件类型: " + multipartFile.getContentType());
		System.out.println("文件名称: " + multipartFile.getName());
		System.out.println("文件原名: " + multipartFile.getOriginalFilename());
		System.out.println("========================================");
		/** 拼成完整的文件保存路径加文件 **/
		String fileName = "C:\\develop\\workspace\\paoding-rose\\source\\portalWindowRose\\src\\test\\resources\\"
				+ multipartFile.getOriginalFilename();

		File file = new File(fileName);

		multipartFile.transferTo(file);

		return "@ upload ok!" + multipartFile.getOriginalFilename();
	}

	// 不声明@Param
	// files可以是一个数组或者List
	@Post("/doUploadMore")
	public String upload(MultipartFile[] files) throws IllegalStateException,
			IOException {

		for (MultipartFile multipartFile : files) {

			System.out.println("文件长度: " + multipartFile.getSize());
			System.out.println("文件类型: " + multipartFile.getContentType());
			System.out.println("文件名称: " + multipartFile.getName());
			System.out.println("文件原名: " + multipartFile.getOriginalFilename());
			System.out.println("========================================");
			/** 拼成完整的文件保存路径加文件 **/
			String fileName = "C:\\develop\\workspace\\paoding-rose\\source\\portalWindowRose\\src\\test\\resources\\"
					+ multipartFile.getOriginalFilename();

			File file = new File(fileName);

			multipartFile.transferTo(file);
		}

		return "@ upload ok!";
	}

	@Get("/jdbcTest")
	public String getTest() {
		Test t = tService.getTest();
		String s = "Hello the No." + t.getId() + " is " + t.getMsg();
		return "@" + s;
	}
	
	@Post("/insertTest")
	public String insertTest(Test test) {
		
		Integer id = tService.insertTest(test);
		System.out.println("============id:"+id);
		return "@" + id;
	}

	@Post("/searchTest")
	public String searchTest(Test searchTest) {
		
		Page<Test> page = tService.getPageByParam(searchTest,1,1);
		if(page.getItems() != null){
			
			for(Test test : page.getItems()){
				
				System.out.println(test.getMsg());
			}
		}
		return "@searchTest";
	}
	
	@PriCheckRequired
	@Get("test")
	public String test(Model model) {
		return "@test";
	}

	@Get("helloWorld")
	public String helloWorld(Model model) {
		return "helloWorld";
	}
}