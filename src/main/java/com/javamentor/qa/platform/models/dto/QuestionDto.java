package com.javamentor.qa.platform.models.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "вопросы")
public class QuestionDto {

  @Parameter(description = "id вопроса")
  private Long id;
  @Schema(description = "заголовок вопроса")
  private String title;
  @Schema(description = "id автора")
  private Long authorId;
  @Schema(description = "имя автора")
  private String authorName;
  @Schema(description = "ссылка на изображение автора")
  private String authorImage;
  @Schema(description = "описание вопроса")
  private String description;
  @Schema(description = "количество просмотров")
  private Long viewCount;
  @Schema(description = "репутация автора")
  private Long authorReputation;
  @Schema(description = "количество ответов на вопрос")
  private Long countAnswer;
  @Schema(description = "рейтинг вопроса")
  private Long countValuable;
  @Schema(description = "дата создания вопроса")
  private LocalDateTime persistDateTime;
  @Schema(description = "дата последнего обновления")
  private LocalDateTime lastUpdateDateTime;
  @Schema(description = "кол-во голосов за вопрос")
  private Long countVote;
  // @Schema(description = "голос авторизованного пользователя за вопрос")
  //private VoteTypeQ voteType;
  //@Schema(description = "список тэгов")
  //private List<TagDto> listTagDto;

}
