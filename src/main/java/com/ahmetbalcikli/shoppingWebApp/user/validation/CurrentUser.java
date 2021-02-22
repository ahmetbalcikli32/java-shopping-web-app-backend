package com.ahmetbalcikli.shoppingWebApp.user.validation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {
}
