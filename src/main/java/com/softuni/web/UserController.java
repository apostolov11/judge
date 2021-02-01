package com.softuni.web;

import com.softuni.model.biding.UserLoginBidingModel;
import com.softuni.model.biding.UserRegisterBidingModel;
import com.softuni.model.service.UserServiceModel;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBidingModel")) {
            model.addAttribute("userLoginBidingModel", new UserRegisterBidingModel());
            model.addAttribute("notFound",false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBidingModel userLoginBidingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBidingModel",userLoginBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",bindingResult);
            return "redirect:login";
        }

        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBidingModel.getUsername(),userLoginBidingModel.getPassword());

        if (user == null) {
            redirectAttributes.addFlashAttribute("userLoginBidingModel",userLoginBidingModel);
            redirectAttributes.addFlashAttribute("notFound",true);

            return "redirect:login";
        }
        httpSession.setAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBidingModel")) {
            model.addAttribute("userRegisterBidingModel",new UserRegisterBidingModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBidingModel.getPassword().equals(userRegisterBidingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBidingModel" , userRegisterBidingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBidingModel",bindingResult);
            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterBidingModel,UserServiceModel.class);

        userService.registerUser(userServiceModel);

        return "redirect:login";
    }
}
