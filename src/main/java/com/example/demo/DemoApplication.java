package com.example.demo;

import com.example.demo.repos.AdviceRepo;
import com.example.demo.repos.FileRepo;
import com.example.demo.repos.HistoryRecordRepo;
import com.example.demo.repos.UserRepo;
import com.example.demo.resolver.Query;
import com.example.demo.resolver.advice.AdviceMutation;
import com.example.demo.resolver.advice.AdviceQuery;
import com.example.demo.resolver.file.FileMutation;
import com.example.demo.resolver.file.FileQuery;
import com.example.demo.resolver.historyRecord.HistoryRecordMutation;
import com.example.demo.resolver.historyRecord.HistoryRecordQuery;
import com.example.demo.resolver.resolvers.AdviceResolver;
import com.example.demo.resolver.resolvers.FileResolver;
import com.example.demo.resolver.user.UserMutation;
import com.example.demo.resolver.user.UserQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	//resolvers
	@Bean
	public AdviceResolver adviceResolver(UserRepo userRepo) {
		return new AdviceResolver(userRepo);
	}
	@Bean
	public FileResolver fileResolver(HistoryRecordRepo historyRecordRepo){
		return new FileResolver(historyRecordRepo);
	}

	//queries
	@Bean
	public Query query(){
		return new Query();
	}
	@Bean
	public AdviceQuery adviceQuery(AdviceRepo adviceRepo){
		return new AdviceQuery(adviceRepo);
	}
	@Bean
	public UserQuery userQuery(UserRepo userRepo){
		return new UserQuery(userRepo);
	}
	@Bean
	public FileQuery fileQuery(FileRepo fileRepo){
		return new FileQuery(fileRepo);
	}
	@Bean
	public HistoryRecordQuery  historyRecordQuery(HistoryRecordRepo historyRecordRepo){
		return new HistoryRecordQuery(historyRecordRepo);
	}


	//mutations
	@Bean
	public UserMutation userMutation(UserRepo userRepo){
		return new UserMutation(userRepo);
	}
	@Bean
	public AdviceMutation adviceMutation(AdviceRepo adviceRepo, UserRepo userRepo){
		return new AdviceMutation(adviceRepo,userRepo);
	}
	@Bean
	public FileMutation fileMutation(FileRepo fileRepo, HistoryRecordRepo historyRecordRepo){
		return new FileMutation(fileRepo, historyRecordRepo);
	}
	@Bean
	public HistoryRecordMutation historyRecordMutation(FileRepo fileRepo, HistoryRecordRepo historyRecordRepo){
		return new HistoryRecordMutation(historyRecordRepo, fileRepo);
	}
}
