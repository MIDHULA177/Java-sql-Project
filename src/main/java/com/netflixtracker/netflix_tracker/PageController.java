package com.netflixtracker.netflix_tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PageController {

    private final MovieRepository movieRepo;
    private final UserRepository userRepo;  // Assuming this is defined
    private final WatchHistoryRepository historyRepo;  // Assuming this is defined
    private final RecommendationRepository recRepo;  // Assuming this is defined

    public PageController(MovieRepository movieRepo, UserRepository userRepo,
                          WatchHistoryRepository historyRepo, RecommendationRepository recRepo) {
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
        this.historyRepo = historyRepo;
        this.recRepo = recRepo;
    }

    @GetMapping("/")
    public String index() {
        return "index";  // Returns the "index.html" view
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = movieRepo.findAll();  // Fetch all movies
        model.addAttribute("movies", movies);  // Add to model
        model.addAttribute("newMovie", new Movie());  // For form binding
        return "movies";  // Returns the "movies.html" view
    }

    @PostMapping("/movies/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movieRepo.save(movie);  // Save the movie
        return "redirect:/movies";  // Redirect to the movies page
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userRepo.findAll();  // Fetch all users
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());  // For form binding
        return "users";  // Returns the "users.html" view
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/users";
    }

    @GetMapping("/watch-history")
    public String watchHistory(Model model) {
        List<WatchHistory> history = historyRepo.findAll();
        List<User> users = userRepo.findAll();
        List<Movie> movies = movieRepo.findAll();

        model.addAttribute("history", history);
        model.addAttribute("users", users);
        model.addAttribute("movies", movies);
        model.addAttribute("newHistory", new WatchHistory());  // For form binding
        return "watch-history";  // Returns the "watch-history.html" view
    }

    @PostMapping("/watch-history/add")
    public String addWatchHistory(@ModelAttribute WatchHistory history) {
        history.setDateWatched(LocalDateTime.now());  // Set current time
        historyRepo.save(history);
        return "redirect:/watch-history";
    }

    @GetMapping("/recommendations")
    public String recommendations(Model model) {
        List<Recommendation> recommendations = recRepo.findAll();
        List<Movie> movies = movieRepo.findAll();

        model.addAttribute("recommendations", recommendations);
        model.addAttribute("movies", movies);
        model.addAttribute("newRec", new Recommendation());  // For form binding
        return "recommendations";  // Returns the "recommendations.html" view
    }

    @PostMapping("/recommendations/add")
    public String addRecommendation(@ModelAttribute Recommendation rec) {
        recRepo.save(rec);
        return "redirect:/recommendations";
    }
}
