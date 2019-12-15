package com.lk.test.vuestudy.controller;

import com.lk.test.vuestudy.common.BaseController;
import com.lk.test.vuestudy.common.BaseResult;
import com.lk.test.vuestudy.dto.LoginUserDto;
import com.lk.test.vuestudy.dto.SignUpDto;
import com.lk.test.vuestudy.service.PermissionService;
import com.lk.test.vuestudy.service.UserService;
import com.lk.test.vuestudy.vo.ResourceItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/11 09:18
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        logger.info("test");
        return "test";
    }


    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
        return ResponseEntity.ok("signUp success");
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public ResponseEntity signIn(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "getUserMenu")
    public BaseResult<List<ResourceItem>> getUserMenu() {

        Object obj = SecurityContextHolder.getContext();
        logger.info("123456");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<ResourceItem> resourceItems = permissionService.getMenuList(userDetails.getUserId());
//        return successWithData(resourceItems);
        return null;
    }

}
