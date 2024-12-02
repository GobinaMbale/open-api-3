package com.eda.open_api.dto;

import java.net.URI;
import java.util.Objects;
import com.eda.open_api.dto.CategoryDTO;
import com.eda.open_api.dto.TagDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * HelloWordDTO
 */
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("HelloWord")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-02T22:23:10.737381200+01:00[Europe/Paris]", comments = "Generator version: 7.5.0")
public class HelloWordDTO {

  private Long id;

  private String name;

  private CategoryDTO category;

  @Valid
  private List<@Valid TagDTO> tags = new ArrayList<>();

  /**
   * helloWord status in the store
   */
  public enum StatusEnum {
    AVAILABLE("available"),
    
    PENDING("pending"),
    
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  public HelloWordDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public HelloWordDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "doggie", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HelloWordDTO category(CategoryDTO category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

  public HelloWordDTO tags(List<@Valid TagDTO> tags) {
    this.tags = tags;
    return this;
  }

  public HelloWordDTO addTagsItem(TagDTO tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  */
  @Valid 
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tags")
  public List<@Valid TagDTO> getTags() {
    return tags;
  }

  public void setTags(List<@Valid TagDTO> tags) {
    this.tags = tags;
  }

  public HelloWordDTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * helloWord status in the store
   * @return status
  */
  
  @Schema(name = "status", description = "helloWord status in the store", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HelloWordDTO helloWord = (HelloWordDTO) o;
    return Objects.equals(this.id, helloWord.id) &&
        Objects.equals(this.name, helloWord.name) &&
        Objects.equals(this.category, helloWord.category) &&
        Objects.equals(this.tags, helloWord.tags) &&
        Objects.equals(this.status, helloWord.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, category, tags, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HelloWordDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

