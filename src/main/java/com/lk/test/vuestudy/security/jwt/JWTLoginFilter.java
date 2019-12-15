package com.lk.test.vuestudy.security.jwt;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lk.test.vuestudy.common.BaseResult;
import com.lk.test.vuestudy.dto.LoginUserDto;
import com.lk.test.vuestudy.security.MyUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 *
 * @author longke
 * @date 2019/12/12 21:56
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            LoginUserDto user = new ObjectMapper().readValue(req.getInputStream(), LoginUserDto.class);
            //这种认证方法只有username
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户成功登录后，这个方法会被调用在这个方法里生成token
     *
     * @param req
     * @param res
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain, Authentication auth) throws IOException, ServletException {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        // TODO: 2019/12/13 将用户信息加密 暂未实现
        Map<String, Object> claims = new HashMap<>();//创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        claims.put("auth", userDetails.getAuthorities());
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        res.addHeader("Authorization", "Bearer " + token);

        res.setStatus(HttpServletResponse.SC_OK);

        res.setCharacterEncoding("UTF-8");

        res.setContentType("application/json");
        BaseResult<MyUserDetails> result = new BaseResult<>();
        result.setCode("200");
        result.setMsg("login succeed");
        result.setData(userDetails);
        res.getWriter().println(JSONObject.toJSONString(result));

    }

}
