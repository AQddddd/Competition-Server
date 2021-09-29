//package org.xpef.server.controller;
//
//
//import core.util.Common;
//import core.util.ResponseCode;
//import core.util.ResponseUtil;
//import core.util.Result;
//
//import org.xpef.server.service.UserService;
//import io.swagger.annotations.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//
//
//@Api(value = "后端", tags = "user")
//@RestController
//@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
//public class OldUserController {
//    private  static  final Logger logger = LoggerFactory.getLogger(OldUserController.class);
//
//    @Autowired
//    private UserService userService;
//
//    @ApiOperation(value = "用户登录", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "body", dataType = "LoginVo", name = "loginVo", value = "用户名与密码", required = true),
//    })
//    @ApiResponses({
//            @ApiResponse(code = 0, message = "成功"),
//            @ApiResponse(code = 507, message = "信息签名不正确"),
//            @ApiResponse(code = 600, message = "用户名或者密码错误"),
//            @ApiResponse(code = 601, message = "邮箱账号不存在"),
//    })
//    @PostMapping(path = "login")
//    public Object userLogin(@RequestBody LoginVo loginVo, BindingResult bindingResult, HttpServletResponse http){
//        Object returnObject = Common.processFieldErrors(bindingResult, http);
//        if(returnObject != null){
//            return returnObject;
//        }
//        Result ret=userService.login(loginVo.getEmail(),loginVo.getPassword());
//        if (ret.getCode()== ResponseCode.OK&&ret.getData()!=null){
//            http.setStatus(201);
//            return ResponseUtil.ok((String)ret.getData());
//        }else{
//            return ResponseUtil.fail(ret.getCode(),ret.getErrmsg());
//        }
//    }
//
//    @ApiOperation(value = "用户注册", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "body", dataType = "RegisterVo", name = "registerVo", value = "用户名,密码,验证码", required = true),
//    })
//    @ApiResponses({
//            @ApiResponse(code = 0, message = "成功"),
//            @ApiResponse(code = 602, message = "邮箱已被注册"),
//            @ApiResponse(code = 603, message = "验证码不正确或已过期"),
//    })
//    @PostMapping(path = "register")
//    public Object userRegister(@RequestBody RegisterVo registerVo, BindingResult bindingResult, HttpServletResponse http){
//        Object returnObject = Common.processFieldErrors(bindingResult, http);
//        if(returnObject != null){
//            return returnObject;
//        }
//        Result ret=userService.register(registerVo.getEmail(),registerVo.getPassword(),registerVo.getCode());
//        if (ret.getCode()== ResponseCode.OK){
//            http.setStatus(201);
//            return ResponseUtil.ok();
//        }else{
//            return ResponseUtil.fail(ret.getCode(),ret.getErrmsg());
//        }
//    }
//
//    @ApiOperation(value = "发送验证码", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "body", dataType = "SendVerCodeVo", name = "vo", value = "邮箱", required = true),
//    })
//    @ApiResponses({
//            @ApiResponse(code = 0, message = "成功"),
//    })
//    @PostMapping(path = "verify_code")
//    public Object sendVerifyCode(@RequestBody SendVerCodeVo vo,
//                                 BindingResult bindingResult,
//                                 HttpServletResponse http){
//        Object returnObject = Common.processFieldErrors(bindingResult, http);
//        if(returnObject != null){
//            return returnObject;
//        }
//        Result ret=userService.sendCodeByEmail(vo.getEmail());
//        if (ret.getCode()== ResponseCode.OK){
//            http.setStatus(201);
//            return ResponseUtil.ok();
//        }else{
//            return ResponseUtil.fail(ret.getCode(),ret.getErrmsg());
//        }
//    }
//
//    @ApiOperation(value = "验证验证码", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "email", value = "邮箱", required = true),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "code", value = "验证码", required = true),
//    })
//    @ApiResponses({
//            @ApiResponse(code = 0, message = "成功"),
//            @ApiResponse(code = 603, message = "验证码不正确或者已过期")
//    })
//    @GetMapping(path = "verify_code")
//    public Object verifyCode(@RequestParam(value = "email") String email,
//                             @RequestParam(value = "code") String code){
//        if (email==null||code==null){
//            return ResponseUtil.fail(ResponseCode.FIELD_NOTVALID);
//        }
//        Result ret=userService.verify(email,code);
//        if (ret.getCode()==ResponseCode.OK){
//            return ResponseUtil.ok();
//        }else {
//            return ResponseUtil.fail(ret.getCode(), ret.getErrmsg());
//        }
//    }
//
//    @ApiOperation(value = "重置密码", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "body", dataType = "ResetPasVo", name = "vo", value = "重置密码信息", required = true)
//    })
//    @ApiResponses({
//            @ApiResponse(code = 0, message = "成功"),
//            @ApiResponse(code = 603, message = "验证码不正确或者已过期")
//    })
//    @PutMapping(path = "password")
//    public Object resetPassword(@RequestBody ResetPasVo vo,
//                                BindingResult bindingResult,
//                                HttpServletResponse httpServletResponse){
//        Object returnObject = Common.processFieldErrors(bindingResult,httpServletResponse);
//        if(returnObject != null){
//            return returnObject;
//        }
//        Result ret=userService.resetPassword(vo.getEmail(),vo.getNewPassword());
//        if (ret.getCode()==ResponseCode.OK){
//            return ResponseUtil.ok();
//        }else {
//            return ResponseUtil.fail(ret.getCode(), ret.getErrmsg());
//        }
//    }
//
//
//
//
//
//}
