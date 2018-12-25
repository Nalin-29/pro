package com.ntl.movieapp.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/*
 * author:Ishanya
 * Date:22/11/2018
 * NIIT Tech.
 */

@EnableFeignClients("com.ntl.movieapp.search")
@SpringBootApplication
@EnableDiscoveryClient
public class SearchApplication
{
	/*
	 * main method
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(SearchApplication.class, args);
		
	}
	
	/*
	 * Default Sampler
	 */
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
		
	}
}
