package com.example.demo;
import com.example.demo.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {
	ArrayList<Todo> list = new ArrayList<>();
	int count = 1;
	@GetMapping("/list")
	ArrayList<Todo> getList(){
		return list;
	}

	@PostMapping ("/list")
	String addItem(@RequestBody String item){
		list.add(new Todo(count++ , item));
		return "Success";
	}
	@DeleteMapping ("/list/delete/{id}")
	String deleteItem(@PathVariable int id){
		Todo remove = null;
		for (Todo todo : list) {
			if (todo.getId() == id) {
				remove = todo;
			}
		}
		if(remove != null){
			list.remove(remove);
		}
		return "Delete Success";
	}
	@PostMapping ("/list/update/{id}")
	String updateItem(@PathVariable int id, @RequestBody String item){
		for (Todo todo : list) {
			if (todo.getId() == id) {
				todo.setItem(item);
			}
		}
		return "Update Success";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
