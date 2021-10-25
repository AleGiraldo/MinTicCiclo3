/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ale Giraldo
 */
@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    protected void cofigure(HttpSecurity http) throws Exception{
        http.authorizeRequests(a ->
                                .antMatches(antPatters: ))
    }
}
