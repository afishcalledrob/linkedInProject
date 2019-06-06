package com.fdmgroup.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@Autowired
	PictureRepo prep;
	@Autowired
	UserRepo urep;
	@Autowired
	CommentRepo crep;
	@Autowired
	ConnectionRepo corep;
	@Autowired
	LikeRepo lrep;
	@Autowired
	MessageRepo mrep;
	@Autowired
	PostRepo porep;
	@Autowired
	CompanyRepo comrep;
	@Autowired
	UserProfileRepo uprep;
	@Autowired
	CompanyProfileRepo cprep;

   @RequestMapping("/home")
   public String doWork() {
	   
	   Picture picture = new Picture();
	   Picture picture2 = new Picture();
	   //picture.setPictureId(23);
	   
	   Comment comment = new Comment();
	   Connection connection = new Connection();
	   Like like = new Like();
	   Message message = new Message();
	   Post post = new Post();
	   User user = new User("hello", picture, "Owen", "Raymond", "a", "owen@sdasd", false);
	   Company company = new Company("FDM", null, "b", "fdm@fdmgroup", "London", "IT");
	   UserProfile userProfile = new UserProfile(user, "work for FDM", "FDM employs me", "school", "NA", "NA");
	   CompanyProfile companyProfile = new CompanyProfile(company, "we are a company", "we are a global company");
	   
	   prep.save(picture);
	   prep.save(picture2);
	   crep.save(comment);
	   corep.save(connection);
	   lrep.save(like);
	   mrep.save(message);
	   porep.save(post);
	   urep.save(user);
	   comrep.save(company);
	   uprep.save(userProfile);
	   cprep.save(companyProfile);
	   
	   return "Greeting";
   }
	
	
}
