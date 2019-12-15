package com.lk.test.vuestudy.security.jwt;

import com.lk.test.vuestudy.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 *
 * @author longke
 * @date 2019/12/12 21:56
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    private static Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //未带有header信息的请求放行
//        String header = request.getHeader("Authorization");
//        if (header == null || !header.startsWith("Bearer ")) {
//            chain.doFilter(request, response);
//            return;
//        }
        Object o = SecurityContextHolder.getContext().getAuthentication();
        try {
            //实际上token能够成功解密就说明登录有效，除非密钥泄露
            // 如果要进一步加强token安全性，1.token再加密 2.将token里的信息进一步加密
            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
//            getAuthenticationManager().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("token验证异常", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw e;
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (StringUtils.isNotBlank(token)) {
                // parse the token.
//                String userName = Jwts.parser()
//                        .setSigningKey("MyJwtSecret")
//                        .parseClaimsJws(token.replace("Bearer ", ""))
//                        .getBody()
//                        .getSubject();
//                logger.info("{}", userName);

                Claims claims = Jwts.parser().setSigningKey("MyJwtSecret").parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody();
                String username = claims.getSubject();
                List authorities = claims.get("auth", List.class);
//                List<GrantedAuthority> authorities = (List)claims.get("auth");
                return new UsernamePasswordAuthenticationToken(username, null, null);
            } else {
                logger.error("http header 【Authorization】is blank");
                throw new BusinessException("401", "无验证信息");
            }
        } catch (ExpiredJwtException e) {
            logger.error("token失效", e);
            throw e;
        } catch (Exception e) {
            logger.error("token解码错误", e);
            throw e;
        }
    }

    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        Object o = authResult.getPrincipal();
        super.onSuccessfulAuthentication(request, response, authResult);
    }
}
