package ru.digitalhack.model;

import lombok.Data;

@Data
public class Material {
    String material_type;
    String material_id;
    String created_at;
    String updated_at;
    String profile_id;
    String own_material;
    String moderation_status;
    String license_type_id;
    String time_to_study;
    String accepted_at;
    String author_name;
    String material_category_id;
    String book_type_id;
    String book_content_type_id;
    String publisher_id;
    String authors;
    String title;
    String ebook_id;
    String average_rating;
    UserVotes user_votes;
    String book_id;
    String version;
    Cover cover;
    String subject;
}
