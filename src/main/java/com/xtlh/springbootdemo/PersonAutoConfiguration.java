package com.xtlh.springbootdemo;

import com.xtlh.springbootdemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PersonProperties.class)
@ConditionalOnClass(Person.class)
@ConditionalOnProperty(prefix = "person", value = "enabled", matchIfMissing = true)
public class PersonAutoConfiguration
{
    @Autowired
    private PersonProperties personProperties;

    @Bean
    @ConditionalOnMissingBean(Person.class)
    public Person person()
    {
        Person person = new Person();
        person.setAge(personProperties.getAge());
        person.setName(personProperties.getName());

        return person;
    }
}
