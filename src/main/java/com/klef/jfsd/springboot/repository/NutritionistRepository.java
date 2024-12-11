package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Nutritionist;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer> 
{
    @Query("select n from Nutritionist n where n.email=?1")
    public Nutritionist findByEmail(String email);

    public List<Nutritionist> findByexpertise(String expertise);

    @Query("select n.blogs from Nutritionist n where n.id=?1")
    public List<String> findBlogsByNutritionistId(int id);

    @Query("select n.testimonials from Nutritionist n where n.id=?1")
    public List<String> findTestimonialsByNutritionistId(int id);
}
