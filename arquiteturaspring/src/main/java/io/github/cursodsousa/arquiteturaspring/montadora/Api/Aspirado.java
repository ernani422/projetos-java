package io.github.cursodsousa.arquiteturaspring.montadora.Api;

import org.springframework.beans.factory.annotation.*;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.METHOD}) // ou METHOD, TYPE, etc. dependendo do uso
@Retention(RetentionPolicy.RUNTIME)
@Qualifier("motorAspirado")
public @interface Aspirado {

}
//EnableWebMvc.class caso mais duvidas pequizar nele//
