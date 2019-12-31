package com.controller;

import com.service.MovieService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class MovieRecommenderController {
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;

    private final int PAGE_SIZE = 20;

    private final int CUR_PAGE = 1;
    // 推荐结果个数
    private final int RECOMMENDER_NUM = 2;

    @RequestMapping(value = {"/", "/mahout/user"})
    public String userlist(Model model, @RequestParam(value = "pageno", defaultValue = "1") int currPage) {
        currPage = currPage > 0 ? currPage : CUR_PAGE;
        List users = userService.queryUsersBySql(currPage, PAGE_SIZE);
        model.addAttribute("userList", users);
        model.addAttribute("pageno", currPage);
        return "/userlist";
    }

    @RequestMapping(value = "/mahout/recommend")
    public String recommendlist(Model model, @RequestParam(value = "userid", defaultValue = "1") int userID) {
        List moviesRBU = movieService.recommendMoviesBasedUser(userID, RECOMMENDER_NUM);
        List moviesRBI = movieService.recommendMoviesBasedItem(userID, RECOMMENDER_NUM);
        List lookedMovies = movieService.queryLookedMoviesByUser(userID);
        model.addAttribute("lookedMovies", lookedMovies);
        model.addAttribute("moviesRBU", moviesRBU);
        model.addAttribute("moviesRBI", moviesRBI);
        return "/recommendlist";
    }

}
